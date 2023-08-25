package com.grantburgess.presenters.Fonctionnalite;

import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteCreatedOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteCreatedViewModel;
import com.grantburgess.ports.usescases.Fonctionnalite.addFonctionnalite.NewFonctionnaliteResponse;

public class FonctionnaliteCreatedPresenter implements FonctionnaliteCreatedOutputBoundary {
    private FonctionnaliteCreatedViewModel viewModel;

    public FonctionnaliteCreatedViewModel getViewModel() {
        return viewModel;
    }

    public void present(NewFonctionnaliteResponse responseModel) {
        viewModel = new FonctionnaliteCreatedViewModel(responseModel.getId().toString());
    }
}
