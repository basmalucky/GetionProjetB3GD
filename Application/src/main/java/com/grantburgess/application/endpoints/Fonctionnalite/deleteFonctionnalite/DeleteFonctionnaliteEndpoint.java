package com.grantburgess.application.endpoints.Fonctionnalite.deleteFonctionnalite;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.usescases.Fonctionnalite.delete.DeleteFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.delete.DeleteFonctionnaliteRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Fonctionnalites")
public class DeleteFonctionnaliteEndpoint implements BaseEndpoint {
    private final DeleteFonctionnaliteInputBoundary useCase;

    public DeleteFonctionnaliteEndpoint(DeleteFonctionnaliteInputBoundary useCase) {
        this.useCase = useCase;
    }

    @DeleteMapping("delete/{fonctionnaliteId}")
    @ApiOperation(value = "Delete fonctionnalite by ID")
    public ResponseEntity<Void> execute(@PathVariable(value = "fonctionnalited") String fonctionnaliteId) {
        useCase.execute(DeleteFonctionnaliteRequest.builder().id(UUID.fromString(fonctionnaliteId)).build());

        // Retournez une réponse avec un code d'état No Content (204) pour indiquer que la suppression a été effectuée
        return ResponseEntity.noContent().build();
    }
}