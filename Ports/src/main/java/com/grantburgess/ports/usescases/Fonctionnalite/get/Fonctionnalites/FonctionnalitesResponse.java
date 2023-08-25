package com.grantburgess.ports.usescases.Fonctionnalite.get.Fonctionnalites;

import com.grantburgess.ports.usescases.Fonctionnalite.get.FonctionnaliteResponse;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class FonctionnalitesResponse {
    @Singular("addFonctionnalite") private List<FonctionnaliteResponse> fonctionnalites;
}
