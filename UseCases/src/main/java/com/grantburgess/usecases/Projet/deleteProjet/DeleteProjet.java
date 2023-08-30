package com.grantburgess.usecases.Projet.deleteProjet;

import com.grantburgess.ports.database.ProjetGateway;
import com.grantburgess.ports.usescases.Projet.delete.DeleteProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.delete.DeleteProjetRequest;


public class DeleteProjet implements DeleteProjetInputBoundary {
    private final ProjetGateway projetGateway;

    public DeleteProjet(ProjetGateway projetGateway) {
        this.projetGateway = projetGateway;
    }

    public void execute(DeleteProjetRequest request) {
        projetGateway.delete(request.getId());
    }
}
