package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAppointment {
	private Actions actions;
	
	@FindBy(xpath = "(//input[contains(@ng-change,'updateSaveButton()')])[1]")
	private WebElement selectUser;
	
	@FindBy(id = "createAppointmentBlock")
	private WebElement enterService;
	
	@FindBy(xpath = "//button[contains(@class,'confirm')]")
	private WebElement btnSave;
	
	@FindBy(xpath = "//div[contains(@class,'text ng-binding')]")
	private WebElement verifyMsg;
	
	@FindBy(xpath = "//button[contains(@class,'cancel')]")
	private WebElement btnCancel;
	
	@FindBy(xpath = "(//div[contains(@class,'fc-event-inner')])[2]")
	private WebElement btnBlock;
	
	@FindBy(linkText = "Edit")
	private WebElement btnEdit;
	
	@FindBy(xpath = "//h1[contains(text(),'Edit Appointment Block')]")
	private WebElement msgVerify;
		
	@FindBy(xpath = "//h1[contains(text(),'Manage Appointment Blocks')]")
	private WebElement confirmMsg;
	
	public CreateAppointment(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void enterUser() throws InterruptedException {
		selectUser.sendKeys("Super User");
		Thread.sleep(5000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void enterServiceType() {
		enterService.sendKeys("Dermatology");
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void clickSave() throws InterruptedException {
		Thread.sleep(5000);
		btnSave.click();
	}
	
	public String getcancelMsg() throws InterruptedException {
		Thread.sleep(3000);
		String findMsg = verifyMsg.getText();
		return findMsg;
	}
	
	public void clickCancel() {
		btnCancel.click();
	}
	
	public void clickEditBlock() throws InterruptedException {
		Thread.sleep(3000);
		btnBlock.click();
		Thread.sleep(2000);
		btnEdit.click();
	}
	
	public String verifyeditMsg() throws InterruptedException {
		Thread.sleep(3000);
		String editMsg = msgVerify.getText();
		return editMsg;
	}
	
	public void viewSelect() throws InterruptedException {
		enterService.sendKeys("a");
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
	}
	
	public void clickCloseSave() throws InterruptedException {
		btnSave.click();
	}
	
	public String getconfirmMsg() throws InterruptedException {
		Thread.sleep(3000);
		String getconfirmMsg = confirmMsg.getText();
		return getconfirmMsg;
	}

	
	
	
	

}
