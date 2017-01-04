package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigProperties;

import static org.testng.Assert.assertEquals;


public class SearchPage extends Page {

    private String title = "SS.lv Электротехника. Искать объявления. Поиск объявлений";

    @FindBy(id = "ptxt")
    private WebElement searchField;

    @FindBy(name = "topt[8][min]")
    private WebElement minPrise;

    @FindBy(name = "topt[8][max]")
    private WebElement maxPrice;

    @FindBy(name = "btn")
    private WebElement searctBtn;

    public SearchPage(WebDriver driver){
        super(driver);
    }

    public SearchResults findNeededProduct(String searchFor){
        assertEquals(title, getTitle());
        enterText(searchField, searchFor);
        clickOn(searctBtn);
        return PageFactory.initElements(driver, SearchResults.class);
    }

    public SearchResults advancedSearch(String searchFor){
        assertEquals(title, getTitle());
        enterText(searchField, searchFor);
        enterText(minPrise, ConfigProperties.getPropeties("minVal"));
        enterText(maxPrice, ConfigProperties.getPropeties("maxVal"));
        sleepFor(5);
        clickOn(searctBtn);
        return PageFactory.initElements(driver, SearchResults.class);
    }
}
