package com.grantburgess.usecases.Projet.updateProjet;



import com.grantburgess.entities.Projet;
import com.grantburgess.ports.database.ProjetGateway;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetInputBoundary;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetRequest;
import com.grantburgess.ports.usescases.Projet.updateProjet.UpdateProjetResponse;
import com.grantburgess.usecases.Projet.get.GetProjetBase;

public class Update extends GetProjetBase implements UpdateProjetInputBoundary {
    private final ProjetGateway projetGateway;

    public Update(ProjetGateway projetGateway) {
        this.projetGateway = projetGateway;
    }

    public UpdateProjetResponse execute(UpdateProjetRequest request) {
        Projet projectToUpdate = projetGateway.getById(request.getId());
System.out.println(projectToUpdate.getId());

        // Effectuez les modifications sur la tâche
        projectToUpdate.setNom(request.getName());
        projectToUpdate.setDescription(request.getDescription());
        projectToUpdate.setDateDebut(request.getStartDate());
        projectToUpdate.setDateFin(request.getEndDate());

        projetGateway.update(projectToUpdate);

        // Créez une réponse de mise à jour
        UpdateProjetResponse updateResponse = UpdateProjetResponse.builder()
                .id(projectToUpdate.getId())
                .build();

        return updateResponse;
    }

}

