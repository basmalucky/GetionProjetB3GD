package com.grantburgess.database.jpa.repositories;

import com.grantburgess.database.jpa.data.ProjetData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ProjetRepository extends CrudRepository<ProjetData, UUID> {
    List<ProjetData> findByCancelledDateIsNull();
    Optional<ProjetData> findByIdAndCancelledDateIsNull(UUID id);
    boolean existsByNameAndCancelledDateIsNull(String name);
}
