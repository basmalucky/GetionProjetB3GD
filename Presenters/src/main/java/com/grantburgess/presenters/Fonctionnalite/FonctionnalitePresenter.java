package com.grantburgess.presenters.Fonctionnalite;

import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteViewModel;
import com.grantburgess.ports.usescases.Fonctionnalite.get.FonctionnaliteResponse;

public class FonctionnalitePresenter extends BaseFonctionnalitePresenter implements FonctionnaliteOutputBoundary {
    private FonctionnaliteViewModel viewModel;

    public FonctionnaliteViewModel getViewModel() {
        return viewModel;
    }

    public void present(FonctionnaliteResponse responseModel) {
        viewModel = mapToTaskViewModel(responseModel);
    }


}
