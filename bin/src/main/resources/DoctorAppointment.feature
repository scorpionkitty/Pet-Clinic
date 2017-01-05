#DoctorAppointment.feature

Feature: Accepting appointment
    As a vet
    I can see appointment requests
    So I have the option to accept one or more appointments
    
	Scenario: No appointments 
	    Given there are no appointment requests
	    When I enter the portal
	    Then I get a textbox message letting me know that I have no appointments to accept
	    
	Scenario Outline: 
		Given I am a vet
		And I see <apptId>
		When I log into the portal
		Then I have the option to reschedule an appointment
	
	    Given there are appointment requests
	    And they fit my specialty
	    And it does not conflict with my booked appointments
	    When I enter the portal 
	    Then I get to choose which to book
	    
	    
	    
	Scenario:
	    Given there are appointment requests
	    And they do not fit my speciality
	    When I enter the portal 
	    Then I get to go home

	Scenario:
		Given there is an appointment
		When I enter the portal
		Then I have the option to see the owner's profile
		
	Scenario:
		Given there is an appointment
		And I have completed the appointment 
		When I enter the portal
		Then I can add a prescription