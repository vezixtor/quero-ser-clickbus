package com.herokuapp.clickbuschallenge.service;

import com.herokuapp.clickbuschallenge.model.dto.v1.PlaceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlaceService {

    Page<PlaceDTO> findAll(Pageable pageable, String nome);

    PlaceDTO findOne(Long id);

    PlaceDTO save(PlaceDTO dto);

    PlaceDTO update(Long id, PlaceDTO dto);

    void delete(Long id);
}