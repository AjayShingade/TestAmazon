package managers;
import org.openqa.selenium.WebDriver;

import pageobjects.AmazonLoginPage;
import pageobjects.amazonHomePage;



public class PageObjectManager {

	private static WebDriver driver;
	private static AmazonLoginPage loginpage;
	private static amazonHomePage homepage;
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public static AmazonLoginPage getloginpage() {
		return (loginpage == null) ? loginpage = new AmazonLoginPage(driver) : loginpage;	
	}
	public static amazonHomePage getHomePage() {
		return(homepage==null)? homepage = new amazonHomePage(driver):homepage;
	}
	
}