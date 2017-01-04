package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;


public class ElecronicPage extends Page {

    private String title = "SS.lv Электротехника - Объявления";

    @FindBy(linkText = "Поиск")
    private WebElement searchTab;

    public SearchPage openSearchPage(){
        assertEquals(title, getTitle());
        clickOn(searchTab);
        return PageFactory.initElements(driver, SearchPage.class);
    }

    public ElecronicPage(WebDriver driver){
        super(driver);
    }

}
