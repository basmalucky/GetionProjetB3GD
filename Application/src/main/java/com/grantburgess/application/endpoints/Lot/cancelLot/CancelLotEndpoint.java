package com.grantburgess.application.endpoints.Lot.cancelLot;
import com.grantburgess.ports.usescases.Lot.cancelLot.CancelLotInputBoundary;
import com.grantburgess.ports.usescases.Lot.cancelLot.CancelLotRequest;
import com.grantburgess.application.endpoints.BaseEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;


@RestController

@RequestMapping("/api/v1/Lots")
public class CancelLotEndpoint implements BaseEndpoint {
   private CancelLotInputBoundary useCase;

    public CancelLotEndpoint(CancelLotInputBoundary useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/{lotId}/cancel")
    @ApiOperation(value = "Cancel Lot", response = ResponseEntity.class)
    public ResponseEntity execute(@PathVariable(value = "lotId") String lotId)
    {
        useCase.execute(CancelLotRequest.builder().lotId(UUID.fromString(lotId)).build());

        return ResponseEntity.noContent().build();
    }
}
