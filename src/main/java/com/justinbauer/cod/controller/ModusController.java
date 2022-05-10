package com.justinbauer.cod.controller;

import com.justinbauer.cod.entity.Modus;
import com.justinbauer.cod.payload.ModusDto;
import com.justinbauer.cod.repository.ModusRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD Rest APIs for Modus resources")
@RestController
@RequestMapping("/api/v1/modus")
public class ModusController {

    private ModusRepository modusRepository;

    @ApiOperation(value = "Create Modus REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addModus")
    public ResponseEntity<Modus> addModus(@Valid @RequestBody ModusDto modusDto){
        Modus modus = new Modus();
        modus.setName(modusDto.getName());
        modusRepository.save(modus);
        return new ResponseEntity<>(modus, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Create Modus REST API")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/showAll")
    public ResponseEntity<List<Modus>> showAll(@Valid @RequestBody ModusDto modusDto){
        List<Modus> modusList = modusRepository.findAll();
        return new ResponseEntity<>(modusList, HttpStatus.CREATED);
    }
}
