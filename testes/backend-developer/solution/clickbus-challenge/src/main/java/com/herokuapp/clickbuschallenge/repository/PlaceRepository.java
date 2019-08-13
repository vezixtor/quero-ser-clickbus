package com.herokuapp.clickbuschallenge.repository;

import com.herokuapp.clickbuschallenge.model.entity.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Page<Place> findByName(String lastname, Pageable pageable);
}
