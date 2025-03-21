package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class variables {
    WebDriver driver;

    public By searchBox=(By.xpath("//*[@id='searchBar']"));

    public By bookvalue = By.xpath("//ul[@id='productList']/li");

}
