package com.grantburgess.presenters.Fonctionnalite;

import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnalitesOutputBoundary;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnalitesViewModel;
import com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalites.FonctionnalitesResponse;

public class FonctionnalitesPresenter extends BaseFonctionnalitePresenter implements FonctionnalitesOutputBoundary {
    private FonctionnalitesViewModel viewModel;

    public FonctionnalitesViewModel getViewModel() {
        return viewModel;
    }

    public void present(FonctionnalitesResponse responseModel) {
        FonctionnalitesViewModel.FonctionnalitesViewModelBuilder offersViewModelBuilder = FonctionnalitesViewModel.builder();
        responseModel.getFonctionnalites()
                .stream()
                .map(BaseFonctionnalitePresenter::mapToTaskViewModel)
                .forEach(offersViewModelBuilder::addTaskViewModel);
        viewModel = offersViewModelBuilder.build();
    }
}
