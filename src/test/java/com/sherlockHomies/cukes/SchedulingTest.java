package com.sherlockHomies.cukes;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SchedulingTest {

	@Given("^there is an appointment request I want to book$")
	public void there_is_an_appointment_request_I_want_to_book() throws Throwable {
		System.out.println("I have logged in and would like to book an appointment");
	}

	@Given("^it does not conflict with a booked appointment$")
	public void it_does_not_conflict_with_a_booked_appointment() throws Throwable {
		System.out.println("And this appointment time has not been taken previously");
	}

	@When("^I enter the portal$")
	public void i_enter_the_portal() throws Throwable {
		System.out.println("After I enter the portal");
	}

	@Then("^I get to book the requested appointment$")
	public void i_get_to_book_the_requested_appointment() throws Throwable {
		System.out.println("I now book the empty appointment slot");
	}

	@Given("^it does conflict with a booked appointment$")
	public void it_does_conflict_with_a_booked_appointment() throws Throwable {
		System.out.println("However, when I try to book an appointment that has been booked");
	}

	@Then("^I do not get to book the requested appointment$")
	public void i_do_not_get_to_book_the_requested_appointment() throws Throwable {
		System.out.println("The system denies my request");
	}

}
