package com.grantburgess.ports.usescases.Fonctionnalite.updateFonctionnalite;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class UpdateFonctionnaliteResponse {
    private UUID id;

    public UpdateFonctionnaliteResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
