package com.grantburgess.ports.usescases.Fonctionnalite.addFonctionnalite;

import lombok.Getter;

import java.util.UUID;

@Getter
public class NewFonctionnaliteResponse {
    private UUID id;

    public NewFonctionnaliteResponse(UUID id) {
        this.id = id;
    }
}
