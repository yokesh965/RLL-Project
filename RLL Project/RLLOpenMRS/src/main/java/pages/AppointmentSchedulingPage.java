package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentSchedulingPage {
	
	private WebDriverWait wait;

	@FindBy(linkText = "Manage Appointments")
	private WebElement manageScheduling;

	@FindBy(xpath = "//*[@id='content']/h2")
	private WebElement manageAppointmentText;
	
	@FindBy(linkText = "Manage Provider Schedules")
	private WebElement selectprovider;
	
	@FindBy(linkText = "Manage Service Types")
	private WebElement serviceType;

	public AppointmentSchedulingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public void clickManageScheduling() {
		manageScheduling.click();
	}

	public String getManageAppointmentPageText() {
		wait.until(ExpectedConditions.visibilityOf(manageAppointmentText));
		String text = manageAppointmentText.getText();
		return text;
	}
	
	public void clickProvider() {
		wait.until(ExpectedConditions.visibilityOf(selectprovider));
		selectprovider.click();
	}
	
	public void clickOnManageServiceType() {
		wait.until(ExpectedConditions.visibilityOf(serviceType));
		serviceType.click();
	}
}
