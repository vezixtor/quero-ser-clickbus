package com.herokuapp.clickbuschallenge.bdd.scenario;

import br.com.six2six.fixturefactory.Fixture;
import com.herokuapp.clickbuschallenge.bdd.scenario.common.BaseScenario;
import com.herokuapp.clickbuschallenge.bdd.scenario.common.Scenario;
import com.herokuapp.clickbuschallenge.model.adapter.PlaceAdapter;
import com.herokuapp.clickbuschallenge.model.dto.v1.PlaceDTO;
import com.herokuapp.clickbuschallenge.model.entity.Place;
import com.herokuapp.clickbuschallenge.repository.PlaceRepository;
import com.herokuapp.clickbuschallenge.template.CommonTemplateLoader;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceScenario extends BaseScenario implements Scenario {

    @Autowired
    private PlaceRepository repository;

    @Override
    public PlaceRepository getRepository() {
        return repository;
    }

    @Override
    public Place gimmeEntity() {
        Place entity = Fixture.from(Place.class)
                .gimme(CommonTemplateLoader.RULE_VALID_WITHOUT_FK);
        String randomName = RandomStringUtils.random(15);
        entity.setName(randomName);
        return entity;
    }

    @Override
    public List<Place> gimmeEntity(Integer quantity) {
        List<Place> entities = new ArrayList<>();
        while (entities.size() < quantity) {
            entities.add(gimmeEntity());
        }
        return entities;
    }

    @Override
    public Place gimmeEntitySaved() {
        return repository.save(gimmeEntity());
    }

    @Override
    public List<Place> gimmeEntitySaved(Integer quantity) {
        return gimmeEntity(quantity).stream()
                .map(entity -> repository.save(entity))
                .collect(Collectors.toList());
    }

    @Override
    public PlaceDTO gimmeDTO() {
        return PlaceAdapter.toDTO(gimmeEntity());
    }

    @Override
    public List<PlaceDTO> gimmeDTO(Integer quantity) {
        return PlaceAdapter.toDTO(gimmeEntity(quantity));
    }
}