package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

	private By emailTextField = By.id("//input[@id='email']");
	private By passwordTextField = By.id("//input[@id='pass']");
	private By loginButton = By.xpath("//input[@id='u_0_b']");
	private By firstNameTextField = By.xpath("//input[@id='u_0_f']");
	private By lastNameTextField = By.xpath("//input[@id='u_0_h']");
	private By mobileNumberTextField = By.xpath("//input[@id='u_0_k']");
	private By newPasswordTextField = By.xpath("//input[@name='reg_passwd__']");
	private By errorMessage = By.id("errorMessage");
	private By femaleGender = By.id("u_0_9");
	private By maleGender = By.id("u_0_a");
	private By messengerLink = By.id("");
	private By errorEmailMessage = By.xpath("//div[contains(text()," +
			"'Please enter a valid mobile number')]");
	private By monthdropDown = By.xpath("//select[@id='month']");
	private By currentMonth = By.xpath("//option[contains(text(),'Oct')]");

	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

	public void clickOnNewPasswordField() {
		clickOn(newPasswordTextField);
	}

	public void enterEmail(String enterEmail) {
		setValue(emailTextField, enterEmail);
	}

	public void enterPassword(String enterPassword) {
		setValue(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		setValue(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		setValue(lastNameTextField, lastName);
	}

	public void enterMobileNumber(String InvalidEmail) {
		setValue(mobileNumberTextField, InvalidEmail);
	}

	public void enterNewPassword(String password) {
		setValue(newPasswordTextField, password);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public boolean isGenderFemaleSelected() {
		return isElementSelected(femaleGender);
	}

	public void clickOnFemaleGender() {
		clickOn(femaleGender);
	}

	public boolean isGenderMaleSelected() {
		return isElementSelected(maleGender);
	}

	public void clickOnMaleGender() {
		clickOn(maleGender);
	}

	public void clickOnMessengerLink() {
		clickOn(messengerLink);
	}

	public String emailError() {
		return getTextFromElement(errorEmailMessage);
	}

	public void clickOnEmailMobileField() {
		clickOn(mobileNumberTextField);
	}

	public void clickOnBirthdayDropDown() {
		clickOn(monthdropDown);

	}

	public void selectFromDropdown(By locator) {
		selectFromDropdown(monthdropDown);

	}

	public void isOctoberSelected() {
		isElementSelected(currentMonth);

	}

	public boolean isDuplicate(){
		return isDropdownDuplicate(monthdropDown);
	}

}





