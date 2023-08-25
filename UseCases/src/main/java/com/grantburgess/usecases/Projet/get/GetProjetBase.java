package com.grantburgess.usecases.Projet.get;

import com.grantburgess.entities.Projet;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Projet.get.ProjetResponse;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetResponse;

public abstract class GetProjetBase {
    protected GetProjetBase() { }

    public static ProjetResponse makeOfferResponse(Projet offer, Clock clock) {
        ProjetResponse.Status offerStatus = computeStatus(offer, clock);
        return new ProjetResponse(
                offer.getId(),
                offer.getNom(),
                offer.getDescription(),
                offer.getDateDebut(),
                offer.getDateFin()
        );
    }

    public UpdateProjetResponse makeUpdateProjetResponse(Projet updatedProjet, Clock clock) {
        //UpdateTaskResponse.Status taskStatus = computeStatus(updatedTask, clock);
        return UpdateProjetResponse.builder()
                .id(updatedProjet.getId())
                .build();
    }

    private static ProjetResponse.Status computeStatus(Projet offer, Clock clock) {

        return offer.getDateFin().isAfter(clock.now()) ?
                ProjetResponse.Status.ACTIVE :
                ProjetResponse.Status.EXPIRED;
    }
}
