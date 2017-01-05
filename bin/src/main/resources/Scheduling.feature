#Scheduling.feature

Feature: Booking
    As a vet
    I cannot book an appointment when it conflicts with one or more of my booked appointments
    So there will be no appointment conflicts
	
	Scenario: 
	    Given there is an appointment request I want to book
	    And it does not conflict with a booked appointment
	    When I enter the portal
	    Then I get to book the requested appointment
	
	Scenario:
	    Given there is an appointment request I want to book
	    And it does conflict with a booked appointment
	    When I enter the portal
	    Then I do not get to book the requested appointment

