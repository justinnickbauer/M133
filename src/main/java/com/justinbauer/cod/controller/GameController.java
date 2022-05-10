package com.justinbauer.cod.controller;

import com.justinbauer.cod.entity.Game;
import com.justinbauer.cod.payload.GameDto;
import com.justinbauer.cod.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD Rest APIs for Game resources")
@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ApiOperation(value = "Create Game REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addGame")
    public ResponseEntity<Game> createGame(@Valid @RequestBody GameDto gameDto){
        return new ResponseEntity<>(gameService.createGame(gameDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Show all Games REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/showAll")
    public ResponseEntity<List<Game>> showAll(){
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update Game REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping ("/update/{game_id}")
    public ResponseEntity<Game> updateGame(@PathVariable(value = "game_id") Long gameId, @Valid @RequestBody GameDto gameDto){
        return new ResponseEntity<>(gameService.updateGame(gameId, gameDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Game REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping ("/delete/{game_id}")
    public ResponseEntity<String> deleteGame(@PathVariable(value = "game_id") Long gameId){
        gameService.deleteGame(gameId);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
}
