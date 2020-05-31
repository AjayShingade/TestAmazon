package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {
	public AmazonLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "input#ap_email")
	private WebElement email;
	@FindBy(how = How.CSS, using = "input#continue")
	private WebElement continuebutton;
	@FindBy(how = How.CSS, using = "input#ap_password")
	private WebElement password;
	@FindBy(how = How.CSS, using = "input#signInSubmit")
	private WebElement signInButton;
	@FindBy(how = How.CSS, using = "span.a-expander-prompt")
	private WebElement need_help_label;
	@FindBy(how = How.CSS, using = "a.auth-fpp-link-bottom")
	private WebElement forgot_password_label;
	@FindBy(how = How.CSS, using = "a#createAccountSubmit")
	private WebElement create_new_account_button;
	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}
	public void clickContinue() {
		continuebutton.click();
	}
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	public void clicksignInButon() {
		signInButton.click();
	}
	public void clickNeedHelp() {
		need_help_label.click();
	}
	public void clickForgotPassword() {
		forgot_password_label.click();
	}
	public void clickCreateNewAccount() {
		create_new_account_button.click();
	}
}
