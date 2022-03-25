package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleSearchPage {
	
	WebDriver wdriver;
	
	@FindBy(xpath="//*[@title='Search']")
	WebElement txt_input;
	
	@FindBy(xpath="//*[text()='Selenium']")
	WebElement lnk_txt;

	@FindBy(id = "login")
	WebElement btn_login;
	
	public GoogleSearchPage(WebDriver wdriver) {
		this.wdriver = wdriver;
		PageFactory.initElements(wdriver, this);
	}
	
	
	public void enterText(String text) {
		txt_input.sendKeys(text);
		txt_input.sendKeys(Keys.ENTER);
	}
	
	public void clickText() {
		lnk_txt.click();
		}
}
