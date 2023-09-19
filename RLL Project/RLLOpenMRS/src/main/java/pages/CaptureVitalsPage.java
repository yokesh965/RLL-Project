package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaptureVitalsPage {

	private WebDriverWait wait;
	
	@FindBy(id = "patient-search")
	private WebElement searchBox;
	
	@FindBy(xpath = "(//tr[contains(@class, \"odd\")])[1]")
	private WebElement patientDetails;
	
	@FindBy(xpath = "//*[@id=\"existing-encounters\"]/table/tbody/tr[1]/td[1]")
	private WebElement text;
	
	@FindBy(id = "coreapps-vitals-confirm")
	private WebElement confirmBtn;
		
	public CaptureVitalsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	}

	public void enterPatientName(String PatientName) {
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(PatientName);
	}
	
	public void clickOnPatient() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(patientDetails));
		patientDetails.click();
	}
	
	
	public void clickOnConfirmBtn(){
		wait.until(ExpectedConditions.visibilityOf(confirmBtn));
		confirmBtn.click();
	}
	
	public String getText(){
		wait.until(ExpectedConditions.visibilityOf(text));
		String Text = text.getText();
		return Text;
	}
}
