package com.grantburgess.application.exception;

import com.grantburgess.ports.database.TaskGateway;
import com.grantburgess.ports.database.FonctionnaliteGateway;
import com.grantburgess.ports.database.LotGateway;
import com.grantburgess.ports.database.ProjetGateway;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessageMap {
    private ErrorMessageMap() {}

    public static Map<Class, String> errors = new HashMap<>();

    static {
        errors.put(TaskGateway.taskNotFoundException.class, "task not found");
        errors.put(TaskGateway.CannotCanceltaskThatHasExpiredException.class, "Cannot cancel expired task");
        errors.put(TaskGateway.taskEndDateCannotBeBeforeCurrentSystemDateException.class, "task end date must be earlier than the current date");
        errors.put(TaskGateway.taskNameAlreadyExistsException.class, "Offer name already exists");
        errors.put(TaskGateway.taskStartDateGreaterThanEndDateException.class, "task start date must be less than end date");

        errors.put(FonctionnaliteGateway.FonctionnaliteNotFoundException.class, "fonctionnalite not found");
        errors.put(FonctionnaliteGateway.CannotCancelfonctionnaliteThatHasExpiredException.class, "Cannot cancel expired fonctionnalite");
        errors.put(FonctionnaliteGateway.fonctionnaliteEndDateCannotBeBeforeCurrentSystemDateException.class, "fonctionnalite end date must be earlier than the current date");
        errors.put(FonctionnaliteGateway.fonctionnaliteNameAlreadyExistsException.class, "Offer name already exists");
        errors.put(FonctionnaliteGateway.fonctionnaliteStartDateGreaterThanEndDateException.class, "fonctionnalite start date must be less than end date");

        errors.put(LotGateway.LotNotFoundException.class, "lot not found");
        errors.put(LotGateway.CannotCancellotThatHasExpiredException.class, "Cannot cancel expired lot");
        errors.put(LotGateway.lotEndDateCannotBeBeforeCurrentSystemDateException.class, "lot end date must be earlier than the current date");
        errors.put(LotGateway.lotNameAlreadyExistsException.class, "Offer name already exists");
        errors.put(LotGateway.lotStartDateGreaterThanEndDateException.class, "lot start date must be less than end date");

        errors.put(ProjetGateway.ProjetNotFoundException.class, "projet not found");
        errors.put(ProjetGateway.CannotCancelprojectThatHasExpiredException.class, "Cannot cancel expired projet");
        errors.put(ProjetGateway.projectEndDateCannotBeBeforeCurrentSystemDateException.class, "projet end date must be earlier than the current date");
        errors.put(ProjetGateway.projectNameAlreadyExistsException.class, "Offer name already exists");
        errors.put(ProjetGateway.projectStartDateGreaterThanEndDateException.class, "projet start date must be less than end date");

    }
}
