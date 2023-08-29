package com.grantburgess.application.endpoints.Lot.deleteLot;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.usescases.Lot.delete.DeleteLotInputBoundary;
import com.grantburgess.ports.usescases.Lot.delete.DeleteLotRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Lots")
public class DeleteLotEndpoint implements BaseEndpoint {
    private final DeleteLotInputBoundary useCase;

    public DeleteLotEndpoint(DeleteLotInputBoundary useCase) {
        this.useCase = useCase;
    }

    @DeleteMapping("delete/{lotId}")
    @ApiOperation(value = "Delete lot by ID")
    public ResponseEntity<Void> execute(@PathVariable(value = "lotId") String lotId) {
        useCase.execute(DeleteLotRequest.builder().id(UUID.fromString(lotId)).build());

        // Retournez une réponse avec un code d'état No Content (204) pour indiquer que la suppression a été effectuée
        return ResponseEntity.noContent().build();
    }
}
