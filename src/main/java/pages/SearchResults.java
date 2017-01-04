package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;


public class SearchResults extends Page {

    private String title = "SS.lv Электротехника. Результат поиска";
    private String titleWithFilter = "SS.lv Электротехника. Результат поиска, Продают. Цена";

    @FindBy(linkText = "Расширенный поиск")
    private WebElement advancedSearch;

    @FindBy(linkText = "Цена")
    private WebElement price;

    @FindBy(xpath = "//*[@id=\"page_main\"]/tbody/tr/td/div[2]/span[3]/select")
    private WebElement selectFilter;

    private String selectOnly = "Продажа";

    public SearchResults customView(){
        clickOn(price);
        selectFromDropDown(selectFilter, selectOnly);
        return PageFactory.initElements(driver, SearchResults.class);
    }

    public SearchPage openAdvancadSearch(){
        assertEquals(titleWithFilter, getTitle());
        clickOn(advancedSearch);
        return PageFactory.initElements(driver, SearchPage.class);
    }

    public SearchResults(WebDriver driver) {
        super(driver);
    }
}
