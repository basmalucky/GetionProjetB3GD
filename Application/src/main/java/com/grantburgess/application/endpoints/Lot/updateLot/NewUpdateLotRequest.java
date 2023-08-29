package com.grantburgess.application.endpoints.Lot.updateLot;


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
@ApiModel(value = "Update Lot Request", subTypes = NewUpdateLotRequest.Duration.class)
public class NewUpdateLotRequest {

    @NotBlank
    @NotNull
    @Size(min = 3, max = 25)
    @ApiModelProperty(notes = "Updated lot name", position = 1, example = "Updated Lot Name")
    private String name;

    @ApiModelProperty(notes = "Updated lot description", position = 2, example = "Updated Lot Description")
    private String description;

    @NotNull
    @Valid
    @ApiModelProperty(notes = "Updated lot duration", position = 5)
    private Duration duration;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "Updated lot duration", parent = NewUpdateLotRequest.class)
    public static class Duration {
        @NotNull
        @ApiModelProperty(notes = "Updated lot start date", position = 1, example = "2023-01-01")
        private LocalDate startDate;

        @NotNull
        @ApiModelProperty(notes = "Updated task end date", position = 2, example = "2023-12-31")
        private LocalDate endDate;
    }
}

