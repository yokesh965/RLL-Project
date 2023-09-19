package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	private WebDriverWait wait;

	@FindBy(id = "username")
	private WebElement usernameTextBox;

	@FindBy(id = "password")
	private WebElement passwordTextBox;

	@FindBy(id = "Inpatient Ward")
	private WebElement selectInpatientWard;

	@FindBy(id = "loginButton")
	private WebElement loginBtn;

	@FindBy(xpath = "//*[@id='content']/div[2]/div/h4")
	private WebElement homePageText;
	
	@FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/p[3]/label")
	private WebElement verifymsg;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public void enterUsername(String username) {
		// usernameTextBox.sendKeys("admin");
		usernameTextBox.sendKeys(username);
	}

	public void enterPassword(String password) {
		// passwordTextBox.sendKeys("Admin123");
		passwordTextBox.sendKeys(password);
	}

	public void username(String arg) {
		usernameTextBox.sendKeys(arg);
	}

	public void password(String arg) {
		passwordTextBox.sendKeys(arg);
	}

	public void clickInpatientWard() {
		selectInpatientWard.click();
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public String getHomePageText() {
		wait.until(ExpectedConditions.visibilityOf(homePageText));
		String text = homePageText.getText();
		return text;
	}
	
	
	public void EnterUsername(String username) {
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
	}

	public void EnterPassword(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}

	public void clickInPatientWard() {
		selectInpatientWard.click();
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public String VerifyMessage() throws InterruptedException {
		Thread.sleep(3000);
		String message = verifymsg.getText();
		return message;
	}

}
