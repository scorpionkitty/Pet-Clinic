package com.sherlockHomies.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sherlockHomies.PetClinic.PetHomePage;

public class PetHomePageTest {
	WebDriver driver;
	
	@Before
	public void makeDriver() {
		String DRIVER_PATH = "C:/Users/Revature/Selenium/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
	
		driver = new ChromeDriver();
	}   
	
	@Test
	public void test() {
		PetHomePage page = new PetHomePage(driver);
		org.junit.Assert.assertEquals("Pet Vet", page.getPageTitle());
	
		page.selectPet("cat");
		page.viewUpcoming();
		
		//do this only if an appointment exists
		page.cancelAppointment();
	}
	
	
	
	
	
	
	
}
