package com.grantburgess.database.jpa.JpaGateway;

import com.grantburgess.database.jpa.data.LotData;
import com.grantburgess.database.jpa.repositories.LotRepository;
import com.grantburgess.entities.Lot;
import com.grantburgess.ports.database.LotGateway;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
public class JpaLotGateway implements LotGateway {
    private final LotRepository lotRepository;

    public JpaLotGateway(final LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    public Collection<Lot> getAllExcludingCancelled() {
        return lotRepository.findByCancelledDateIsNull()
                .stream()
                .map(this::mapToLot)
                .collect(Collectors.toList());
    }

    private Lot mapToLot(LotData lotData) {
        return new Lot(
                lotData.getId(),
                lotData.getNom(),
                lotData.getDescription(),
                lotData.getDateDebut(),
                lotData.getDateFin()
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
        lotRepository.save(taskData);

        return id;
    }

    public Lot getByIdExcludingCancelled(UUID id) {
        return lotRepository.findByIdAndCancelledDateIsNull(id)
                .map(this::mapToLot)
                .orElse(null);

        }
        @Override
        public Lot getById(UUID id) {
            return null;
        }
        @Override
    public Collection<Lot> getAllLots() {
        return null;
    }
    public void delete(UUID id) {
       LotData taskData = lotRepository.findById(id).orElse(null);
        if (taskData != null) {
            lotRepository.delete(taskData);
        }
    }
    public UUID update(Lot task) {
        LotData taskData = LotData
                .builder()
                .id(task.getId())
                .nom(task.getNom())
                .description(task.getDescription())
                .dateDebut(task.getDateDebut())
                .dateFin(task.getDateFin())
                .build();

        lotRepository.save(taskData);
        return task.getId();
    }

    public boolean existsByName(String name) {
        return lotRepository.existsByNameAndCancelledDateIsNull(name);
    }

    @Override
    public Collection<Lot> getLotsByProjetId(UUID projetId) {
        return null;
    }

    @Override
    public Collection<Lot> getLotsByLotId(UUID lotId) {
        return null;
    }
}



