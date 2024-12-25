package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage {
	WebDriver driver;
	
	@FindBy(id="firstName")
	WebElement firstNameInput;
	
	@FindBy(id="lastName")
	WebElement lastNameInput;
	
	@FindBy(id="userEmail")
	WebElement emailInput;
	
	
	
	@FindBy(id="userNumber")
	WebElement mobileInput;
	
	@FindBy(id="dateOfBirthInput")
	WebElement dateOfBirtInput;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement monthDropdown;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	WebElement yearDropdown;
	
	@FindBy(xpath="//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[5]")
	WebElement dayPicker;
	
	@FindBy(id="subjectsInput")
	WebElement subjectsInput;
	
	@FindBy(xpath="//label[@for='hobbies-checkbox-2']")
	WebElement hobbiesCheckbox;
	
	@FindBy(id="uploadPicture")
	WebElement uploadPictureInput;
	
	@FindBy(id="currentAddress")
	WebElement currentAddressInput;
	
	@FindBy(id="state")
	WebElement stateDropDown;
	
	@FindBy(xpath="//div[text()='NCR']")
	WebElement stateOption;
	
	@FindBy(id="city")
	WebElement cityDropdown;
	
	@FindBy(xpath="//div[text()='Delhi']")
	WebElement cityOption;
	
	@FindBy(id="submit")
	WebElement submitButton;
	
	
	public PracticeFormPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void fillPersonDetails(String firstName,String lastName,String email,String mobile) {
		
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		mobileInput.sendKeys(mobile);
	}
	
	public void selectGender(String gender) {
		
		WebElement genderRadio=driver.findElement(By.xpath("//label[contains(text(), '"+ gender + "')]"));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].click();", genderRadio);
	}
	
	
	
	public void selectDateOfBirth(String month,String year,String day) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",dateOfBirtInput);
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dateOfBirtInput));
		
		dateOfBirtInput.click();
		new Select(monthDropdown).selectByVisibleText(month);
		new Select(yearDropdown).selectByVisibleText(year);
		dayPicker.click();
		
	}
	
	public void enterSubjects(String subject) {
		
		subjectsInput.sendKeys(subject);
		subjectsInput.sendKeys("\n");
		
	}
	
	public void selectHobbies() {
		
		hobbiesCheckbox.click();
	}
	
	public void uploadPicture(String filepath)
	{
		uploadPictureInput.sendKeys(filepath);
	}
	
	public void enterAddress(String address) {
		
		currentAddressInput.sendKeys(address);
	}
	
	public void selectStateAndCity() {
		
		stateDropDown.click();
		stateOption.click();
		cityDropdown.click();
		cityOption.click();
	}
	
	public void submitForm() {
		
		submitButton.click();
	
	}
	
	
}
