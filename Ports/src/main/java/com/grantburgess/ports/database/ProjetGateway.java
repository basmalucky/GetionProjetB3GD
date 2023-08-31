package com.grantburgess.ports.database;

import com.grantburgess.entities.Projet;

import java.util.Collection;
import java.util.UUID;

public interface ProjetGateway {
    Collection<Projet> getAllProjects();
    UUID add(Projet projet);
    Projet getById(UUID id);
    void update(Projet projet);
    void delete(UUID id);

    boolean existsByName(String name);

   /* Collection<Projet> getLotsByProjetId(UUID projectId);

    Collection<Projet> getProjetsByLotId(UUID projectId);
*/
    interface BadRequest {}
    public interface NotFound {}
    class ProjetNotFoundException extends RuntimeException implements BadRequest {
    }
    public class projetNotFoundException extends RuntimeException implements NotFound {
    }
    public class projectNameAlreadyExistsException extends RuntimeException implements ProjetGateway.BadRequest {
    }

    public class projectStartDateGreaterThanEndDateException extends RuntimeException implements ProjetGateway.BadRequest {
    }

    public class projectEndDateCannotBeBeforeCurrentSystemDateException extends RuntimeException implements ProjetGateway.BadRequest {
    }
    public class CannotCancelprojectThatHasExpiredException extends RuntimeException implements ProjetGateway.BadRequest {
    }
}

