package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPatient {
	
	private Actions actions;
	WebDriverWait wait;
	
	@FindBy(id="patient-search")
	private WebElement patientSearch;
	
	@FindBy(xpath = "(//tr[contains(@class, \"odd\")])[1]")
	private WebElement selectPatient;
	
	@FindBy(xpath = "//div[contains(@class,'col-12')]")
	private WebElement autoCompleteBox;
	
	@FindBy(xpath = "//*[@id=\"patient-search-results-table\"]/tbody/tr/td")
	private WebElement errmsg;
	
	@FindBy(xpath = "//em[contains(text(),'Patient ID')]")
	private WebElement verifymsg1;
	
	public SearchPatient(WebDriver driver) {
		 PageFactory.initElements(driver,this);
		 actions=new Actions(driver);
		 wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	
	public void clickSearch(String arg) throws InterruptedException {
		patientSearch.sendKeys(arg);
	}
	
	
	public  void hoverPatient() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(selectPatient));
		selectPatient.click();
	 }
	
	public void clickSearch1(String arg) throws InterruptedException  {
		patientSearch.sendKeys(arg);
		Thread.sleep(3000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}
	
	public String VerifyMessage1() throws InterruptedException {
		Thread.sleep(3000);
		String message = verifymsg1.getText();
		return message;
	}

	public String ErrorMsg() throws InterruptedException {
		Thread.sleep(3000);
		String message = errmsg.getText();
		return message;
	}
}
