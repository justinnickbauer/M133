package com.justinbauer.cod.service.impl;

import com.justinbauer.cod.entity.Game;
import com.justinbauer.cod.entity.GameInstance;
import com.justinbauer.cod.exception.ResourceNotFoundException;
import com.justinbauer.cod.payload.GameDto;
import com.justinbauer.cod.repository.*;
import com.justinbauer.cod.service.GameInstanceService;
import com.justinbauer.cod.service.GameService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private UserRepository userRepository;
    private GameInstanceRepository gameInstanceRepository;
    private MapRepository mapRepository;
    private ModusRepository modusRepository;
    private WeaponRepository weaponRepository;

    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository, GameInstanceRepository gameInstanceRepository, GameInstanceService gameInstanceService, MapRepository mapRepository, ModusRepository modusRepository, WeaponRepository weaponRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.gameInstanceRepository = gameInstanceRepository;
        this.mapRepository = mapRepository;
        this.modusRepository = modusRepository;
        this.weaponRepository = weaponRepository;
    }

    @Override
    @Transactional
    public Game createGame(GameDto gameDto) {
        Game game = mapToEntity(gameDto);
        gameRepository.save(game);
        for (String username: gameDto.getUsernames()) {
            GameInstance gameInstance = new GameInstance(userRepository.findByUsername(username), game);
            gameInstanceRepository.save(gameInstance);
        }
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> games = gameRepository.findAll();
        return games;
    }

    @Override
    public Game getGamebyId(long id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Game", "id", id));
        return game;
    }

    @Override
    public Game updateGame(long id, GameDto gameDto) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Game", "id", id));
        game.setName(gameDto.getName());
        game.setActive(gameDto.isActive());
        game.setDate(gameDto.getDate());
        for (String username: gameDto.getUsernames()) {
            GameInstance gameInstance = new GameInstance(userRepository.findByUsername(username), game);
            gameInstanceRepository.save(gameInstance);
        }
        gameRepository.save(game);
        return game;
    }

    @Override
    public void deleteGame(long id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Game", "id", id));
        gameRepository.delete(game);
    }


    private Game mapToEntity(GameDto gameDto){
        Game game = new Game();
        game.setName(gameDto.getName());
        game.setActive(gameDto.isActive());
        game.setDate(gameDto.getDate());
        game.setMap(mapRepository.findByName(gameDto.getMap()));
        game.setModus(modusRepository.findByName(gameDto.getModus()));
        game.setWeapon(weaponRepository.findByName(gameDto.getWeapon()));
        return game;
    }
}
