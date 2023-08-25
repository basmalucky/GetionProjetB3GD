package com.grantburgess.usecases.Fonctionnalite.deleteFonctionnalite;

import com.grantburgess.ports.database.FonctionnaliteGateway;
import com.grantburgess.ports.usescases.Fonctionnalite.delete.DeleteFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.delete.DeleteFonctionnaliteRequest;


public class DeleteFonctionnalite implements DeleteFonctionnaliteInputBoundary {
    private final FonctionnaliteGateway fonctionnaliteGateway;

    public DeleteFonctionnalite(FonctionnaliteGateway fonctionnaliteGateway) {
        this.fonctionnaliteGateway = fonctionnaliteGateway;
    }

   public void execute(DeleteFonctionnaliteRequest request)
    {
        fonctionnaliteGateway.delete(request.getId());
    }
}
