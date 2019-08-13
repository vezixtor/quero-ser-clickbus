package com.herokuapp.clickbuschallenge.service.impl;

import com.herokuapp.clickbuschallenge.exception.ApplicationException;
import com.herokuapp.clickbuschallenge.model.adapter.PlaceAdapter;
import com.herokuapp.clickbuschallenge.model.dto.v1.PlaceDTO;
import com.herokuapp.clickbuschallenge.model.entity.Place;
import com.herokuapp.clickbuschallenge.repository.PlaceRepository;
import com.herokuapp.clickbuschallenge.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository repository;

    @Override
    public Page<PlaceDTO> findAll(Pageable pageable, String nome) {
        Page<Place> entitiesPage = Optional.ofNullable(nome)
                .map(name -> this.repository.findByName(name, pageable))
                .orElse(this.repository.findAll(pageable));

        List<PlaceDTO> dtos = entitiesPage.getContent().stream()
                .map(PlaceAdapter::toDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, entitiesPage.getPageable(), entitiesPage.getTotalElements());
    }

    @Override
    public PlaceDTO findOne(Long id) {

        Place entity = this.repository.findById(id)
                .orElseThrow(() -> new ApplicationException(HttpStatus.NOT_FOUND, "not.found"));
        return PlaceAdapter.toDTO(entity);
    }

    @Override
    public PlaceDTO save(PlaceDTO dto) {
        Place entity = PlaceAdapter.toEntity(dto);
        entity = this.repository.save(entity);
        return PlaceAdapter.toDTO(entity);
    }

    @Override
    public PlaceDTO update(Long id, PlaceDTO dto) {
        Place newEntity = PlaceAdapter.toEntity(dto);
        Place entity = this.repository.findById(id)
                .orElseThrow(() -> new ApplicationException(HttpStatus.NOT_FOUND, "not.found"));
        entity.put(newEntity);
        Place merged = this.repository.save(entity);
        return PlaceAdapter.toDTO(merged);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}