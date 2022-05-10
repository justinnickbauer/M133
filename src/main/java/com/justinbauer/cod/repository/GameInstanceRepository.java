package com.justinbauer.cod.repository;

import com.justinbauer.cod.entity.GameInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameInstanceRepository extends JpaRepository<GameInstance, Long> {

}
