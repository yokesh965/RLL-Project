package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriverWait wait;
	
	@FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	WebElement FindPatient;

	@FindBy(linkText = "Appointment Scheduling")
	private WebElement appoinmentScheduling;
	
	@FindBy(xpath = "//a[contains(@id, \"vitals\")]")
	private WebElement captureVitals;
	
	@FindBy(xpath = "(//div[contains(@class,'row')])[2]")
	private WebElement verifyText;
	
	@FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
	private WebElement registeraPatient;
	
	@FindBy(linkText = "Appointment Scheduling")
	private WebElement btnAppointment;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	}

	public void findPatient() {
		FindPatient.click();
	}

	public void clickAppoinmentScheduling() {
		appoinmentScheduling.click();
	}

	public void clickCaptureVitals() {
		wait.until(ExpectedConditions.visibilityOf(captureVitals));
		captureVitals.click();
	}
	
	public String getpageText() {
		String pageText = verifyText.getText();
		return pageText;
	}
	
	public void clickRegisterPatient() {
		wait.until(ExpectedConditions.visibilityOf(registeraPatient));
		registeraPatient.click();
	}
	
	public void clickAppointment() {
		btnAppointment.click();
	}
}
