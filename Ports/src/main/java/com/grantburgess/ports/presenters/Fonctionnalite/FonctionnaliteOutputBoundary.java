package com.grantburgess.ports.presenters.Fonctionnalite;

import com.grantburgess.ports.usescases. Fonctionnalite.get.FonctionnaliteResponse;

public interface FonctionnaliteOutputBoundary {
     FonctionnaliteViewModel getViewModel();
    void present( FonctionnaliteResponse responseModel);

}

