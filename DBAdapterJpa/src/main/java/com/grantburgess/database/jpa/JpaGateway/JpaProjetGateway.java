package com.grantburgess.database.jpa.JpaGateway;

import com.grantburgess.database.jpa.data.LotData;
import com.grantburgess.database.jpa.data.ProjetData;
import com.grantburgess.database.jpa.repositories.ProjetRepository;
import com.grantburgess.entities.Lot;
import com.grantburgess.entities.Projet;
import com.grantburgess.ports.database.ProjetGateway;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
@Component

public class JpaProjetGateway implements ProjetGateway {

    private final ProjetRepository projetRepository;

    public JpaProjetGateway(final ProjetRepository lotRepository, com.grantburgess.database.jpa.repositories.ProjetRepository projetRepository) {
        ProjetRepository ProjetRepository = projetRepository;
        this.projetRepository = projetRepository;
    }

    public Collection<Projet> getAllExcludingCancelled() {
        return projetRepository.findByCancelledDateIsNull()
                .stream()
                .map(this::mapToProjet)
                .collect(Collectors.toList());
    }

    private Projet mapToProjet(ProjetData projetData) {
        return new Projet(
                projetData.getId(),
                projetData.getName(),
                projetData.getDescription(),
                projetData.getStartDate(),
                projetData.getEndDate()
        );
    }


    public UUID add(Lot task) {
        UUID id = UUID.randomUUID();
        LotData taskData = LotData
                .builder()
                .id(id)
                .nom(task.getNom())
                .description(task.getDescription())
                .dateDebut(task.getDateDebut())
                .dateFin(task.getDateFin())
                .build();
        Session projetRepository = null;
        projetRepository.save(taskData);

        return id;
    }

    public Projet getByIdExcludingCancelled(UUID id) {
        return projetRepository.findByIdAndCancelledDateIsNull(id)
                .map(this::mapToProjet)
                .orElse(null);

    }

    @Override
    public Collection<Projet> getAllProjects() {
        return null;
    }

    @Override
    public UUID add(Projet projet) {
        return null;
    }

    @Override
    public Projet getById(UUID id) {
        return null;
    }

    public void delete(UUID id) {
        ProjetData taskData = projetRepository.findById(id).orElse(null);
        if (taskData != null) {
            projetRepository.delete(taskData);
        }
    }
    public void update(Projet task) {
        ProjetData projetData = ProjetData
                .builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .startDate(task.getDateDebut())
                .endDate(task.getDateFin())
                .build();

        ProjetData taskData = null;
        projetRepository.save(taskData);

    }

    public boolean existsByName(String name) {
        return projetRepository.existsByNameAndCancelledDateIsNull(name);
    }

    @Override
    public Collection<Projet> getLotsByProjetId(UUID projetId) {
        return null;
    }

    @Override
    public Collection<Projet> getProjetsByLotId(UUID projetId) {
        return null;
    }
}



