package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment_Page {
	
	public static WebDriver driver;

	@FindBy(xpath = "//*[@id=\"first_name\"]")

	private WebElement FirstName;

	@FindBy(xpath = "//*[@id=\"last_name\"]")

	private WebElement LastName;

	@FindBy(xpath = "//*[@id=\"address\"]")

	private WebElement Address;


	@FindBy(xpath = "//*[@id=\"cc_num\"]")

	private WebElement CCN_Number;
	
	@FindBy(xpath = "//*[@id=\"cc_type\"]")

	private WebElement CC_Type;
	
	@FindBy(xpath = "//*[@id=\"cc_exp_month\"]")

	private WebElement CC_ExpiryMonth;
	
	@FindBy(xpath = "//*[@id=\"cc_exp_year\"]")

	private WebElement CC_ExpiryYear;
	
	@FindBy(xpath = "//*[@id=\"cc_cvv\"]")

	private WebElement CC_CVV;
	
	@FindBy(xpath = "//*[@id=\"book_now\"]")

	private WebElement BookNow;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getAddress() {
		return Address;
	}
	
	public WebElement getCCNNumber() {
		return CCN_Number;
	}
	
	public WebElement getCCType() {
		return CC_Type;
	}
	
	public WebElement getCCExpiryMonth() {
		return CC_ExpiryMonth;
	}
	
	public WebElement getCCExpiryYear() {
		return CC_ExpiryYear;
	}
	
	public WebElement getCC_CVV() {
		return CC_CVV;
	}
	
	public WebElement getBookNow() {
		return BookNow;
	}
	
	public  Payment_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
