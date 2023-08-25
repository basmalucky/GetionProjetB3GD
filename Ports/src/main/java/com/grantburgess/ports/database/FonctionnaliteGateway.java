package com.grantburgess.ports.database;

import com.grantburgess.entities.Fonctionnalite;
import java.util.Collection;
import java.util.UUID;

public interface FonctionnaliteGateway{

    Collection<Fonctionnalite> getAllFonctionnalites();
    UUID add( Fonctionnalite  fonctionnalite);
    Fonctionnalite getById(UUID id);
    UUID update(Fonctionnalite  fonctionnalite);
    void delete(UUID id);
    boolean existsByName(String name);

    Collection<Fonctionnalite> getFonctionnalitesByFonctionnaliteId(UUID  fonctionnaliteId);

    interface BadRequest {}

    class  FonctionnaliteNotFoundException extends RuntimeException implements BadRequest {

    }
    public class  fonctionnaliteNameAlreadyExistsException extends RuntimeException implements  FonctionnaliteGateway.BadRequest {
    }

    public class fonctionnaliteStartDateGreaterThanEndDateException extends RuntimeException implements  FonctionnaliteGateway.BadRequest {
    }





    public class  fonctionnaliteEndDateCannotBeBeforeCurrentSystemDateException extends RuntimeException implements  FonctionnaliteGateway.BadRequest {
    }
}
