package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectAppointment {
	
	@FindBy(linkText = "Manage Provider Schedules")
	private WebElement selectprovider;
	
	public SelectAppointment(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickProvider() {
		selectprovider.click();
	}

}
