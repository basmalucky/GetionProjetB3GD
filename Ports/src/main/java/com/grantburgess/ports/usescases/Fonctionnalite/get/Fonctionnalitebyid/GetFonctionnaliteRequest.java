package com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalitebyid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class GetFonctionnaliteRequest {
    private UUID id;
}
