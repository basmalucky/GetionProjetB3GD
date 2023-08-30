package com.grantburgess.application.configuration;

import com.grantburgess.ports.database.ProjetGateway;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Projet.cancelProjet.CancelProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.cancelProjet.CancelProjetRequest;

public class CancelProjet implements CancelProjetInputBoundary {
    public CancelProjet(ProjetGateway projetGateway, Clock clock) {
    }

    @Override
    public void execute(CancelProjetRequest request) {

    }
}
