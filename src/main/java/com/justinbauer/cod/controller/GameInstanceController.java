package com.justinbauer.cod.controller;

import com.justinbauer.cod.entity.Game;
import com.justinbauer.cod.entity.GameInstance;
import com.justinbauer.cod.payload.GameInstanceDto;
import com.justinbauer.cod.service.GameInstanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD Rest APIs for GameInstances resources")
@RestController
@RequestMapping("/api/v1/gameinstances")
public class GameInstanceController {

    private GameInstanceService gameInstanceService;

    public GameInstanceController(GameInstanceService gameInstanceService) {
        this.gameInstanceService = gameInstanceService;
    }

    @ApiOperation(value = "Get All Game Instances REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/showAll")
    public ResponseEntity<List<GameInstance>> showAll(){
        return new ResponseEntity<>(gameInstanceService.getAllGameInstances(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get All Game Instances REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<GameInstance> updateGameInstance(@PathVariable(value = "id") Long id, @Valid @RequestBody GameInstanceDto gameInstanceDto){
        return new ResponseEntity<>(gameInstanceService.updateGameInstance(id, gameInstanceDto), HttpStatus.OK);
    }

}
