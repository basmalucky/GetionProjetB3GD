package com.grantburgess.application.endpoints.Fonctionnalite.addFonctionnalite;

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
@ApiModel(value = "New Fonctionnalite Request", subTypes = NewFonctionnaliteRequest.Duration.class)
public class NewFonctionnaliteRequest {
    @NotBlank
    @NotNull
    @Size(min = 3, max = 25)
    @ApiModelProperty(notes = "Fonctionnalite name", position = 1, example = "Fonctionnalite name 01")
    private String name;
    @ApiModelProperty(notes = "Fonctionnalite description", position = 2, example = "Fonctionnalite description 01")
    private String description;


    @NotNull
    @Valid
    @ApiModelProperty(notes = "Fonctionnalite duration", position = 5)
    private Duration duration;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "Fonctionnalite duration", parent = NewFonctionnaliteRequest.class)
    public static class Duration {
        @NotNull
        @ApiModelProperty(notes = "Fonctionnalite start date", position = 1, example = "2020-01-01")
        private LocalDate startDate;
        @NotNull
        @ApiModelProperty(notes = "Fonctionnalite end date", position = 2, example = "2020-01-31")
        private LocalDate endDate;
    }
}
