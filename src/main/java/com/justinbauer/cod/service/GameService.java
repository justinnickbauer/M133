package com.justinbauer.cod.service;

import com.justinbauer.cod.entity.Game;
import com.justinbauer.cod.payload.GameDto;

import java.util.List;

public interface GameService {
    Game createGame(GameDto gameDto);
    List<Game> getAllGames();
    Game getGamebyId(long id);
    Game updateGame(long id, GameDto gameDto);
    void deleteGame(long id);
}
