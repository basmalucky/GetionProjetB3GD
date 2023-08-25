package com.grantburgess.ports.presenters.Fonctionnalite;



import com.grantburgess.ports.usescases. Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteResponse;

public interface FonctionnaliteUpdateOutputBoundary {
    void present(UpdateFonctionnaliteResponse response);
    void setViewModel(FonctionnaliteUpdateViewModel viewModel);
    FonctionnaliteUpdateViewModel getViewModel();
}


