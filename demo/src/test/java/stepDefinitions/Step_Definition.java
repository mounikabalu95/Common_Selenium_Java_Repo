package com.adactin.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactin.baseclass.BaseClass;
import com.adactin.pom.Booking_ConfirmationPage;
import com.adactin.pom.Login_page;
import com.adactin.pom.Logout_Page;
import com.adactin.pom.Payment_Page;
import com.adactin.pom.SearchHotelPage;
import com.adactin.pom.Select_HotelPage;
import com.adactin.runner.Test_Runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Definition extends BaseClass {

	public static WebDriver driver = Test_Runner.driver;

	public Login_page login = new Login_page(driver);

	public SearchHotelPage search = new SearchHotelPage(driver);
	
	public Select_HotelPage select = new Select_HotelPage(driver);
	
	public Payment_Page payment = new Payment_Page(driver);
	
	public Logout_Page logout = new Logout_Page(driver);
	
	public Booking_ConfirmationPage booking= new Booking_ConfirmationPage(driver);

	@Given("user launch The Application")
	public void user_launch_the_application() {

		launchurl("https://adactinhotelapp.com/");


	}
	@When("user Enter The Username In Username Filed")
	public void user_enter_the_username_in_username_filed() {

		inputValue(login.getUser_name(), "rajasekarI");


	}
	@When(": User Enter The Password In Password Field")
	public void user_enter_the_password_in_password_field() {

		inputValue(login.getPassword(), "Raje@123");



	}


	@Then(": User Click On The Login Button And It Navigates To Search Hotel Page")
	public void user_click_on_the_login_button_and_it_navigates_to_search_hotel_page() {

		clickonElement(login.getSubmit());

	}

	@When(": user Select The Location")
	public void user_select_the_location() {

		singledropdown(search.getLocation(), "index", "1");

	}
	@When(": user Select The Hotel")
	public void user_select_the_hotel() {

		singledropdown(search.getHotels(), "index", "1");

	}
	@When(": user Select The RoomType")
	public void user_select_the_room_type() {

		singledropdown(search.getRoomtype(), "index", "1");

	}
	@When(": user Select The NumberofRooms")
	public void user_select_the_numberof_rooms() {
		singledropdown(search.getNumberofrooms(), "index", "1");

	}
	@When(": user Enters The CheckinDate")
	public void user_enters_the_checkin_date() {

		inputValue(search.getcheckinDate(), "21/03/2025");
	}
	@When(": user Enters The CheckOutDate")
	public void user_enters_the_check_out_date() {

		inputValue(search.getcheckoutDate(), "21/03/2025");

	}
	@When(": user Select The AdultPerRoom")
	public void user_select_the_adult_per_room() {
		singledropdown(search.getadultperroom(), "index", "1");

	}
	@When(": user Select The ChildrenPerRoom")
	public void user_select_the_children_per_room() {

		singledropdown(search.getchildperroom(), "index", "1");

	}
	@Then(": User Click on the Search Button And It Navigates To Select Hotel page")
	public void user_click_on_the_search_button_and_it_navigates_to_select_hotel_page() {

		clickonElement(search.getsearchhotel());


	}
	
	@When(": user Select The RadioButton")
	public void user_select_the_radio_button() {
		
		clickonElement(select.getradiobutton());
		
	   
	}
	@When(": user Select The ContinueButton")
	public void user_select_the_continue_button() {
		
		clickonElement(select.getcontinuebutton());
	    
	}
	
	@When(": user Enters The FirstName")
	public void user_enters_the_first_name() {
		
	inputValue(payment.getFirstName(), "rajasekar");
	   
	}
	
	@When(": user Enters The LastName")
	public void user_enters_the_last_name() {
		
    inputValue(payment.getLastName(), "inbasekaran");
	   
	}
	
	@When(": user Enters The Address")
	public void user_enters_the_address() {
		
	inputValue(payment.getAddress(), "No/2/91 A Kovur Chennai");
	   
	}
	@When(": user Enters The CCN Number")
	public void user_enters_the_ccn_number() {
		
	inputValue(payment.getCCNNumber(), "1234567890123456");
	
	}
	
	@When(": user Enters The CC TYpe")
	public void user_enters_the_cc_t_ype() {
		
	singledropdown(payment.getCCType(), "index", "1");
	 
	}
	@When(": user Enters The CC Expiry Month")
	public void user_enters_the_cc_expiry_month() {
		
	singledropdown(payment.getCCExpiryMonth(), "index", "1");
	
	}
	
	@When(": user Enters The CC Expiry Year")
	public void user_enters_the_cc_expiry_year() {
		
	singledropdown(payment.getCCExpiryYear(), "index", "10");

	}
	
	@When(": user Enters The CC CVV")
	public void user_enters_the_cc_cvv() {
		
    inputValue(payment.getCC_CVV(), "426");

	}
	
	@Then(": User Click on the BookNow Button It Navigates To Booking Cofirmation Page")
	public void user_click_on_the_book_now_button_it_navigates_to_booking_cofirmation_page() {
		
	clickonElement(payment.getBookNow());
	
	}
	
	@When(": user Click My Itineary Button")
	public void user_click_my_itineary_button() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(booking.getMyItineray()));
		
	    clickonElement(booking.getMyItineray());
	    
	}
	
	@Then(": user Click Logout Button")
	public void user_click_logout_button() {
		
		clickonElement(logout.getLogout());
	
	}


}
