package buyproduct.gluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.*;
import pageobjects.*;
import selenium.*;

public class loginStepDefinition {
	private static WebDriver driver;
	private static AmazonLoginPage loginpage;
	private static amazonHomePage homepage;
	private static PageObjectManager pageobjectmanager;
	
	@BeforeClass
	public void openbrowser() {
		
	}
	@Before
	public void beforeScenario() {
	System.out.println("before scenario");
	}
	@After
	public void afterScenario() {
		System.out.println("after scenario");
		
		driver.quit();
	}
	
	@Given("^Navigate to Home Page$")
	public void navigate_to_Home_Page() throws Throwable {
		WebDriverManager webdrivermanager = new WebDriverManager();
		driver = webdrivermanager.getDriver();	
		driver.manage().window().maximize();
		Wait.untilPageLoadComplete(driver);
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		pageobjectmanager = new PageObjectManager(driver);
		homepage = pageobjectmanager.getHomePage();
		loginpage = pageobjectmanager.getloginpage();
	}

	@Given("^Click on signIn button$")
	public void click_on_signIn_button() throws Throwable {
		// homepage = new amazonHomePage(driver);		
		Actions hover = new Actions(driver);
		homepage.hoveroverSignIn(hover);

	}

	@When("^Enter the username and password$")
	public void enter_the_username_and_password() throws Throwable {
		// loginpage = new AmazonLoginPage(driver);		
		loginpage.enterEmail(FileReaderManager.getInstance().getConfigReader().getUser());
		loginpage.clickContinue();
		loginpage.enterPassword(FileReaderManager.getInstance().getConfigReader().getPassword());
		loginpage.clicksignInButon();
	}

	@Then("^Validate you are navigated to respective user home page$")
	public void validate_the_tile_page_for_home_page() throws Throwable {
		String actualusername = homepage.getUserName();
		String expectedUsername = FileReaderManager.getInstance().getConfigReader().getHomePageUserName();
		try {
			Assert.assertEquals(actualusername, expectedUsername);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failed to login!!");
		}
		
	}

	@When("^Click on Need Help Label$")
	public void click_on_Need_Help_Label() throws Throwable {
		loginpage.clickNeedHelp();
	}

	@When("^Click on Forget Password$")
	public void click_on_Forget_Password() throws Throwable {
		loginpage.clickForgotPassword();
	}

	@Then("^Verify you are navigated to Amazon Password Assistance page$")
	public void verify_you_are_navigated_to_Amazon_Password_Assistance_page() throws Throwable {
		try {
		Assert.assertEquals(driver.getTitle(),"Amazon Password Assistance");
		}
		catch(Exception e) {
			System.out.println("Not Navigated to amazon password assistance page");
		}
	}

	@When("^Click on Create new  account button$")
	public void click_on_Create_new_account_button() throws Throwable {
		loginpage.clickCreateNewAccount();
	}

	@Then("^Verify you are navigated to new account page$")
	public void verify_you_are_navigated_to_new_account_page() throws Throwable {
		try {
		Assert.assertEquals(driver.getTitle(),"Amazon Registration");
		}
		catch(Exception e) {
			System.out.println("Not Navigated to amazon registeration page");
		}
	}

}
