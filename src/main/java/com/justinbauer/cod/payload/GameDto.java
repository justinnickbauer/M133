package com.justinbauer.cod.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@ApiModel(description = "Game model information")
@Data
public class GameDto {

    @ApiModelProperty(value = "Game name")
    @NotEmpty
    @Size(min = 2, message = "Game name should have at least 2 characters")
    private String name;

    @ApiModelProperty(value = "Game Status")
    private boolean isActive;

    @ApiModelProperty(value = "Game Date")
    private Date date;

    @ApiModelProperty(value = "Game Players")
    @NotEmpty
    private String[] usernames;

    @ApiModelProperty(value = "Game Modus")
    @NotEmpty
    @Size(min = 2, message = "Modus should have at least 2 characters")
    private String modus;

    @ApiModelProperty(value = "Game Map")
    @NotEmpty
    @Size(min = 2, message = "Map should have at least 2 characters")
    private String map;

    @ApiModelProperty(value = "Game Weapon")
    @NotEmpty
    @Size(min = 2, message = "Weapon should have at least 2 characters")
    private String weapon;
}
