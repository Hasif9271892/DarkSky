package framework.webPages;
import org.openqa.selenium.*;
import stepdefinition.SharedSD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LandingPageDarkSky extends BasePage {
    private static final int HOUR = 3600 * 1000;
    private By darkSkyApi = By.linkText("Dark Sky API");
    private By firstTempTimeLine = By.xpath("//span[@class='first']");
    private By lowTempTimeLine = By.xpath("//span[@class='low-temp-text']");
    private By highTempTimeLine = By.xpath("//span[@class='high-temp-text']");
    private By rangeBar = By.xpath("//span[contains(text(),'Today')]");
    private By tempRangeMin = By.xpath("//span[@class='minTemp']");
    private By tempRangeMax = By.xpath("//span[@class='maxTemp']");
    private By afterToggleLeftNum = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[1]");
    private By afterToggleRightNum = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[1]");
    private By hoursOnDarkSky = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[3]");




    private By timeLineHour = By.xpath("//div[@id='timeline']//div[@class='hours']//span//span");

    //Methods
    public void clickDarkSkyApi() {
        clickOn(darkSkyApi);
    }

    public Boolean compareTemperature() {
        Boolean timeLineResults = false;
        String tempFirst = getTextFromElement(firstTempTimeLine).replaceAll("°", "");
        Integer firsTemperature = Integer.valueOf(tempFirst);
        int lowTemperature = Integer.parseInt(getTextFromElement(lowTempTimeLine).replace("˚", ""));
        int highTemperature = Integer.parseInt(getTextFromElement(highTempTimeLine).replace("˚", ""));
        if (firsTemperature < lowTemperature || firsTemperature > highTemperature) {
            timeLineResults = false;
            } else {
            timeLineResults = true;
        }
    return timeLineResults;
}

    public void clickOnToday() throws InterruptedException {
       scrollBar("scrollBy (0,900)");
        clickOn(rangeBar);
    }

    public Boolean isDisplayAvailable() {
        Boolean compare = false;
        String tempMIN = replacement(tempRangeMin);
        int tempLOW = Integer.parseInt(tempMIN);
        String tempMAX = replacement(tempRangeMax);
        int tempHIGH = Integer.parseInt(tempMAX);
        String toggleLowLeft = replacement(afterToggleLeftNum);
        int toggleLeft = Integer.parseInt(toggleLowLeft);
        String toggleRightHigh = replacement(afterToggleRightNum);

        int toggleRight = Integer.parseInt(toggleRightHigh);
        if (!(toggleLeft == tempLOW) || !(toggleRight == tempHIGH)) {
            compare = false;
             } else {
            compare = true;
        }
        return compare;
    }

    public Boolean isTimeIncremented() {
        Boolean result = false;
        ArrayList<String> hour = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("h");
        Date date = new Date();
        String t = sdf.format(date);
        hour.add(t);
        for (int i = 0; i < 11; i++) {
            Date newDate = new Date(date.getTime() + 2 * HOUR);
            String t2 = sdf.format(newDate);
            hour.add(t2);
            date = newDate;
        }
        String x = (getTextFromElement(hoursOnDarkSky).replaceAll("[Aa-zZ]", "").replace("N", t));
        for (int J = 0; J < hour.size(); J++) {
            if (x.contains(hour.get(J))) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }


//    public void incrementedTIme(){
//        List <WebElement> timeIncrement = webAction(timeLineHour).findElements(timeLineHour);
//


    }

