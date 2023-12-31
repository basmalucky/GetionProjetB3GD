package com.grantburgess.application.endpoints.Projet.deleteProjet;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.usescases.Projet.delete.DeleteProjetRequest;
import com.grantburgess.ports.usescases.Projet.delete.DeleteProjetInputBoundary;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Projet")
public class DeleteProjetEndpoint implements BaseEndpoint {
    private final DeleteProjetInputBoundary useCase;

    public DeleteProjetEndpoint(DeleteProjetInputBoundary useCase) {
        this.useCase = useCase;
    }

    @DeleteMapping("delete/{projetId}")
    @ApiOperation(value = "Delete projet by ID")
    public ResponseEntity<Void> execute(@PathVariable(value = "projetId") String projetId) {
        useCase.execute(DeleteProjetRequest.builder().id(UUID.fromString(projetId)).build());

        // Retournez une réponse avec un code d'état No Content (204) pour indiquer que la suppression a été effectuée
        return ResponseEntity.noContent().build();
    }
}
