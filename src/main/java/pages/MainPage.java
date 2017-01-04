package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;


public class MainPage extends Page{

    private String title = "Объявления - SS.LV";

    @FindBy(linkText = "RU")
    public WebElement russianLanguage;

    @FindBy(linkText = "Электротехника")
    public WebElement electro;

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public ElecronicPage openCangeLanguageAndOpenElectronic(){
        open();
        clickOn(russianLanguage);
        assertEquals(title, getTitle());
        clickOn(electro);
        return PageFactory.initElements(driver, ElecronicPage.class);
    }


}
