package com.grantburgess.ports.presenters.Fonctionnalite;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class FonctionnalitesViewModel {
    @Singular("addFonctionnaliteViewModel") private List<FonctionnaliteViewModel> fonctionnalites;
}
