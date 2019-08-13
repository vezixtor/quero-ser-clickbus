package com.herokuapp.clickbuschallenge.bdd.step.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.clickbuschallenge.ClickbusChallengeApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

@ContextConfiguration
@SpringBootTest(classes = ClickbusChallengeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class FeatureTest {
    protected String CONTENT_PATH = "content";

    protected Map<String, ?> toMap(Object anObject) {
        TypeReference<Map<String, ?>> typeReference = new TypeReference<Map<String, ?>>() {
        };
        return new ObjectMapper().convertValue(anObject, typeReference);
    }
}