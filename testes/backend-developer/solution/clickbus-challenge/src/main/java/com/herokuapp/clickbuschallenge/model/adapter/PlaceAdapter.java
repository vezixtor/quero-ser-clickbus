package com.herokuapp.clickbuschallenge.model.adapter;

import com.herokuapp.clickbuschallenge.model.dto.v1.PlaceDTO;
import com.herokuapp.clickbuschallenge.model.entity.Place;

import java.util.List;
import java.util.stream.Collectors;

public class PlaceAdapter {

    public static List<PlaceDTO> toDTO(List<Place> entities) {
        return entities.stream().map(PlaceAdapter::toDTO).collect(Collectors.toList());
    }

    public static PlaceDTO toDTO(Place entity) {
        if (entity == null) {
            return null;
        }

        return PlaceDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .slug(entity.getSlug())
                .city(entity.getCity())
                .state(entity.getState())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<Place> toEntity(List<PlaceDTO> dtos) {
        return dtos.stream().map(PlaceAdapter::toEntity).collect(Collectors.toList());
    }

    public static Place toEntity(PlaceDTO dto) {
        if (dto == null) {
            return null;
        }

        return Place.builder()
                .id(dto.getId())
                .name(dto.getName())
                .slug(dto.getSlug())
                .city(dto.getCity())
                .state(dto.getState())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}