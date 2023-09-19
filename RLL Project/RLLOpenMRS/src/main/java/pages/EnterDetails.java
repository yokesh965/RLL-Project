package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterDetails {

	private WebDriverWait wait;

	@FindBy(name = "givenName")
	private WebElement name;

	@FindBy(name = "familyName")
	private WebElement familyName;

	// @FindBy(id = " next-button")
	@FindBy(xpath = "//button[contains(@class,'confirm right')]")
	private WebElement nextbutton;

	@FindBy(xpath = "//*[@id=\"gender-field\"]/option[2]")
	private WebElement Gender;

	@FindBy(name = "birthdateDay")
	private WebElement Day;

	@FindBy(name = "birthdateMonth")
	private WebElement Month;

	@FindBy(name = "birthdateYear")
	private WebElement Year;

	@FindBy(id = "address1")
	private WebElement Address;

	@FindBy(id = "cityVillage")
	private WebElement CityVillage;

	@FindBy(id = "stateProvince")
	private WebElement StateProvince;

	@FindBy(id = "country")
	private WebElement Country;

	@FindBy(id = "postalCode")
	private WebElement PostalCode;

	@FindBy(name = "phoneNumber")
	private WebElement PhoneNumber;


	@FindBy(id = "submit")
	private WebElement Confirm;
	
	@FindBy(xpath = "//span[contains(@class, \"PersonName-givenName\")]")
	private WebElement givenNametext;

	@FindBy(xpath = "(//div[contains(@class, \"col-11 col-lg-10\")])[1]")
	private WebElement startVisitBtn;
	
	@FindBy(id = "start-visit-with-visittype-confirm")
	private WebElement confirmBtn;
	
	@FindBy(xpath = "/html/body/div[1]/div[3]/div[6]/div[2]/div/span")
	private WebElement patientID;

	public EnterDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	}
	
	public void enterDetails(String name, String familyName, String Gender, CharSequence Day, String Month, CharSequence Year, String Address, String CityVillage, String StateProvince, String Country, CharSequence PostalCode, CharSequence PhoneNumber)
	  {
	      this.name.sendKeys(name);
	      this.familyName.sendKeys(familyName);
		  this.nextbutton.click();
		  this.Gender.click();
		  this.nextbutton.click();
		  this.Day.sendKeys(Day);
		  this.Month.sendKeys(Month);
		  this.Year.sendKeys(Year);
		  this.nextbutton.click();
		  this.Address.sendKeys(Address);
		  this.CityVillage.sendKeys(CityVillage);
		  this.StateProvince.sendKeys(StateProvince);
		  this.Country.sendKeys(Country);
		  this.PostalCode.sendKeys(PostalCode);
		  this.nextbutton.click();
		  this.PhoneNumber.sendKeys(PhoneNumber);
		  this.nextbutton.click();
		  this.nextbutton.click();
	  }
	
	public void clickRegisterPatient() {
		wait.until(ExpectedConditions.visibilityOf(Confirm));
		Confirm.click();
	}
	
	public String getPatientName() {
		wait.until(ExpectedConditions.visibilityOf(givenNametext));
		String Name = givenNametext.getText();
		return Name;
	}
	
	public String getPatientID() {
		wait.until(ExpectedConditions.visibilityOf(patientID));
		String Name = patientID.getText();
		return Name;
	}
	
	public void clickOnStartVisitBtn(){
		wait.until(ExpectedConditions.visibilityOf(startVisitBtn));
		startVisitBtn.click();
	}
	
	public void clickOnConfirmBtn(){
		wait.until(ExpectedConditions.visibilityOf(confirmBtn));
		confirmBtn.click();
	}
}
