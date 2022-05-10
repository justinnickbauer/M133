package com.justinbauer.cod.repository;

import com.justinbauer.cod.entity.Modus;
import com.justinbauer.cod.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModusRepository extends JpaRepository<Modus, Long> {
    Modus findByName(String name);
}
