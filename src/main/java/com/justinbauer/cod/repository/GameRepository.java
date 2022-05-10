package com.justinbauer.cod.repository;

import com.justinbauer.cod.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
