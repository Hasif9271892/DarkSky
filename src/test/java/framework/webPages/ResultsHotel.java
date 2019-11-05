package framework.webPages;

import org.openqa.selenium.*;
import stepdefinition.SharedSD;
import java.util.ArrayList;
import java.util.List;

public class ResultsHotel extends BasePage {
    private HotelsLandingPage land = new HotelsLandingPage();
    private By distanceFilter = By.linkText("Distance");

    public WebElement starCount(String stars) {
        String xpath = "//span[@class='star-rating' and text()='%s']";
        By classStar = By.xpath(String.format(xpath, stars));
        clickOn(classStar);
        return SharedSD.getDriver().findElement(classStar);
    }


    public Boolean hasXStars(String rating) throws InterruptedException {
        String[] ratingDisplay = rating.split("-");
        int minStar = Integer.parseInt(ratingDisplay[0]);
        JavascriptExecutor jse = (JavascriptExecutor) SharedSD.getDriver();
        for (int scroll = 0; ; scroll++) {
            if (scroll >= 60) {
                break;
            }
            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(2000);

            List<WebElement> starRatings = SharedSD.getDriver().findElements(By.xpath("//span[contains(@class,'" +
                    "star-rating-text-strong')]"));
            for (WebElement starRating : starRatings) {

                String[] displayedRating = starRating.getText().split("-");
                int star = Integer.parseInt(displayedRating[0].split("\\.")[0]);

                if (star != minStar) {
                    return false;

                }

            }

        }
        return true;
    }

    public List<String> getHotelsWithinSpecifiedRadius(int distance) throws InterruptedException {
        List<String> listOfHotels = new ArrayList<String>();
        clickOn(distanceFilter);
        List<WebElement> ddMenu = SharedSD.getDriver().findElements(By.xpath("//a[contains(text(),'Kennedy Intern" +
                "ational Airport (JFK)')]"));
        for (WebElement dd : ddMenu) {
            dd.click();
        }
        Thread.sleep(5000);

        JavascriptExecutor jse = (JavascriptExecutor) SharedSD.getDriver();
        for (int scroll = 0;; scroll++) {
            if (scroll >= 60) {
                break;
            }
            jse.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(2000);

            List<WebElement> listings = SharedSD.getDriver().findElements(By.xpath("//a[@class='property-name-link']"));
            List<WebElement> distances = SharedSD.getDriver().findElements(By.xpath("//ul[@class='property-land" +
                    "3marks']/li[1]"));
            int listingSize = listings.size();

            for (int i =0;i<listingSize;i++) {
                WebElement title = listings.get(i);
                WebElement distanceOnIdCard = distances.get(i);

                String displayDistance = distanceOnIdCard.getText().substring(0, 3);
                double displayDistanceParsed = Double.parseDouble(displayDistance);
                if (displayDistanceParsed > distance) {
                    return listOfHotels;
                } else {
                    listOfHotels.add(title.getText());
                }
            }

        }
        return listOfHotels;
    }

    public boolean todayDealisLessThan200(int priceNumber){

        try {
                WebElement todayDealIdPrice = SharedSD.getDriver().findElement(By.xpath("//li/article/a/../section//" +
                        "ins"));
                    String dealPrice = todayDealIdPrice.getText().substring(1);
                    int dealPriceParsed = Integer.parseInt(dealPrice);
                    if(dealPriceParsed > priceNumber)
                    return false;
                    else return true;
        }
            catch (NoSuchElementException exception) {
            return false;
        }
    }
}



