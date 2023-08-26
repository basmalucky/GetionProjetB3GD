package com.grantburgess.usecases.Fonctionnalite.get.fonctionnalites;

import com.grantburgess.ports.database.FonctionnaliteGateway;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnalitesOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalites.GetFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalites.GetFonctionnaliteRequest;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalites.FonctionnalitesResponse;
import com.grantburgess.usecases.Fonctionnalite.get.GetFonctionnaliteBase;

public class GetFonctionnalites extends GetFonctionnaliteBase implements GetFonctionnaliteInputBoundary {
    private final FonctionnalitesOutputBoundary presenter;
    private final FonctionnaliteGateway offerGateway;
    private final Clock clock;

    public GetFonctionnalites(FonctionnalitesOutputBoundary presenter, FonctionnaliteGateway offerGateway, Clock clock) {
        this.presenter = presenter;
        this.offerGateway = offerGateway;
        this.clock = clock;
    }

    public void execute(GetFonctionnaliteRequest request) {
        FonctionnalitesResponse.FonctionnalitesResponseBuilder result = FonctionnalitesResponse.builder();
        offerGateway.getAllFonctionnalites().forEach(offer -> result.addFonctionnalite(makeOfferResponse(offer, clock)));

        presenter.present(result.build());
    }
}
