package com.grantburgess.usecases.Projet.get.projets;

import com.grantburgess.ports.database.ProjetGateway;
import com.grantburgess.ports.presenters.Projet.ProjetsOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Projet.get.Projets.GetProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.get.Projets.GetProjetRequest;
import com.grantburgess.ports.usescases.Projet.get.Projets.ProjetsResponse;
import com.grantburgess.usecases.Projet.get.GetProjetBase;

public class GetProjets extends GetProjetBase implements GetProjetInputBoundary {
    private final ProjetsOutputBoundary presenter;
    private final ProjetGateway offerGateway;
    private final Clock clock;

    public GetProjets(ProjetsOutputBoundary presenter, ProjetGateway offerGateway, Clock clock) {
        this.presenter = presenter;
        this.offerGateway = offerGateway;
        this.clock = clock;
    }

    public void execute(GetProjetRequest request) {
        ProjetsResponse.ProjetsResponseBuilder result = ProjetsResponse.builder();
        offerGateway.getAllProjects().forEach(offer -> result.addProjet(makeOfferResponse(offer, clock)));

        presenter.present(result.build());
    }
}
