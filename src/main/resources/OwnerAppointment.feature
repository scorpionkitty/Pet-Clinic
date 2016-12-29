#OwnerAppointment.feature

Feature: Request appointment
    As a pet owner
    I can request appointment
    So a vet can see my pet
    
	Scenario: Making appointment
	    Given I have a pet
	    And the clinic can treat my kind of pet
	    When I request an appointment on the portal
	    Then I should be on a waitlist to see a vet
	    
	    Given I want to make a new appointment
	    And I enter pet name
	    And I choose pet type
	    And I choose appointment date
	    And I choose vet to see
	    When I filling the form
	    Then I will achieve to create an upcoming appointment
	Scenario: Option to reschedule
		Given have an already created an upcoming appointment
		When I enter the portal
		Then I can see if my appointment has been rescheduled as alerts
	Scenario: Option to delete
		Given I have a previously created upcoming appointment
		When I enter the portal
		Then I have the option to delete an appointment
	Scenario: Option to rate
		Given I have completed an appointment
		When I enter the portal to view my completed appointments
		Then I have the option to rate my appointment
	