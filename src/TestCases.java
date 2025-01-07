import static org.testng.Assert.assertEquals;

import java.nio.channels.Selector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	WebDriver driver = new ChromeDriver();

	String WebSite = "https://codenboxautomationlab.com/practice/";

	Random rand = new Random();

	@BeforeTest
	public void mySetup() {

		driver.manage().window().maximize();
		driver.get(WebSite);
	}

	@Test(priority = 1, description = "Radio button", invocationCount = 1, enabled = false)

	public void Radio_Button_Example() throws InterruptedException {

		List<WebElement> AllRadioButtons = driver.findElements(By.className("radioButton"));
		// to click on the first item
//AllRadioButtons.get(0).click();	

		int randomIndex = rand.nextInt(AllRadioButtons.size()); // size is 3 so it it will generate 0,1,2
		AllRadioButtons.get(randomIndex).click();

		// l3yon mahdi

		for (int i = 0; i < AllRadioButtons.size(); i++) {
			Thread.sleep(1000);
			AllRadioButtons.get(i).click();
		}
	}

	@Test(priority = 2, description = "dropDown Dynamic", enabled = false)
	public void Dynamic_Dropdown_Example() throws InterruptedException {
		String[] countryCodes = { "US", "CA", "OM", "BR", "AR", "FR", "DE", "IT", "ES" };
		int randomIndex = rand.nextInt(countryCodes.length);

		WebElement DynamicListInput = driver.findElement(By.id("autocomplete"));
		DynamicListInput.sendKeys(countryCodes[randomIndex]);
		Thread.sleep(1000);
		DynamicListInput.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 3, description = "static dropdown list", enabled = false)
	public void Static_Dropdown_Example() {
		WebElement SelectElement = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(SelectElement);

		// sel.selectByIndex(3);
		// sel.selectByValue("option2");
		// sel.selectByVisibleText("API");

	}

	@Test(priority = 4, description = "check box example", enabled = false)
	public void Checkbox_Example() throws InterruptedException {
		List<WebElement> CheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int randomIndex = rand.nextInt(CheckBoxes.size());
		System.out.println(CheckBoxes.size());
		Thread.sleep(1000);
		// CheckBoxes.getFirst().click();
		// CheckBoxes.getLast().click();
		// CheckBoxes.get(96).click();

		// CheckBoxes.get(randomIndex).click();

		// to select them all
		for (int i = 0; i < CheckBoxes.size(); i++) {
			CheckBoxes.get(i).click();
		}

	}

	@Test(priority = 5, description = "this is to move from window to another one", enabled = false)
	public void Switch_Window_Example() throws InterruptedException {

		WebElement OpenWindowButton = driver.findElement(By.id("openwindow"));
		OpenWindowButton.click();
		Thread.sleep(2000);
		List<String> windowsHandels = new ArrayList<String>(driver.getWindowHandles());
		// number of opened windows
		System.out.println(windowsHandels.size());
// switch to the other window 
		driver.switchTo().window(windowsHandels.get(1));
		// in the second window
		WebElement ContactButton = driver.findElement(By.id("menu-item-9680"));
		ContactButton.click();

		System.out.println(driver.getTitle() + " hello from the second window");

		driver.close();
		// switch to the first window
		driver.switchTo().window(windowsHandels.get(0));

	}

	@Test(priority = 6, description = "check moving to another tab", enabled = false)

	public void Switch_Tab_Example() throws InterruptedException {
		WebElement OpenTabButton = driver.findElement(By.id("opentab"));

		OpenTabButton.click();

		List<String> windowsHandels = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowsHandels.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}

	@Test(priority = 7, description = "Alert and confirm", enabled = false)
	public void Switch_To_Alert_Example() throws InterruptedException {
		WebElement nameBox = driver.findElement(By.id("name"));
		nameBox.sendKeys("abedalraheem");
		// WebElement AlertBox = driver.findElement(By.id("alertbtn"));
		// AlertBox.click();

		Thread.sleep(1000);
		// driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();

		WebElement ConfirmBox = driver.findElement(By.id("confirmbtn"));
		ConfirmBox.click();
		Thread.sleep(1000);
		// driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();

		// System.out.println(driver.switchTo().alert().getText());
	}

	@Test(priority = 8, description = " play with the data of the column ")

	public void Web_Table_Example() {

		WebElement TheTable = driver.findElement(By.id("product"));

		List<WebElement> theDataInsideTheTable = TheTable.findElements(By.tagName("tr"));

		for (int i = 1; i < theDataInsideTheTable.size(); i++) {
			
			int totalTdInTheRow = theDataInsideTheTable.get(i).findElements(By.tagName("td")).size();

			System.out.println(
					theDataInsideTheTable.get(i).findElements(By.tagName("td")).get(totalTdInTheRow - 1).getText());
		}

	}
}
