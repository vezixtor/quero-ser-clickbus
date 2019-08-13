package com.herokuapp.clickbuschallenge.model.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.herokuapp.clickbuschallenge.model.dto.v1.PlaceDTO;
import com.herokuapp.clickbuschallenge.model.entity.Place;
import com.herokuapp.clickbuschallenge.template.CommonTemplateLoader;
import com.herokuapp.clickbuschallenge.template.dto.PlaceDTOTemplateLoader;
import com.herokuapp.clickbuschallenge.template.entity.PlaceTemplateLoader;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PlaceAdapterTest {

    @BeforeClass
    public static void loadTemplates() {
        FixtureFactoryLoader.loadTemplates(CommonTemplateLoader.FIXTURE_FACTORY_BASE_PACKAGE);
    }

    @Test
    public void entityToDTO() {
        Place entity = Fixture.from(Place.class).gimme(PlaceTemplateLoader.RULE_VALID);
        PlaceDTO dtoConvert = PlaceAdapter.toDTO(entity);
        assertThat(entity.getId(), equalTo(dtoConvert.getId()));
        assertThat(entity.getName(), equalTo(dtoConvert.getName()));
        assertThat(entity.getSlug(), equalTo(dtoConvert.getSlug()));
        assertThat(entity.getCity(), equalTo(dtoConvert.getCity()));
        assertThat(entity.getState(), equalTo(dtoConvert.getState()));
        assertThat(entity.getCreatedAt(), equalTo(dtoConvert.getCreatedAt()));
        assertThat(entity.getUpdatedAt(), equalTo(dtoConvert.getUpdatedAt()));
    }

    @Test
    public void DTOToEntity() {
        PlaceDTO dto = Fixture.from(PlaceDTO.class).gimme(PlaceDTOTemplateLoader.RULE_VALID);
        Place entityConvert = PlaceAdapter.toEntity(dto);
        assertThat(dto.getId(), equalTo(entityConvert.getId()));
        assertThat(dto.getName(), equalTo(entityConvert.getName()));
        assertThat(dto.getSlug(), equalTo(entityConvert.getSlug()));
        assertThat(dto.getCity(), equalTo(entityConvert.getCity()));
        assertThat(dto.getState(), equalTo(entityConvert.getState()));
        assertThat(dto.getCreatedAt(), equalTo(entityConvert.getCreatedAt()));
        assertThat(dto.getUpdatedAt(), equalTo(entityConvert.getUpdatedAt()));
    }

    @Test
    public void entityNull() {
        PlaceDTO dto = null;
        Place entity = PlaceAdapter.toEntity(dto);
        assertNull(entity);
    }

    @Test
    public void dtoNull() {
        Place entity = null;
        PlaceDTO dto = PlaceAdapter.toDTO(entity);
        assertNull(dto);
    }
}