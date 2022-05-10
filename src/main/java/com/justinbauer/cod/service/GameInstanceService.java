package com.justinbauer.cod.service;

import com.justinbauer.cod.entity.Game;
import com.justinbauer.cod.entity.GameInstance;
import com.justinbauer.cod.entity.User;
import com.justinbauer.cod.payload.GameDto;
import com.justinbauer.cod.payload.GameInstanceDto;

import java.util.List;

public interface GameInstanceService {
        void setRelationship(User user, Game game);
        List<GameInstance> getAllGameInstances();
        GameInstance updateGameInstance(long id, GameInstanceDto gameInstanceDto);
}
