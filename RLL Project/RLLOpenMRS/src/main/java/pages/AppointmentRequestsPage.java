package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentRequestsPage {

	@FindBy(xpath = "//button[contains(@ng-click, 'confirmAppointment()')]")
	private WebElement saveBtn;

	public AppointmentRequestsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ClickSaveBtn() {
		saveBtn.click();
	}

}
