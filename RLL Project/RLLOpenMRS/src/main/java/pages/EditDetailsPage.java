package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditDetailsPage {
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "(//div[contains(@class, \"col-11 col-lg-10\")])[7]")
	private WebElement edit;

	@FindBy(id = "demographics-edit-link")
	WebElement Demographics;
	

	@FindBy(name = "givenName")
	WebElement editedname;
	
	@FindBy(id = "save-form")
	WebElement save;
	
	@FindBy(id = "registration-submit")
	WebElement conform;

	public EditDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	}

	public void clickEdit() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(edit));
		edit.click();
	}

	public void enterName(String arg) {
		editedname.clear();
		editedname.sendKeys(arg);

	}

	public void clickSave() {
		save.click();
	}

	public void clickConform() {
		conform.click();
	}

	public void clickDemographics() {
		Demographics.click();
	}

}
