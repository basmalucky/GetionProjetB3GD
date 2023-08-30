package com.grantburgess.application.endpoints.Fonctionnalite.updateFonctionnalite;


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
@ApiModel(value = "Update Fonctionnalite Request", subTypes = NewUpdateFonctionnaliteRequest.Duration.class)
public class NewUpdateFonctionnaliteRequest {

    @NotBlank
    @NotNull
    @Size(min = 3, max = 25)
    @ApiModelProperty(notes = "Updated fonctionnalite name", position = 1, example = "Updated Fonctionnalite Name")
    private String name;

    @ApiModelProperty(notes = "Updated fonctionnalite description", position = 2, example = "Updated Fonctionnalite Description")
    private String description;

    @NotNull
    @Valid
    @ApiModelProperty(notes = "Updated fonctionnalite duration", position = 5)
    private Duration duration;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "Updated fonctionnalite duration", parent = NewUpdateFonctionnaliteRequest.class)
    public static class Duration {
        @NotNull
        @ApiModelProperty(notes = "Updated fonctionnalite start date", position = 1, example = "2023-01-01")
        private LocalDate startDate;

        @NotNull
        @ApiModelProperty(notes = "Updated fonctionnalite end date", position = 2, example = "2023-12-31")
        private LocalDate endDate;
    }
}

