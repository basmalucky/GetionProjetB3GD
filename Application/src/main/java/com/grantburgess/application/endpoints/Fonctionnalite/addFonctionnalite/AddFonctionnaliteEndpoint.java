package com.grantburgess.application.endpoints.Fonctionnalite.addFonctionnalite;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteCreatedOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteCreatedViewModel;
import com.grantburgess.ports.usescases.Fonctionnalite.addFonctionnalite.AddFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.addFonctionnalite.AddFonctionnaliteRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.text.MessageFormat;

@RestController
@RequestMapping("/api/v1/Fonctionnalites")
public class AddFonctionnaliteEndpoint implements BaseEndpoint {
    private final AddFonctionnaliteInputBoundary useCase;
    private final FonctionnaliteCreatedOutputBoundary presenter;

    public AddFonctionnaliteEndpoint(AddFonctionnaliteInputBoundary useCase, FonctionnaliteCreatedOutputBoundary presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    @PostMapping
    @ApiOperation(value = "Add Fonctionnalite", response = FonctionnaliteCreatedViewModel.class)
    public ResponseEntity execute(@RequestBody @Valid NewFonctionnaliteRequest request) {
        useCase.execute(
                AddFonctionnaliteRequest
                        .builder()
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
