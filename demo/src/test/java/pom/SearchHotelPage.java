package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {

	public static WebDriver driver;

	@FindBy(xpath = "//*[@id=\"location\"]")

	private WebElement Location;

	@FindBy(xpath = "//*[@id=\"hotels\"]")

	private WebElement Hotels;

	@FindBy(xpath = "//*[@id=\"room_type\"]")

	private WebElement RoomType;


	@FindBy(xpath = "//*[@id=\"room_nos\"]")

	private WebElement NumberofRooms;

	@FindBy(xpath = "//*[@id=\"datepick_in\"]")

	private WebElement Checkindate;

	@FindBy(xpath = "//*[@id=\"datepick_out\"]")

	private WebElement Checkoutdate;

	@FindBy(xpath = "//*[@id=\"adult_room\"]")

	private WebElement AdultPerRoom;

	@FindBy(xpath = "//*[@id=\"child_room\"]")

	private WebElement Childrenperroom;
	
	@FindBy(xpath = "//*[@id=\"Submit\"]")

	private WebElement searchhotel;


	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLocation() {
		return Location;
	}

	public WebElement getHotels() {
		return Hotels;
	}

	public WebElement getRoomtype() {
		return RoomType;
	}
	
	public WebElement getNumberofrooms() {
		return NumberofRooms;
	}

	public WebElement getcheckinDate() {
		return Checkindate;
	}

	public WebElement getcheckoutDate() {
		return Checkoutdate;
	}
	
	public WebElement getadultperroom() {
		return AdultPerRoom;
	}
	
	public WebElement getchildperroom() {
		return Childrenperroom;
	}
	
	public WebElement getsearchhotel() {
		return searchhotel;
	}
	
	

	public  SearchHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



}
