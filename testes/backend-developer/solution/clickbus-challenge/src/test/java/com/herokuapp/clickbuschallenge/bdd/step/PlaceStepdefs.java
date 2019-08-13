package com.herokuapp.clickbuschallenge.bdd.step;

import com.herokuapp.clickbuschallenge.bdd.scenario.PlaceScenario;
import com.herokuapp.clickbuschallenge.bdd.step.common.FeatureTest;
import com.herokuapp.clickbuschallenge.model.adapter.PlaceAdapter;
import com.herokuapp.clickbuschallenge.model.dto.v1.PlaceDTO;
import com.herokuapp.clickbuschallenge.model.entity.Place;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

public class PlaceStepdefs extends FeatureTest implements En {
    private final String ENDPOINT = "/v1/place/";
    private List<Place> entities = new ArrayList<>();
    private List<PlaceDTO> dtos = new ArrayList<>();
    private Response response;
    private PlaceDTO dto;

    @Autowired
    private PlaceScenario scenario;

    public PlaceStepdefs() {
        Given("^(\\d+) pre-existing place record$", (Integer quantity) -> {
            this.entities = scenario.gimmeEntitySaved(quantity);
            this.dtos = PlaceAdapter.toDTO(this.entities);
        });

        When("^I check the place list$", () -> {
            this.response = RestAssured.expect()
                    .statusCode(200)
                    .body(CONTENT_PATH, hasSize(entities.size()))
                    .when()
                    .get(ENDPOINT);
        });

        When("^I try to get the place data by key$", () -> {
            this.dto = dtos.get(0);
            Long id = dto.getId();

            this.response = RestAssured.expect()
                    .statusCode(200)
                    .when()
                    .get(ENDPOINT + id);
        });

        When("^I try to enter the place data$", () -> {
            this.dto = scenario.gimmeDTO();

            this.response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(this.dto)
                    .expect()
                    .statusCode(201)
                    .when()
                    .post(ENDPOINT);

            PlaceDTO responseDTO = response.getBody().as(PlaceDTO.class);
            assertNotNull(responseDTO);
            this.dto.setId(responseDTO.getId());
        });

        When("^I try to change the place data by key$", () -> {
            this.dto = scenario.gimmeDTO();
            Long id = this.dtos.get(0).getId();


            this.response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(this.dto)
                    .expect()
                    .statusCode(200)
                    .when()
                    .put(ENDPOINT + id);

            this.dto.setId(id);
        });

        When("^I try to delete the place register by key$", () -> {
            Long id = this.dtos.get(0).getId();

            RestAssured.expect()
                    .statusCode(200)
                    .when()
                    .delete(ENDPOINT + id);
        });

        Then("^the service returns a place$", () -> {
            PlaceDTO responseDTO = this.response.getBody().as(PlaceDTO.class);
            assertNotNull(responseDTO);
            assertThat(this.dto, equalTo(responseDTO));
        });

        Then("^the service unregisters place$", () -> {
            Long id = this.dtos.get(0).getId();
            RestAssured.given()
                    .expect()
                    .statusCode(404)
                    .when()
                    .get(ENDPOINT + id);
        });

        Then("^the service returns a place list$", () -> {
            List<PlaceDTO> dtos = this.response.jsonPath().getList(CONTENT_PATH, PlaceDTO.class);
            this.dtos.forEach(dto -> assertThat(dtos, hasItem(dto)));
        });

        After(new String[]{"@Place"}, (Scenario scenario) -> {
            this.scenario.deleteAll();
            assertTrue("Database was not cleaned", this.scenario.isClean());
        });
    }
}