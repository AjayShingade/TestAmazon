package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class amazonHomePage {
	
	public  amazonHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.CSS , using="a#nav-link-accountList")
	private WebElement signInLabel;
	@FindBy(how=How.CSS , using="a.nav-action-button")
	private WebElement signInButton;
	
	public void hoveroverSignIn(Actions hover) {
		
		hover.moveToElement(signInLabel).build().perform();
		signInButton.click();
	}
	public String getUserName() {
		return (signInLabel.findElement(By.cssSelector("span.nav-line-1")).getText());
	}
}
