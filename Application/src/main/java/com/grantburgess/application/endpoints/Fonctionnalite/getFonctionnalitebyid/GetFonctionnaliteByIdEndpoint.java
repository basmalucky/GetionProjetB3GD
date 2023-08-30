package com.grantburgess.application.endpoints.Fonctionnalite.getFonctionnalitebyid;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteViewModel;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalitebyid.GetFonctionnaliteByIdInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalitebyid.GetFonctionnaliteRequest;
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
@RequestMapping(value = "/api/v1/Fonctionnalites", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetFonctionnaliteByIdEndpoint implements BaseEndpoint {
    private final GetFonctionnaliteByIdInputBoundary useCase;
    private final FonctionnaliteOutputBoundary presenter;

    public GetFonctionnaliteByIdEndpoint(GetFonctionnaliteByIdInputBoundary useCase, FonctionnaliteOutputBoundary presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    @GetMapping("/{fonctionnaliteId}")
    @ApiOperation(value = "Get offer by ID", response =FonctionnaliteViewModel.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity execute(@ApiParam(value = "ID of the offer that needs to be fetched", required = true) @PathVariable(value = "fonctionnaliteId") String fonctionnaliteId) {
        useCase.execute(GetFonctionnaliteRequest.builder().id(UUID.fromString(fonctionnaliteId)).build());

        return ResponseEntity.ok(presenter.getViewModel());
    }
}