package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageAppoinmentsPage {
	
	private WebDriverWait wait;

	@FindBy(id = "patient-search")
	private WebElement searchPatientTextBox;

	@FindBy(xpath = "//td[contains(@class, 'dataTables_empty')]")
	private WebElement emptyValue;

	// patient selecting by search tr[7] - it changeable
	@FindBy(xpath = "//table/tbody/tr[13]/td[1]")
	private WebElement selectPatient;

	@FindBy(xpath = "//*[@id='appointmentscheduling-patientAppointments']/div[1]/h2")
	private WebElement patientAppointmentPageText;

	public ManageAppoinmentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public void enterSearchPatientTextBox(String patientName) throws InterruptedException {
		// searchPatientTextBox.sendKeys("je");
		searchPatientTextBox.clear();
		searchPatientTextBox.sendKeys(patientName);
	}

	public String getEmptyValue() {
		wait.until(ExpectedConditions.visibilityOf(emptyValue));
		String emptytext = emptyValue.getText();
		return emptytext;
	}

	public void clickSelectPatient() {
		wait.until(ExpectedConditions.visibilityOf(selectPatient));
		selectPatient.click();
	}

	public String getPatientAppointmentPageText() {
		wait.until(ExpectedConditions.visibilityOf(patientAppointmentPageText));
		String text = patientAppointmentPageText.getText();
		return text;
	}

}
