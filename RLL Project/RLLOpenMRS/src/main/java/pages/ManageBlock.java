package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageBlock {
private WebDriverWait wait;
	
	@FindBy(xpath = "//h1[contains(text(),'Manage Appointment Blocks')]")
	private WebElement verifyText;
	
	@FindBy(xpath = "(//div[contains(@class,'fc-day-number')])[17]")
	private WebElement selectDate;
	
	public ManageBlock(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public String getblockText() throws InterruptedException {
		Thread.sleep(6000);
		String getBlocktext = verifyText.getText();
		return getBlocktext;
	}
	
	public void clickDate() {
		wait.until(ExpectedConditions.visibilityOfAllElements(selectDate));
		selectDate.click();
	}
}
