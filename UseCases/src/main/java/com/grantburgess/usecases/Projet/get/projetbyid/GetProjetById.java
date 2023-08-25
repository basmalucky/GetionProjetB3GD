package com.grantburgess.usecases.Projet.get.projetbyid;


import com.grantburgess.entities.Projet;
import com.grantburgess.ports.database.ProjetGateway;
import com.grantburgess.ports.presenters.Projet.ProjetOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Projet.get.Projetbyid.GetProjetByIdInputBoundary;
import com.grantburgess.ports.usescases.Projet.get.Projetbyid.GetProjetRequest;
import com.grantburgess.usecases.Projet.get.GetProjetBase;

public class GetProjetById extends GetProjetBase implements GetProjetByIdInputBoundary {
    private final ProjetOutputBoundary presenter;
    private final ProjetGateway offerGateway;
    private final Clock clock;

    public GetProjetById(ProjetOutputBoundary presenter, ProjetGateway offerGateway, Clock clock) {
        this.presenter = presenter;
        this.offerGateway = offerGateway;
        this.clock = clock;
    }

    public void execute(GetProjetRequest request) {
        Projet offer = offerGateway.getById(request.getId());

        if (offer == null)
            throw new ProjetGateway.projetNotFoundException();

        presenter.present(makeOfferResponse(offer, clock));
    }
}
