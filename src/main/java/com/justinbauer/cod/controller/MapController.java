package com.justinbauer.cod.controller;

import com.justinbauer.cod.entity.Map;
import com.justinbauer.cod.entity.Modus;
import com.justinbauer.cod.payload.MapDto;
import com.justinbauer.cod.payload.ModusDto;
import com.justinbauer.cod.repository.MapRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD Rest APIs for Map resources")
@RestController
@RequestMapping("/api/v1/map")
public class MapController {

    private MapRepository mapRepository;

    @ApiOperation(value = "Create Modus REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addMap")
    public ResponseEntity<Map> addMap(@Valid @RequestBody MapDto mapDto){
        Map map = new Map();
        map.setName(mapDto.getName());
        mapRepository.save(map);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Create Modus REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/showAll")
    public ResponseEntity<List<Map>> showAll(@Valid @RequestBody MapDto mapDto){
        List<Map> mapList = mapRepository.findAll();
        return new ResponseEntity<>(mapList, HttpStatus.OK);
    }
}

