package com.herokuapp.clickbuschallenge.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.herokuapp.clickbuschallenge.bdd.step", "com.herokuapp.clickbuschallenge.bdd.step.common"},
        features = "src/test/resources/feature"
)
public class ApplicationIT {
}