package com.adactin.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.compress.compressors.FileNameUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	public static WebDriver driver;

	public static String value;

	public static WebDriver getdriver(String browser) {

		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		if (browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver",
					"C:\\Metadata exchange apps\\Selenium_practice\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Metadata exchange apps\\Selenium_practice\\chromedriver-win64\\chromedriver-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Metadata exchange apps\\Selenium_practice\\chromedriver-win64\\chromedriver-win64\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		return driver;


	}


	public static String particular_Data(String path, int row_Index, int cell_Index) throws IOException{



		File f = new File(path);

		FileInputStream fis = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis);

		Sheet sheetAt = w.getSheetAt(0);

		Row row = sheetAt.getRow(row_Index);

		Cell cell = row.getCell(cell_Index);

		CellType cellType = cell.getCellType();

		if (cellType.equals(CellType.STRING)) {

			value = cell.getStringCellValue();
		}

		else if (cellType.equals(CellType.NUMERIC)) {

			double numericCellValue = cell.getNumericCellValue();

			int cellvalue = (int) numericCellValue;

			value = String.valueOf(cellvalue);

		}
		return value;

	}



	// get
	public static void launchurl(String url) {
		driver.get(url);

	}

	// title
	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// CurrentUrl
	public static void currenturl() {
		String cu = driver.getCurrentUrl();
		System.out.println(cu);
	}

	// navigateto
	public static void navigateTo(String url) {
		driver.navigate().to(url);

	}

	// navigatetoback
	public static void navigatetoback() {
		driver.navigate().back();

	}

	// navigatetofrwd
	public static void navigatetoforward() {
		driver.navigate().forward();

	}

	// navigatetorefresh
	public static void navigateRefresh() {
		driver.navigate().refresh();

	}

	public static void closebrowser() {
		driver.close();

	}
	// webelement methods

	public static void inputValue(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void clickonElement(WebElement element) {
		element.click();

	}

	public static void cleartheelement(WebElement element) {
		element.clear();

	}

	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void isdisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("isdisplayed:" + displayed);
	}

	public static void isenabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println("isenabled:" + enabled);

	}

	public static void isselected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println("isselected:" + selected);

	}

	public static void getattribute(WebElement element, String options) {
		if (options.equalsIgnoreCase("value")) {
			String attribute2 = element.getAttribute("value");
			System.out.println(attribute2);
		} else if (options.equalsIgnoreCase("name")) {
			String attribute = element.getAttribute("name");
			System.out.println(attribute);
		}
	}

	public static void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// dropdown
	public static void singledropdown(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		} else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("visibleText")) {
			s.selectByVisibleText(value);
		}
	}

	// alert
	public static void alertaccept(WebElement element, String option) {
		Alert element1 = driver.switchTo().alert();
		if (option.equalsIgnoreCase("accept")) {
			element1.accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			element1.dismiss();
		} else if (option.equalsIgnoreCase("text")) {
			String text = element1.getText();
			System.out.println(text);
		}
	}

	// actions
	public static void actionsmethod(WebElement element, String option) {
		Actions act = new Actions(driver);
		if (option.equalsIgnoreCase("movetoelement")) {
			act.moveToElement(element).build().perform();
		} else if (option.equalsIgnoreCase("click")) {
			act.click(element).build().perform();
		} else if (option.equalsIgnoreCase("contextclick")) {
			act.contextClick(element).build().perform();
		}
	}

	// robot
	public static void robotmethod(String option) throws AWTException {
		Robot r = new Robot();
		if (option.equalsIgnoreCase("down")) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		} else if (option.equalsIgnoreCase("up")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		} else if (option.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
		}
	}

//	// screenshot
//	public static void screenshot(String location) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File destination = new File(location);
//		FileUtils.copyFile(source, destination);
//	}

	// windowshandle+

	public static void windowshandle(String type, String destination) {
		if (type.equalsIgnoreCase("singlewindow")) {
			String windowHandle = driver.getWindowHandle();
			System.out.println(windowHandle);
		} else if (type.equalsIgnoreCase("multiplewindows")) {
			Set<String> windowHandles = driver.getWindowHandles();
			for (String all : windowHandles) {
				System.out.println("***********all window*********");
				String title1 = driver.switchTo().window(all).getTitle();
				System.out.println(title1);
			}
			String actualTitle = destination;
			for (String all : windowHandles) {
				if (driver.switchTo().window(all).getTitle().equals(actualTitle)) {

				}
			}
		}

	}

	// multidropdown
	public static List<WebElement> getalloptions(WebElement element, String size) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement geto : options) {
			String text = geto.getText();
			System.out.println(text);
		}
		int size1 = options.size();
		System.out.println(size1);
		return options;
	}// all selected option

	public static void getallselected(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		}
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement selected : allSelectedOptions) {
			String text1 = selected.getText();
			System.out.println(text1);
		}
	}

	// getfirstselected
	public static void getfirstselected(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}

	// ismultiple
	public static void isMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	// frames
	public static void framemthd(WebElement element) {
		driver.switchTo().frame(element);

	}
	
	

}
