package com.grantburgess.presenters.Fonctionnalite;


import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteUpdateOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteUpdateViewModel;
import com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteResponse;

public class FonctionnaliteUpdatePresenter implements FonctionnaliteUpdateOutputBoundary {
    private FonctionnaliteUpdateViewModel viewModel;

    @Override
    public void present(UpdateFonctionnaliteResponse response) {

    }

    @Override
    public void setViewModel(FonctionnaliteUpdateViewModel viewModel) {
        this.viewModel = viewModel;
    }
    @Override
    public FonctionnaliteUpdateViewModel getViewModel() {
        return viewModel;
    }

}

