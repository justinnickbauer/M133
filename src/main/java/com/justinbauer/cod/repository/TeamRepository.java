package com.justinbauer.cod.repository;

import com.justinbauer.cod.entity.Team;
import com.justinbauer.cod.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByName(String name);
}
