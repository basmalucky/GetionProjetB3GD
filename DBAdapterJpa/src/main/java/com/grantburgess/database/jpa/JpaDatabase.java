package com.grantburgess.database.jpa;

import com.grantburgess.database.jpa.JpaGateway.JpaFonctionnaliteGateway;
import com.grantburgess.database.jpa.JpaGateway.JpaLotGateway;
import com.grantburgess.database.jpa.JpaGateway.JpaProjetGateway;
import com.grantburgess.database.jpa.JpaGateway.JpaTaskGateway;
import com.grantburgess.database.jpa.repositories.FonctionnaliteRepository;
import com.grantburgess.database.jpa.repositories.LotRepository;
import com.grantburgess.database.jpa.repositories.ProjetRepository;
import com.grantburgess.database.jpa.repositories.TaskRepository;
import com.grantburgess.ports.database.*;

public class JpaDatabase implements Database {
    private TaskGateway taskGateway;
    private ProjetGateway projetGateway;
    private LotGateway lotGateway;
    private FonctionnaliteGateway fonctionnaliteGateway;
    public JpaDatabase(TaskRepository taskRepository) {
        taskGateway = new JpaTaskGateway(taskRepository);
    }
    public JpaDatabase(ProjetRepository projetRepository) { projetGateway = (ProjetGateway) new JpaProjetGateway(projetRepository, projetRepository);}
    public JpaDatabase(LotRepository lotRepository) { lotGateway = new JpaLotGateway(lotRepository);}
    public JpaDatabase(FonctionnaliteRepository fonctionnaliteRepository) {
        fonctionnaliteGateway = new JpaFonctionnaliteGateway(fonctionnaliteRepository);
    }
    public TaskGateway TaskGateway() {
        return taskGateway;
    }

    @Override
    public ProjetGateway PROJET_GATEWAY() {
        return null;
    }

    @Override
    public LotGateway LOT_GATEWAY() {
        return null;
    }

    @Override
    public FonctionnaliteGateway FONCTIONNALITE_GATEWAY() {
        return null;
    }

}
