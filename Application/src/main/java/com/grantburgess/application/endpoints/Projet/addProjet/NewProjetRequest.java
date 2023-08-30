package com.grantburgess.application.endpoints.Projet.addProjet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ApiModel(value = "New Projet Request", subTypes = NewProjetRequest.Duration.class)
public class NewProjetRequest {
    @NotBlank
    @NotNull
    @Size(min = 3, max = 25)
    @ApiModelProperty(notes = "Projet name", position = 1, example = "Projet name 01")
    private String name;
    @ApiModelProperty(notes = "Projet description", position = 2, example = "Projet description 01")
    private String description;


    @NotNull
    @Valid
    @ApiModelProperty(notes = "Projet duration", position = 5)
    private Duration duration;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "Projet duration", parent = NewProjetRequest.class)
    public static class Duration {
        @NotNull
        @ApiModelProperty(notes = "Projet start date", position = 1, example = "2020-01-01")
        private LocalDate startDate;
        @NotNull
        @ApiModelProperty(notes = "Projet end date", position = 2, example = "2020-01-31")
        private LocalDate endDate;
    }
}
