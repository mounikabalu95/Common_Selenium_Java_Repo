package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking_ConfirmationPage {
	
	public static WebDriver driver;

	@FindBy(xpath = "//*[@name='my_itinerary']")

	private WebElement ClickMyItineray;
	
	
	public WebElement getMyItineray() {
		return ClickMyItineray;
	}
	
	

	public  Booking_ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
