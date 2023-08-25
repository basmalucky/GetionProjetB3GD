package com.grantburgess.usecases.Fonctionnalite.get.fonctionnalitebyid;


import com.grantburgess.entities.Fonctionnalite;
import com.grantburgess.ports.database.FonctionnaliteGateway;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalitebyid.GetFonctionnaliteByIdInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalitebyid.GetFonctionnaliteRequest;
import com.grantburgess.usecases.Fonctionnalite.get.GetFonctionnaliteBase;

public class GetFonctionnaliteById extends GetFonctionnaliteBase implements GetFonctionnaliteByIdInputBoundary {
    private final FonctionnaliteOutputBoundary presenter;
    private final FonctionnaliteGateway offerGateway;
    private final Clock clock;

    public GetFonctionnaliteById(FonctionnaliteOutputBoundary presenter, FonctionnaliteGateway offerGateway, Clock clock) {
        this.presenter = presenter;
        this.offerGateway = offerGateway;
        this.clock = clock;
    }

    public void execute(GetFonctionnaliteRequest request) {
        Fonctionnalite offer = offerGateway.getById(request.getId());

        if (offer == null)
            throw new FonctionnaliteGateway.fonctionnaliteNotFoundException();

        presenter.present(makeOfferResponse(offer, clock));
    }
}
