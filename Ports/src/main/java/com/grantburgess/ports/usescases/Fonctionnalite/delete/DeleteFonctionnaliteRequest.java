package com.grantburgess.ports.usescases.Fonctionnalite.delete;


import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class DeleteFonctionnaliteRequest {
    private UUID id;
}