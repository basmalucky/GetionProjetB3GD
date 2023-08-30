package com.grantburgess.application.endpoints.Lot.getLotbyid;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.presenters.Lot.LotOutputBoundary;
import com.grantburgess.ports.presenters.Lot.LotViewModel;
import com.grantburgess.ports.usescases.Lot.get.Lotbyid.GetLotByIdInputBoundary;
import com.grantburgess.ports.usescases.Lot.get.Lotbyid.GetLotRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/Lots", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetLotByIdEndpoint implements BaseEndpoint {
    private final GetLotByIdInputBoundary useCase;
    private final LotOutputBoundary presenter;

    public GetLotByIdEndpoint(GetLotByIdInputBoundary useCase, LotOutputBoundary presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    @GetMapping("/{lotId}")
    @ApiOperation(value = "Get offer by ID", response = LotViewModel.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity execute(@ApiParam(value = "ID of the offer that needs to be fetched", required = true) @PathVariable(value = "lotId") String lotId) {
        useCase.execute(GetLotRequest.builder().id(UUID.fromString(lotId)).build());

        return ResponseEntity.ok(presenter.getViewModel());
    }
}
