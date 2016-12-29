Feature: Making appointment
	As a pet owner
	I want to be able to fill out a 'New appointment' form 
	So that can schedule an appointment with the doctor and date of my choosing
	
	Background: Login as a pet owner
		Given that the pet owner is presented with the new appointment form after clicking a date slot of a vet
		
	Scenario: Submit a new appointment with all the field filled out
		Given that I select an open appointment slot of the doctor I want
		When I make a new appointment with pet name, pet type, description, and contact method preference
		Then I will see my newly-created appointment under my upcoming appointments box
	
	Scenario: Submit a new appointment with pet name not filled out
		Given that I select an open appointment slot of the doctor I want
		When I make a new appointment with pet type, description, and contact method preference
		Then I will see a message saying ERROR: Must provide a pet name before processing
	
	Scenario: Submit a new appointment with a pet type not chosen
		Given that I select an open appointment slot of the doctor I want
		When I make a new appointment with pet name, description, and contact method preference
		Then I will see a message saying ERROR: Must pick a pet type before processing
		
	Scenario: Submit a new appointment with description not filled out
		Given that I select an open appointment slot of the doctor I want
		When I make a new appointment with pet name, pet type, and contact method preference
		Then I will see a message saying ERROR: Must provide a description must be filled before processing
		
	Scenario: Submit a new appointment with contact method preference not chosen
		Given that I select an open appointment slot of the doctor I want
		When I make a new appointment with pet name, pet type, and description
		Then I will see a message saying ERROR: Must pick a contact method preference before processing
	
	Scenario: