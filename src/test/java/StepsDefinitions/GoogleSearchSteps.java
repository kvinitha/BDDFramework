package StepsDefinitions;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.GoogleSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver wdriver=null;
	GoogleSearchPage searchPage;

	
	@Given("launch the browser with application portal")
	public void launch_the_browser_with_application_portal() {
		
		String projectPath = System.getProperty("user.dir");
	    //launch the browser
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
        wdriver = new ChromeDriver();
        wdriver.get("https://www.google.com");
		wdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //wdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		wdriver.manage().window().maximize();
		}

	@Given("enter the text and search for it")
	public void enter_the_text_and_search_for_it() {
	    // Write code here that turns the phrase above into concrete actions
		searchPage= new GoogleSearchPage(wdriver);
		searchPage.enterText("Selenium Testing");
		}

	@When("select value in the search area")
	public void select_value_in_the_search_area() {
	    // Write code here that turns the phrase above into concrete actions
		searchPage.clickText();
	   }

	@When("open the serch page and check the {string} title")
	public void open_the_serch_page_and_check_the_title(String title) {
	    // Write code here that turns the phrase above into concrete actions
	 String pageTitle= wdriver.getTitle();
	 Assert.assertEquals(pageTitle, title);
	}

	@Then("close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    wdriver.close();
	}
}
