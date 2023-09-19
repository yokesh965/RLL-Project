package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecordVitalsPage {

	private WebDriverWait wait;
	
	@FindBy(id = "next-button")
	private WebElement nextBtn;
	
	@FindBy(id = "w8")
	private WebElement heightEditBox;
	
	@FindBy(id = "w10")
	private WebElement weightEditBox;
	
	@FindBy(id = "w12")
	private WebElement temperatureEditBox;
	
	@FindBy(id = "w14")
	private WebElement pulseEditBox;
	
	@FindBy(id = "w16")
	private WebElement respiratoryRateEditBox;
	
	@FindBy(id = "w18")
	private WebElement bloodPressureSystolicRateEditBox;
	
	@FindBy(id = "w20")
	private WebElement bloodPressureDiastolicEditBox;
	
	@FindBy(id = "w22")
	private WebElement oximeterReadingEditBox;
	
	@FindBy(xpath = "(//span[contains(@class, \"error field-error\")])[6]")
	private WebElement errorMsg;

	@FindBy(xpath = "//button[contains(@class, \"submitButton confirm right\")]")
	private WebElement saveBtn;
	
	public RecordVitalsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	}

	public void clickOnNextBtn() {
		nextBtn.click();
	}
	
	public void enterHeight(String height) {
		wait.until(ExpectedConditions.visibilityOf(heightEditBox));
		heightEditBox.sendKeys(height);
	}

	public void enterWeight(String string) {
		wait.until(ExpectedConditions.visibilityOf(weightEditBox));
		weightEditBox.sendKeys(string);		
	}

	public void enterTemperature(String string) {
		wait.until(ExpectedConditions.visibilityOf(temperatureEditBox));
		temperatureEditBox.sendKeys(string);	
	}

	public void enterPulse(String string) {
		wait.until(ExpectedConditions.visibilityOf(pulseEditBox));
		pulseEditBox.sendKeys(string);			
	}

	public void enterRespiratoryRate(String string) {
		wait.until(ExpectedConditions.visibilityOf(respiratoryRateEditBox));
		respiratoryRateEditBox.sendKeys(string);	
	}

	public void enterBloodPressureSystolic(String string) {
		wait.until(ExpectedConditions.visibilityOf(bloodPressureSystolicRateEditBox));
		bloodPressureSystolicRateEditBox.sendKeys(string);			
	}

	public void enterenterBloodPressureDiastolic(String string) {
		wait.until(ExpectedConditions.visibilityOf(bloodPressureDiastolicEditBox));
		bloodPressureDiastolicEditBox.sendKeys(string);	
	}

	public void enterOximeterReading(String string) {
		wait.until(ExpectedConditions.visibilityOf(oximeterReadingEditBox));
		oximeterReadingEditBox.sendKeys(string);	
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	
	public String getErrorMsg() {
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		String Text = errorMsg.getText();
		return Text;
	}
}
