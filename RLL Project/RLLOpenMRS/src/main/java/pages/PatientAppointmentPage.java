package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientAppointmentPage {
	
	private WebDriverWait wait;
	
	@FindBy(id = "noPatientAppointment")
	private WebElement availableAppointment;
	
	@FindBy(id = "noTimeSlots")
	private WebElement availableSlotText;

	@FindBy(xpath = "//*[@id='viewAllAppointmentTypes']/a")
	private WebElement viewAllTypes;
	
	@FindBy(xpath = "//*[@id='allAppointmentTypesModal']/div[2]/div[9]/a")
	private WebElement selectMentalType;

	@FindBy(xpath = "//*[@id='allAppointmentTypesModal']/div[2]/div[2]/a")
	private WebElement selectType;
	
	@FindBy(xpath = "//input[contains(@ng-model, 'includeSlotsThatRequireOverbook')]")
	private WebElement checkBox;

	@FindBy(xpath = "//button[contains(@ng-click, 'findAvailableTimeSlots()')]")
	private WebElement searchBtn;

	@FindBy(xpath = "//*[@id='appointmentTable']/div[2]/div/div/div/div[1]/div[2]/div")
	private WebElement timeBlock;

	@FindBy(xpath = "//button[contains(@ng-click, 'selectTimeSlot()')]")
	private WebElement nextBtn;

	@FindBy(xpath = "//*[@id='appointmentscheduling-patientAppointmentRequests']/div[1]/h2")
	private WebElement appointmentRequestPageText;
	
	//@FindBy(xpath = "//span[contains(@class, 'ngLabel ng-binding')][1]")
	@FindBy(xpath = "//*[@id='appointmentGridTable']/div[2]/div/div/div[5]/div[2]/div/span")
	private WebElement appointmentScheduledText;

	public PatientAppointmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public String getAvailableAppointment() {
		wait.until(ExpectedConditions.visibilityOf(availableAppointment));
		String listAppointmentText = availableAppointment.getText();
		return listAppointmentText;
	}
	
	public String getAvailableSlotText() {
		wait.until(ExpectedConditions.visibilityOf(availableSlotText));
		String slotText = availableSlotText.getText();
		return slotText;
	}
	
	
	public void clickViewAllTypes() {
		wait.until(ExpectedConditions.visibilityOf(viewAllTypes));
		viewAllTypes.click();
	}
	
	public void selectMentalServiceType() {
		wait.until(ExpectedConditions.visibilityOf(selectMentalType));
		selectMentalType.click();
	}

	public void selectServiceType() {
		wait.until(ExpectedConditions.visibilityOf(selectType));
		selectType.click();
	}

	public void clickCheckBox() {
		checkBox.click();
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}

	public void clicktimeBlock() {
		wait.until(ExpectedConditions.visibilityOf(timeBlock));
		timeBlock.click();
	}

	public void ClickNextBtn() {
		wait.until(ExpectedConditions.visibilityOf(nextBtn));
		nextBtn.click();
	}

	public String getAppointmentRequestPageText() {
		wait.until(ExpectedConditions.visibilityOf(appointmentRequestPageText));
		String text = appointmentRequestPageText.getText();
		return text;
	}
	
	public String getAppointmentBookedText() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(appointmentScheduledText));
		String bookedText = appointmentScheduledText.getText();
		return bookedText;
	}

}
