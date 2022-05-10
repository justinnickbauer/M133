package com.justinbauer.cod.service.impl;

import com.justinbauer.cod.entity.Game;
import com.justinbauer.cod.entity.GameInstance;
import com.justinbauer.cod.entity.User;
import com.justinbauer.cod.exception.ResourceNotFoundException;
import com.justinbauer.cod.payload.GameDto;
import com.justinbauer.cod.payload.GameInstanceDto;
import com.justinbauer.cod.repository.GameInstanceRepository;
import com.justinbauer.cod.repository.TeamRepository;
import com.justinbauer.cod.service.GameInstanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameInstanceServiceImpl implements GameInstanceService {

    private GameInstanceRepository gameInstanceRepository;
    private TeamRepository teamRepository;

    public GameInstanceServiceImpl(GameInstanceRepository gameInstanceRepository, TeamRepository teamRepository) {
        this.gameInstanceRepository = gameInstanceRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public void setRelationship(User user, Game game) {
        GameInstance gameInstance = new GameInstance();
        gameInstance.setUser(user);
        gameInstance.setGame(game);
        gameInstanceRepository.save(gameInstance);
    }

    @Override
    public List<GameInstance> getAllGameInstances() {
        List<GameInstance> games = gameInstanceRepository.findAll();
        return games;
    }

    @Override
    public GameInstance updateGameInstance(long id, GameInstanceDto gameInstanceDto) {
        GameInstance gameInstance = gameInstanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("GameInstance", "id", id));
        gameInstance.setKills(gameInstanceDto.getKills());
        gameInstance.setDeaths(gameInstanceDto.getDeaths());
        gameInstance.setWinner(gameInstanceDto.isWinner());
        gameInstance.setTeamleader(gameInstanceDto.isTeamleader());
        gameInstance.setTeam(teamRepository.findByName(gameInstanceDto.getTeamName()));
        gameInstanceRepository.save(gameInstance);
        return gameInstance;
    }
}
