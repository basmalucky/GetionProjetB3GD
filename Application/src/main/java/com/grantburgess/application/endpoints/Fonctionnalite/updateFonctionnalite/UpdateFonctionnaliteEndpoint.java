package com.grantburgess.application.endpoints.Fonctionnalite.updateFonctionnalite;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteCreatedViewModel;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteOutputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.text.MessageFormat;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/Fonctionnalites", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UpdateFonctionnaliteEndpoint implements BaseEndpoint {
    private final UpdateFonctionnaliteInputBoundary useCase;
    private final FonctionnaliteOutputBoundary presenter;

    public UpdateFonctionnaliteEndpoint(UpdateFonctionnaliteInputBoundary useCase, FonctionnaliteOutputBoundary presenter) {
        this.useCase = useCase;
        this.presenter = presenter;

    }

    @PutMapping("update/{fonctionnaliteId}")
    @ApiOperation(value = "Add Fonctionnalite", response = FonctionnaliteCreatedViewModel.class)
    public ResponseEntity execute(@ApiParam(value = "ID of the offer that needs to be fetched", required = true) @PathVariable(value = "fonctionnaliteId") String fonctionnaliteId, @RequestBody @Valid NewUpdateFonctionnaliteRequest request) {
        useCase.execute(
                UpdateFonctionnaliteRequest
                        .builder()
                        .id(UUID.fromString(fonctionnaliteId))
                        .name(request.getName())
                        .description(request.getDescription())
                        .startDate(request.getDuration().getStartDate())
                        .endDate(request.getDuration().getEndDate())
                        .build()
        );

        return ResponseEntity
                .created(
                        URI.create(
                                MessageFormat.format("/api/v1/Fonctionnalites/{0}", presenter.getViewModel().getId())
                        )
                )
                .body(presenter.getViewModel());
    }
}
