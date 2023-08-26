package com.grantburgess.ports.usescases.Lot.cancelLot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CancelLotRequest {
    private UUID lotId;
}




