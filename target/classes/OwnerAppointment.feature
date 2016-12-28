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