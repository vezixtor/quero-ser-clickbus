package com.herokuapp.clickbuschallenge.controller;

import com.herokuapp.clickbuschallenge.model.dto.v1.PlaceDTO;
import com.herokuapp.clickbuschallenge.service.PlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/v1/place")
@Api(value = "PlaceControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE, tags = "Place")
public class PlaceController {
    private static final String RESOURCE = "Place";

    private final PlaceService service;

    @Autowired
    public PlaceController(PlaceService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create a place")
    public PlaceDTO save(@Validated @RequestBody PlaceDTO dto) {
        log.debug("Create a {}", RESOURCE);
        return this.service.save(dto);
    }

    @PutMapping("{id}")
    @ApiOperation("Edit a place")
    public PlaceDTO update(@PathVariable Long id, @Validated @RequestBody PlaceDTO dto) {
        log.debug("Edit a {} ", RESOURCE);
        return this.service.update(id, dto);
    }

    @GetMapping("{id}")
    @ApiOperation("Get a specific place")
    public PlaceDTO findOne(@PathVariable Long id) {
        log.debug("Get a specific {} ", RESOURCE);
        return this.service.findOne(id);
    }

    @GetMapping
    @ApiOperation("List places and filter them by name")
    public Page<PlaceDTO> findAll(Pageable pageable, @RequestParam(required = false) String name) {
        log.debug("List {}s and filter them by name", RESOURCE);
        return this.service.findAll(pageable, name);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete a place")
    public void delete(@PathVariable Long id) {
        log.debug("Delete a {} ", RESOURCE);
        this.service.delete(id);
    }
}