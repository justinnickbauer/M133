package com.justinbauer.cod.repository;

import com.justinbauer.cod.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
    Weapon findByName(String name);
}
