package com.grantburgess.application.endpoints.Lot.updateLot;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.presenters.Lot.LotCreatedViewModel;
import com.grantburgess.ports.presenters.Lot.LotOutputBoundary;
import com.grantburgess.ports.usescases.Lot.updateLot.UpdateLotInputBoundary;
import com.grantburgess.ports.usescases.Lot.updateLot.UpdateLotRequest;
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
@RequestMapping(value = "/api/v1/Lots", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UpdateLotEndpoint implements BaseEndpoint {
    private final UpdateLotInputBoundary useCase;
    private final LotOutputBoundary presenter;

    public UpdateLotEndpoint(UpdateLotInputBoundary useCase, LotOutputBoundary presenter) {
        this.useCase = useCase;
        this.presenter = presenter;

    }

    @PutMapping("update/{lotId}")
    @ApiOperation(value = "Add Lot", response = LotCreatedViewModel.class)
    public ResponseEntity execute(@ApiParam(value = "ID of the offer that needs to be fetched", required = true) @PathVariable(value = "lotId") String lotId, @RequestBody @Valid NewUpdateLotRequest request) {
        useCase.execute(
                UpdateLotRequest
                        .builder()
                        .id(UUID.fromString(lotId))
                        .nom(request.toString())
                        .description(request.getDescription())
                        .startDate(request.getDuration().getStartDate())
                        .endDate(request.getDuration().getEndDate())
                        .build()
        );

        return ResponseEntity
                .created(
                        URI.create(
                                MessageFormat.format("/api/v1/Lots/{0}", presenter.getViewModel().getId())
                        )
                )
                .body(presenter.getViewModel());
    }
}
