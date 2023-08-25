package com.grantburgess.usecases.Projet.updateProjet;



import com.grantburgess.entities.Projet;
import com.grantburgess.ports.database.ProjetGateway;
import com.grantburgess.ports.presenters.Projet.ProjetOutputBoundary;
import com.grantburgess.ports.usescases.Clock;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetRequest;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetResponse;
import com.grantburgess.usecases.Projet.get.GetProjetBase;

public class Update extends GetProjetBase implements UpdateProjetInputBoundary {
    private final ProjetGateway projetGateway;
    private final ProjetOutputBoundary presenter;
    private final Clock clock;
    public Update(ProjetOutputBoundary presenter,ProjetGateway projetGateway,Clock clock) {
        this.projetGateway = projetGateway;
        this.presenter = presenter;
        this.clock = clock;
    }

    public UpdateProjetResponse execute(UpdateProjetRequest request) {
        Projet projetToUpdate = projetGateway.getById(request.getId());
System.out.println(projetToUpdate.getId());
        if (projetToUpdate == null) {
            throw new ProjetGateway.projetNotFoundException();
        }

        // Effectuez les modifications sur la tâche
        projetToUpdate.setNom(request.getName());
        projetToUpdate.setDescription(request.getDescription());
        projetToUpdate.setDateDebut(request.getStartDate());
        projetToUpdate.setDateFin(request.getEndDate());

        projetGateway.update(projetToUpdate);

        // Créez une réponse de mise à jour
        UpdateProjetResponse updateResponse = UpdateProjetResponse.builder()
                .id(projetToUpdate.getId())
                .build();

        return updateResponse;
    }

}

