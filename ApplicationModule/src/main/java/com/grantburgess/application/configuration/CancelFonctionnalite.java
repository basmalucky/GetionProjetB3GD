package com.grantburgess.application.configuration;

import com.grantburgess.ports.database.FonctionnaliteGateway;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Fonctionnalite.cancelFonctionnalite.CancelFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.cancelFonctionnalite.CancelFonctionnaliteRequest;

public class CancelFonctionnalite implements CancelFonctionnaliteInputBoundary {
    public CancelFonctionnalite(FonctionnaliteGateway fonctionnaliteGateway, Clock clock) {
    }

    @Override
    public void execute(CancelFonctionnaliteRequest request) {

    }
}
