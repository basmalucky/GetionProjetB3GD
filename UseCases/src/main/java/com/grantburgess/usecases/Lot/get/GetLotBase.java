package com.grantburgess.usecases.Lot.get;

import com.grantburgess.entities.Lot;
import com.grantburgess.entities.Lot;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Lot.get.LotResponse;
import com.grantburgess.ports.usescases.Lot.updateLot.UpdateLotResponse;

public abstract class GetLotBase {
    protected GetLotBase() { }

    public static LotResponse makeOfferResponse(Lot offer, Clock clock) {
        LotResponse.Status offerStatus = computeStatus(offer, clock);
        return new LotResponse(
                offer.getId(),
                offer.getNom(),
                offer.getDescription(),
                offer.getDateDebut(),
                offer.getDateFin()
        );
    }

    public UpdateLotResponse makeUpdateLotResponse(Lot updatedLot, Clock clock) {
        //UpdateLotResponse.Status lotStatus = computeStatus(updatedLot, clock);
        return UpdateLotResponse.builder()
                .id(updatedLot.getId())
                .build();
    }

    private static LotResponse.Status computeStatus(Lot offer, Clock clock) {

        return offer.getDateFin().isAfter(clock.now()) ?
                LotResponse.Status.ACTIVE :
                LotResponse.Status.EXPIRED;
    }
}
