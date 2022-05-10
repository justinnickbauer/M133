package com.justinbauer.cod.repository;

import com.justinbauer.cod.entity.Map;
import com.justinbauer.cod.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Map, Long> {
    Map findByName(String name);
}
