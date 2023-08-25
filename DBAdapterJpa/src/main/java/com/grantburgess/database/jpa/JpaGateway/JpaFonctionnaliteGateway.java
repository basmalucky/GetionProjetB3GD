package com.grantburgess.database.jpa.JpaGateway;

import com.grantburgess.database.jpa.repositories.FonctionnaliteRepository;
import com.grantburgess.entities.Fonctionnalite;
import com.grantburgess.ports.database.FonctionnaliteGateway;
import org.springframework.stereotype.Component;
import com.grantburgess.database.jpa.data.FonctionnaliteData;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JpaFonctionnaliteGateway implements FonctionnaliteGateway {
    private final FonctionnaliteRepository fonctionnaliteRepository;

    public JpaFonctionnaliteGateway(final FonctionnaliteRepository fonctionnaliteRepository) {
        this.fonctionnaliteRepository = fonctionnaliteRepository;
    }

    public Collection<Fonctionnalite> getAllExcludingCancelled() {
        return fonctionnaliteRepository.findByCancelledDateIsNull()
                .stream()
                .map(this::mapToFonctionnalite)
                .collect(Collectors.toList());
    }

    private Fonctionnalite mapToFonctionnalite(FonctionnaliteData fonctionnaliteData) {
        return new Fonctionnalite(
                fonctionnaliteData.getId(),
                fonctionnaliteData.getName(),
                fonctionnaliteData.getDescription(),
                fonctionnaliteData.getStartDate(),
                fonctionnaliteData.getEndDate()
        );
    }

    public UUID add(Fonctionnalite task) {
        UUID id = UUID.randomUUID();
        FonctionnaliteData taskData = FonctionnaliteData
                .builder()
                .id(id)
                .name(task.getNom())
                .description(task.getDescription())
                .startDate(task.getDateDebut())
                .endDate(task.getDateFin())
                .build();
        fonctionnaliteRepository.save(taskData);

        return id;
    }

    public Fonctionnalite getByIdExcludingCancelled(UUID id) {
        return fonctionnaliteRepository.findByIdAndCancelledDateIsNull(id)
                .map(this::mapToFonctionnalite)
                .orElse(null);
    }

   @Override
    public Collection<Fonctionnalite> getAllFonctionnalites() {
        return null;
    }


    @Override
    public Fonctionnalite getById(UUID id) {
        return null;
    }


    public void delete(UUID id) {
        FonctionnaliteData taskData = fonctionnaliteRepository.findById(id).orElse(null);
        if (taskData != null) {
            fonctionnaliteRepository.delete(taskData);
        }
    }
    public UUID update(Fonctionnalite task) {
        FonctionnaliteData taskData = FonctionnaliteData
                .builder()
                .id(task.getId())
                .name(task.getNom())
                .description(task.getDescription())
                .startDate(task.getDateDebut())
                .endDate(task.getDateFin())
                .build();

        fonctionnaliteRepository.save(taskData);
        return task.getId();
    }

    public boolean existsByName(String name) {
        return fonctionnaliteRepository.existsByNameAndCancelledDateIsNull(name);
    }
    @Override
    public Collection<Fonctionnalite> getFonctionnalitesByFonctionnaliteId(UUID fonctionnaliteId) {
        return null;
    }
}
