package com.adactin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	public static WebDriver driver;

	@FindBy(xpath = "//*[@id='username']")

	private WebElement user_name;

	@FindBy(xpath = "//*[@id=\'password\']")

	private WebElement password;

	@FindBy(xpath = "//*[@id=\"login\"]")

	private WebElement submit;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUser_name() {
		return user_name;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public  Login_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
		
	}


	
	








