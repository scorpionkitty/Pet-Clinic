Feature: Making appointment
	As a pet owner
	I want to be able to fill out a New appointment form 
	So that can schedule an appointment with the vet and date of my choosing
		
	Scenario Outline: Submit a new appointment with all the field filled out
		Given I select an open appointment slot with "<vet>"
		When I make a new appointment with description: "<description>", contact method: "<contact>", and credit card: <information>
		Then  I get "<result>"
		
			Examples:
			|	vet						|	description									|	contact |	information	|	result	|
			|	George Perez	|	My cat is purring too much	|	Email		|	123456789		|	Success	|
			|	Jeffrey Lau		|	My dog is vomitting					|	Phone		|	987654321		|	Success	|	
	
	Scenario Outline: Submit a new appointment with description not filled out
		Given I select an open appointment slot with "<vet>"
		When I make a new appointment with contact method: "<contact>" and credit card: <information>
		Then  I get "<result>"
		
			Examples:
			|	vet						|	description		|	contact |	information	|	result	|
			|	George Perez	|								|	Email		|	123456789		|	Success	|
			|	Jeffrey Lau		|								|	Phone		|	987654321		|	Success	|	
	
	Scenario Outline: Submit a new appointment with a contact method method not chosen
		Given I select an open appointment slot with "<vet>"
		When I make a new appointment with description: "<description>" and credit card: <information>
		Then  I get "<result>"
		
			Examples:
			|	vet						|	description									|	contact |	information	|	result	|
			|	George Perez	|	My cat is purring too much	|					|	123456789		|	Failed	|
			|	Jeffrey Lau		|	My dog is vomitting					|					|	987654321		|	Failed	|	
		 
	Scenario Outline: Submit a new appointment with credit card information not filled out
		Given I select an open appointment slot with "<vet>"
		When I make a new appointment with description: "<description>" and contact method: "<contact>"
		Then  I get "<result>"
		
			Examples:
			|	vet						|	description									|	contact |	information	|	result	|
			|	George Perez	|	My cat is purring too much	|	Email		|							|	Failed	|
			|	Jeffrey Lau		|	My dog is vomitting					|	Phone		|							|	Failed	|	
		