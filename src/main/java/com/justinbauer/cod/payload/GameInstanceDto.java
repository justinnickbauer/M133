package com.justinbauer.cod.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "GameInstance model information")
@Data
public class GameInstanceDto {

    @ApiModelProperty(value = "Team name")
    private String teamName;

    @ApiModelProperty(value = "Teamleader")
    private boolean teamleader;

    @ApiModelProperty(value = "is winner")
    private boolean Winner;

    @ApiModelProperty(value = "kills")
    private Integer kills;

    @ApiModelProperty(value = "deaths")
    private Integer deaths;
}
