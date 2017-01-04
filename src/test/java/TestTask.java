import baseTest.BasicTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.ElecronicPage;
import pages.MainPage;
import pages.SearchPage;
import pages.SearchResults;

public class TestTask extends BasicTest {
    private MainPage mainPage = PageFactory.initElements(getDriver(), MainPage.class);
    private ElecronicPage elecronicPage;
    private SearchPage searchPage;
    private SearchResults searchResults;

    @Test
    public void testTask(){
        mainPage.open();
        elecronicPage = mainPage.openCangeLanguageAndOpenElectronic();
        searchPage = elecronicPage.openSearchPage();
        searchResults = searchPage.findNeededProduct("Компьютер");
        searchResults.customView();
        searchPage = searchResults.openAdvancadSearch();
        searchResults = searchPage.advancedSearch("Компьютер");

    }
}
