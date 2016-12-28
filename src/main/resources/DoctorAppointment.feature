#DoctorAppointment.feature

Feature: Accepting appointment
    As a vet
    I can see appointment requests
    So I can accept appointments
    
	Scenario: No appointments 
	    Given there are no appointment requests
	    When I enter the portal
	    Then I get to go home
	    
	Scenario: 
	    Given there are appointment requests
	    And they fit my specialty
	    When I enter the portal 
	    Then I get to choose which to book
	    
	Scenario:
	    Given there are appointment requests
	    And they do not fit my speciality
	    When I enter the portal 
	    Then I get to go home
