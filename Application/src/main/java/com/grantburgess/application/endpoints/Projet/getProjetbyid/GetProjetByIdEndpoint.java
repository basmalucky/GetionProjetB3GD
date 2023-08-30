package com.grantburgess.application.endpoints.Projet.getProjetbyid;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.presenters.Projet.ProjetOutputBoundary;
import com.grantburgess.ports.presenters.Projet.ProjetViewModel;
import com.grantburgess.ports.usescases.Projet.get.Projetbyid.GetProjectByIdInputBoundary;
import com.grantburgess.ports.usescases.Projet.get.Projetbyid.GetProjetRequest;
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
@RequestMapping(value = "/api/v1/Projet", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetProjetByIdEndpoint implements BaseEndpoint {
    private final GetProjectByIdInputBoundary useCase;
    private final ProjetOutputBoundary presenter;

    public GetProjetByIdEndpoint(GetProjectByIdInputBoundary useCase, ProjetOutputBoundary presenter) {
        this.useCase = useCase;
        this.presenter = presenter;
    }

    @GetMapping("/{projetId}")
    @ApiOperation(value = "Get offer by ID", response = ProjetViewModel.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity execute(@ApiParam(value = "ID of the offer that needs to be fetched", required = true) @PathVariable(value = "projetId") String projetId) {
        useCase.execute(GetProjetRequest.builder().id(UUID.fromString(projetId)).build());

        return ResponseEntity.ok(presenter.getViewModel());
    }
}
