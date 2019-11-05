package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);

	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public boolean isDropdownDuplicate(By Locator) {
		List<WebElement> ddList = webAction(Locator).findElements(Locator);

		List<String> ddListElements = new ArrayList<>();

		for (int i = 0; i < ddList.size(); i++)
			if (!ddList.equals(ddListElements)) {

			}

		return isDropdownDuplicate(Locator);

	}

	public void scrollBar(String y) throws InterruptedException {
		JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.getDriver();
		jsScrollBy.executeScript(y);
		Thread.sleep(4000);
	}

	public String replacement(By Locator) {
		getTextFromElement(Locator).replaceAll("\\D", "");
		return replacement(Locator);
	}

	public Boolean isDisplayed(By locator) {
		return SharedSD.getDriver().findElement(locator).isDisplayed();
	}

	public void scrollBarScroll(String y) throws InterruptedException {
		JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.getDriver();
		jsScrollBy.executeScript(y);
		Thread.sleep(4000);

	}

	public boolean isSelected(By locator) {
		return SharedSD.getDriver().findElement(locator).isSelected();

	}

	public void selectByText(By locator, String value) {
		WebElement selectText = SharedSD.getDriver().findElement(locator);
		Select text = new Select(selectText);
		text.selectByVisibleText(value);
	}

	public void selectByIndex(By locator, int value) {
		WebElement selectIndex = SharedSD.getDriver().findElement(locator);
		Select index = new Select(selectIndex);
		index.selectByIndex(value);

	}

	public void selectByValue(By locator, String value) {
		WebElement selectValue = SharedSD.getDriver().findElement(locator);
		Select value1 = new Select(selectValue);
		value1.selectByValue(value);
	}

	public void closePopup() {
		try {
			clickOn(By.xpath("//div[@id='managed-overlay']/button[@class='cta widget-overlay-close']"));
		} catch (TimeoutException e) {

		}
	}
}

