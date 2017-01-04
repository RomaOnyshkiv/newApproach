package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigProperties;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }


    protected void enterText(WebElement element, String text) {
       element.clear();
       element.sendKeys(text);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOn(WebElement element){
        element.click();
    }

    public String getTitle() {
        String currentTitle = driver.getTitle();
        System.out.println("[INFO] - the page " + currentTitle + " is loaded");
        return currentTitle;
    }


    public void open(){
        driver.get(ConfigProperties.getPropeties("URL"));
    }

    public void selectFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void sleepFor(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
