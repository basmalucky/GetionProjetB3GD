package com.grantburgess.ports.presenters.Fonctionnalite;

import com.grantburgess.ports.usescases. Fonctionnalite.get. Fonctionnalites. FonctionnalitesResponse;

public interface FonctionnalitesOutputBoundary {
    FonctionnalitesViewModel getViewModel();
    void present( FonctionnalitesResponse responseModel);
}
