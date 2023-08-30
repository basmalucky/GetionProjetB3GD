package com.grantburgess.ports.usescases.Projet.cancelProjet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CancelProjetRequest {
    private UUID projetId;

    public void execute(CancelProjetRequest build) {
    }
}





