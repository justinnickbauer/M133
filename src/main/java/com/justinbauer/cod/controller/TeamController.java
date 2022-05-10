package com.justinbauer.cod.controller;

import com.justinbauer.cod.entity.Team;
import com.justinbauer.cod.entity.Weapon;
import com.justinbauer.cod.payload.TeamDto;
import com.justinbauer.cod.payload.WeaponDto;
import com.justinbauer.cod.repository.TeamRepository;
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
@RequestMapping("/api/v1/team")
public class TeamController {

    private TeamRepository teamRepository;

    @ApiOperation(value = "Create Team REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Team> add(@Valid @RequestBody TeamDto teamDto){
        Team team = new Team();
        team.setName(teamDto.getName());
        teamRepository.save(team);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Show all Weapons REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/showAll")
    public ResponseEntity<List<Team>> showAll(){
        List<Team> teamList = teamRepository.findAll();
        return new ResponseEntity<>(teamList, HttpStatus.CREATED);
    }
}
