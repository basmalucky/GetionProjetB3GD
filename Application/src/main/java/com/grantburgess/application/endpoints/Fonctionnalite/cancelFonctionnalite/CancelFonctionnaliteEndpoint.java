package com.grantburgess.application.endpoints.Fonctionnalite.cancelFonctionnalite;

import com.grantburgess.application.endpoints.BaseEndpoint;
import com.grantburgess.ports.usescases.Fonctionnalite.cancelFonctionnalite.CancelFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.cancelFonctionnalite.CancelFonctionnaliteRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Fonctionnalites")
public class CancelFonctionnaliteEndpoint implements BaseEndpoint {
    private CancelFonctionnaliteInputBoundary useCase;

    public CancelFonctionnaliteEndpoint(CancelFonctionnaliteInputBoundary useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/{fonctionnaliteId}/cancel")
    @ApiOperation(value = "Cancel Fonctionnalite", response = ResponseEntity.class)
    public ResponseEntity execute(@PathVariable(value = "fonctionnaliteId") String fonctionnaliteId)
    {
        useCase.execute(CancelFonctionnaliteRequest.builder().fonctionnaliteId(UUID.fromString(fonctionnaliteId)).build());

        return ResponseEntity.noContent().build();
    }
}
