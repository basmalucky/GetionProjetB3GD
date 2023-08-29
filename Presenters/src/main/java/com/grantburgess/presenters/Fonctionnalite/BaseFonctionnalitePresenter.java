package com.grantburgess.presenters.Fonctionnalite;

import com.grantburgess.ports.presenters.Fonctionnalite.FonctionnaliteViewModel;
import com.grantburgess.ports.usescases.Fonctionnalite.get.FonctionnaliteResponse;

import java.time.format.DateTimeFormatter;

public class BaseFonctionnalitePresenter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE;

    protected BaseFonctionnalitePresenter() { }

    public static FonctionnaliteViewModel mapToFonctionnaliteViewModel(FonctionnaliteResponse responseModel) {
        return FonctionnaliteViewModel
                .builder()
                .id(responseModel.getId().toString())
                .name(responseModel.getName())
                .description(responseModel.getDescription())
                .duration(getFonctionnaliteDuration(responseModel))
                .build();
    }

    private static FonctionnaliteViewModel.Duration getFonctionnaliteDuration(FonctionnaliteResponse responseModel) {
        String startDate = responseModel.getStartDate().format(DATE_TIME_FORMATTER);
        String endDate = responseModel.getEndDate().format(DATE_TIME_FORMATTER);
        return FonctionnaliteViewModel.Duration
                .builder()
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

}
