package cukes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/main/resources/MakingAppointment.feature"})
public class CukesTest {} //hook class (not doing anything except connecting 
