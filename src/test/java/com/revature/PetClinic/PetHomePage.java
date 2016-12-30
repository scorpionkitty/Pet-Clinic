package com.revature.PetClinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PetHomePage {
	private WebDriver driver;
	
	//pet selection dropdown box
	private String petSelection = "petSelection";
	
	
	public PetHomePage(WebDriver driver) {
		this.driver = driver;
		driver.get("http://petvet.com");
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void selectPet(String pet) {
		Select petSelectionBox = new Select(driver.findElement(By.name(petSelection)));
		petSelectionBox.selectByValue(pet);
	}

	public void viewUpcoming() {
		driver.findElement(By.id("apptInfol")).click();
	}
	
	public void cancelAppointment() {
		driver.findElement(By.id("cancelAppt")).click();
	}
	
	public void viewVet1() {
		driver.findElement(By.id("vet1"));
	}
	
	
}
