package stepDefinitions;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	WebDriver driver;
	
	@Given("I have opened the webite")
	public void i_have_opened_the_webite() {
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
	    System.out.println("Before...");
	}


	@Given("I want to add {double} to the first box")
	public void i_want_to_add_value_to_the_first_box(double firstNumber) {
		
		WebElement firstBox = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.elementToBeClickable(By.xpath
        ("html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]"
        		+ "/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[1]/input")));
		
		firstBox = driver.findElement(By.xpath
		("html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]"
				+ "/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[1]/input"));
		
		firstBox.sendKeys(Double.toString(firstNumber));

	}

	@Given("I want to add {double} to the second box")
	public void i_want_to_add_value_to_the_second_box(double secondNumber) {
		WebElement secondBox = driver.findElement(By.xpath
		("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]"
				+ "/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[2]/input"));
		
		secondBox.sendKeys(Double.toString(secondNumber));

	}

	@When("I press FIND ADDITION")
	public void i_press_find_addition() {
		WebElement findAdditionButton = driver.findElement(By.xpath
		("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]"
				+ "/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
		
		findAdditionButton.click();
	}

	@Then("I want to see the {double} on the screen")
	public void i_want_to_see_the_value_on_the_screen(double result) throws InterruptedException {
		
		WebElement resultBox = driver.findElement(By.xpath
		("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]"
				+ "/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[6]/input"));
		
		String valueOfBox = resultBox.getAttribute("value");
		double actualResult = Double.parseDouble(valueOfBox);
		
		assertEquals(result, actualResult, 0);
		
	}
	
	@After
	public void exit() {
		//driver.close();
		System.out.println("After...");
	}

}
