package com.grantburgess.application.endpoints.Projet.cancelProjet;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.usescases.Projet.cancelProjet.CancelProjetRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Projet")
public class CancelProjetEndpoint implements BaseEndpoint {
    private CancelProjetRequest useCase;

    public CancelProjetEndpoint(CancelProjetRequest useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/{projetId}/cancel")
    @ApiOperation(value = "Cancel Projet", response = ResponseEntity.class)
    public ResponseEntity execute(@PathVariable(value = "projetId") String projetId)
    {
        useCase.execute(CancelProjetRequest.builder().projetId(UUID.fromString(projetId)).build());

        return ResponseEntity.noContent().build();
    }
}
