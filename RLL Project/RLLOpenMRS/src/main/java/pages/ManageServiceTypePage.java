package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageServiceTypePage {

	private WebDriverWait wait;
	
	@FindBy(xpath = "//button[contains(@class, \"confirm appointment-type-label right\")]")
	private WebElement newServiceType;
	
	@FindBy(id = "name-field")
	private WebElement ServiceNameTextBox;
	
	@FindBy(id = "duration-field")
	private WebElement DurationTextBox;
	
	@FindBy(id = "description-field")
	private WebElement descriptionTextBox;
	
	@FindBy(id = "save-button")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//*[@id=\"appointmentTypesTable\"]/tbody/tr[1]/td[1]")
	private WebElement serviceDetails;
	
	public ManageServiceTypePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	}
	
	public void clickOnNewServiceTypeBtn() {
		wait.until(ExpectedConditions.visibilityOf(newServiceType));
		newServiceType.click();
	}
	
	public void enterServiceName(String string) {
		wait.until(ExpectedConditions.visibilityOf(ServiceNameTextBox));
		ServiceNameTextBox.clear();
		ServiceNameTextBox.sendKeys(string);		
	}
	
	public void enterServiceDuration(String string) {
		wait.until(ExpectedConditions.visibilityOf(DurationTextBox));
		DurationTextBox.sendKeys(string);		
	}
	
	public void enterServiceDescription(String string) {
		wait.until(ExpectedConditions.visibilityOf(descriptionTextBox));
		descriptionTextBox.sendKeys(string);		
	}
	
	public void clickOnSaveBtn() {
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();	
	}

	public String getServiceName() {
		wait.until(ExpectedConditions.visibilityOf(serviceDetails));
		String Name = serviceDetails.getText();
		return Name;
	}
}
