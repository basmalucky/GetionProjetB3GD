package com.grantburgess.ports.presenters.Fonctionnalite;

import com.grantburgess.ports.usescases. Fonctionnalite.addFonctionnalite.NewFonctionnaliteResponse;

public interface FonctionnaliteCreatedOutputBoundary {
    FonctionnaliteCreatedViewModel getViewModel();
    void present(NewFonctionnaliteResponse responseModel);
}
