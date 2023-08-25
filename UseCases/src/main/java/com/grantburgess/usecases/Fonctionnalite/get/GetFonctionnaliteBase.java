package com.grantburgess.usecases.Fonctionnalite.get;

import com.grantburgess.entities.Fonctionnalite;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Fonctionnalite.get.FonctionnaliteResponse;
import com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteResponse;

public abstract class GetFonctionnaliteBase {
    protected GetFonctionnaliteBase() { }

    public static FonctionnaliteResponse makeOfferResponse(Fonctionnalite offer, Clock clock) {
        FonctionnaliteResponse.Status offerStatus = computeStatus(offer, clock);
        return new FonctionnaliteResponse(
                offer.getId(),
                offer.getName(),
                offer.getDescription(),
                offer.getStartDate(),
                offer.getEndDate()
        );
    }

    public UpdateFonctionnaliteResponse makeUpdateFonctionnaliteResponse(Fonctionnalite updatedFonctionnalite, Clock clock) {
        //UpdateTaskResponse.Status taskStatus = computeStatus(updatedFonctionnalite, clock);
        return UpdateFonctionnaliteResponse.builder()
                .id(updatedFonctionnalite.getId())
                .build();
    }

    private static FonctionnaliteResponse.Status computeStatus(Fonctionnalite offer, Clock clock) {

        return offer.getEndDate().isAfter(clock.now()) ?
                FonctionnaliteResponse.Status.ACTIVE :
                FonctionnaliteResponse.Status.EXPIRED;
    }
}
