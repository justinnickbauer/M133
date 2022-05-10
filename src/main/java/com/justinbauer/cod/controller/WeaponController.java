package com.justinbauer.cod.controller;

import com.justinbauer.cod.entity.Modus;
import com.justinbauer.cod.entity.Weapon;
import com.justinbauer.cod.payload.ModusDto;
import com.justinbauer.cod.payload.WeaponDto;
import com.justinbauer.cod.repository.WeaponRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD Rest APIs for Weapon resources")
@RestController
@RequestMapping("/api/v1/weapon")
public class WeaponController {

    private WeaponRepository weaponRepository;

    @ApiOperation(value = "Create Weapon REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Weapon> add(@Valid @RequestBody WeaponDto weaponDto){
        Weapon weapon = new Weapon();
        weapon.setName(weaponDto.getName());
        weaponRepository.save(weapon);
        return new ResponseEntity<>(weapon, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Show all Weapons REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/showAll")
    public ResponseEntity<List<Weapon>> showAll(){
        List<Weapon> weaponList = weaponRepository.findAll();
        return new ResponseEntity<>(weaponList, HttpStatus.CREATED);
    }
}
