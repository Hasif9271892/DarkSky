package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;
import java.util.List;

public class HotelsLandingPage extends BasePage {

    private By destination = By.xpath("//input[@id='qf-0q-destination']");
    private By roomsMoreOptions = By.xpath("//select[@id='qf-0q-compact-occupancy']//option[3]");
    public By roomsDropDownList = By.xpath("//select[@id='qf-0q-rooms']");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By containsRoom = By.xpath("//span[contains(text(),'Room')]");

    public void setNyDestination() throws InterruptedException {
        closePopup();
        SharedSD.getDriver().findElement(destination).sendKeys("New York, New York");
        Thread.sleep(3000);
        String selectText = "New York, New York, United States of America";

        List<WebElement> autoSuggest = SharedSD.getDriver().findElements(By.xpath("//*[(@role='listbox')]//tbody[1]//div[2]"));
        for(WebElement options : autoSuggest) {
            if (options.getText().equals(selectText)) {
                options.click();
                clickOn(searchButton);
                break;
            }
        }
    }

    public WebElement rooms(){
        clickOn(roomsMoreOptions);
        return SharedSD.getDriver().findElement(roomsDropDownList);
    }

    public int roomEntriesCount(){
      return SharedSD.getDriver().findElements(containsRoom).size();
    }
}
