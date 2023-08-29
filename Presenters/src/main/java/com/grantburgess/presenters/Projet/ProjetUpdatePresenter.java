package com.grantburgess.presenters.Projet;



import com.grantburgess.ports.presenters.Projet.ProjetUpdateOutputBoundary;
import com.grantburgess.ports.presenters.Projet.ProjetUpdateViewModel;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetResponse;


public class ProjetUpdatePresenter implements ProjetUpdateOutputBoundary {
    private ProjetUpdateViewModel viewModel;

    @Override
    public void present(UpdateProjetResponse response) {

    }

    @Override
    public void setViewModel(ProjetUpdateViewModel viewModel) {
        this.viewModel = viewModel;
    }
    @Override
    public ProjetUpdateViewModel getViewModel() {
        return viewModel;
    }

}

