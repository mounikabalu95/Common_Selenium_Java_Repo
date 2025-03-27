package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page {
	
	public static WebDriver driver;

	@FindBy(xpath = "//*[@id=\"logout\"]")

	private WebElement Logout;
	
	
	public WebElement getLogout() {
		
		return Logout;
	}
	
	

	public  Logout_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}


