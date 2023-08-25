package com.grantburgess.usecases.Fonctionnalite.updateFonctionnalite;



import com.grantburgess.entities.Fonctionnalite;
import com.grantburgess.ports.database.FonctionnaliteGateway;
import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteInputBoundary;
import com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteRequest;
import com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite.UpdateFonctionnaliteResponse;
import com.grantburgess.usecases.Fonctionnalite.get.GetFonctionnaliteBase;

public class Update extends GetFonctionnaliteBase implements UpdateFonctionnaliteInputBoundary {
    private final FonctionnaliteGateway fonctionnaliteGateway;
    private final FonctionnaliteOutputBoundary presenter;
    private final Clock clock;
    public Update(FonctionnaliteOutputBoundary presenter,FonctionnaliteGateway fonctionnaliteGateway,Clock clock) {
        this.fonctionnaliteGateway = fonctionnaliteGateway;
        this.presenter = presenter;
        this.clock = clock;
    }

    public UpdateFonctionnaliteResponse execute(UpdateFonctionnaliteRequest request) {
        Fonctionnalite fonctionnaliteToUpdate = fonctionnaliteGateway.getById(request.getId());
System.out.println(fonctionnaliteToUpdate.getId());
        if (fonctionnaliteToUpdate == null) {
            throw new FonctionnaliteGateway.fonctionnaliteNotFoundException();
        }

        // Effectuez les modifications sur la tâche
        fonctionnaliteToUpdate.setName(request.getName());
        fonctionnaliteToUpdate.setDescription(request.getDescription());
        fonctionnaliteToUpdate.setStartDate(request.getStartDate());
        fonctionnaliteToUpdate.setEndDate(request.getEndDate());

        fonctionnaliteGateway.update(fonctionnaliteToUpdate);

        // Créez une réponse de mise à jour
        UpdateFonctionnaliteResponse updateResponse = UpdateFonctionnaliteResponse.builder()
                .id(fonctionnaliteToUpdate.getId())
                .build();

        return updateResponse;
    }

}

