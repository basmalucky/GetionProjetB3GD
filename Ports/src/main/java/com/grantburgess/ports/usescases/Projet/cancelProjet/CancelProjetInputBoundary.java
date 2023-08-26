package com.grantburgess.ports.usescases.Projet.cancelProjet;

import com.grantburgess.ports.usescases.Task.cancelTask.CancelTaskRequest;

public interface CancelProjetInputBoundary {
    void execute(CancelProjetRequest request);
}
