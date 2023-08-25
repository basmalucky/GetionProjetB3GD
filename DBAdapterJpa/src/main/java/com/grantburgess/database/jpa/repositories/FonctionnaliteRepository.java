package com.grantburgess.database.jpa.repositories;

import com.grantburgess.database.jpa.data.FonctionnaliteData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FonctionnaliteRepository extends CrudRepository<FonctionnaliteData, UUID> {
    List<FonctionnaliteData> findByCancelledDateIsNull();
    Optional<FonctionnaliteData> findByIdAndCancelledDateIsNull(UUID id);
    boolean existsByNameAndCancelledDateIsNull(String name);
}
