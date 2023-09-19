package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyPage {
	//@FindBy(xpath="//span[contains(@class,'PersonName-givenName')]")
	@FindBy(xpath="//div[contains(@class,'action-section')]")
	

	static WebElement verifyText;
	public VerifyPage(WebDriver driver) {
		 PageFactory.initElements(driver,this);


}
	public static String getVerifyMsg() throws InterruptedException {
		Thread.sleep(2000);
		String message=verifyText.getText();
		return message;
	}
	}
