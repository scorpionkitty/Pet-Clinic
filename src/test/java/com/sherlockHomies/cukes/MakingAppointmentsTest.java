package com.sherlockHomies.cukes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MakingAppointmentsTest {

	@Given("^I select an open appointment slot with \"([^\"]*)\"$")
	public void i_select_an_open_appointment_slot_with(String vet) throws Throwable {
	    System.out.println("I have selected " + vet + " as my vet");
	}

	@When("^I make a new appointment with description: \"([^\"]*)\", contact method: \"([^\"]*)\", and credit card: (\\d+)$")
	public void i_make_a_new_appointment_with_description_contact_method_and_credit_card(String description, String method, int card) throws Throwable {
	    System.out.println("I have made an appointment with description: " + description + 
	    				   ", contact method: " + method + 
	    				   ", and credit card: " + card);
	}

	@Then("^I get \"([^\"]*)\"$")
	public void i_get(String result) throws Throwable {
	    System.out.println("New appointment: " + result);
	}

	@When("^I make a new appointment with contact method: \"([^\"]*)\" and credit card: (\\d+)$")
	public void i_make_a_new_appointment_with_contact_method_and_credit_card(String method, int card) throws Throwable {
	    System.out.println("I have made an appointment with contact method: " + method +
	    				   " and credit card: " + card);
	}

	@When("^I make a new appointment with description: \"([^\"]*)\" and credit card: (\\d+)$")
	public void i_make_a_new_appointment_with_description_and_credit_card(String description, int card) throws Throwable {
	    System.out.println("I have made an appointment with description: " + description + 
	    				   " and credit card: " + card);
	}

	@When("^I make a new appointment with description: \"([^\"]*)\" and contact method: \"([^\"]*)\"$")
	public void i_make_a_new_appointment_with_description_and_contact_method(String description, String method) throws Throwable {
	    System.out.println("I have made an appointment with description: " + description + 
	    				   " and contact method: " + method);
	}
}
