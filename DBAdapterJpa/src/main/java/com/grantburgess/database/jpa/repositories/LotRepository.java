package com.grantburgess.database.jpa.repositories;

import com.grantburgess.database.jpa.data.LotData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface LotRepository extends CrudRepository<LotData, UUID> {
    List<LotData> findByCancelledDateIsNull();
    Optional<LotData> findByIdAndCancelledDateIsNull(UUID id);
    boolean existsByNameAndCancelledDateIsNull(String name);
}
