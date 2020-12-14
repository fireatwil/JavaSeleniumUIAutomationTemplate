package pages;

import maps.HomeMap;
import support.BaseCommands;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePage {

    HomeMap homeMap = new HomeMap();
    BaseCommands baseCommands = new BaseCommands();

    public void assertBrowserTitle() {
        baseCommands.assertBrowserTitle("Demo Site");
    }

    public void clickOnSearchBox() {
        baseCommands.clickOnElement(homeMap.SEARCH_TEXT_BOX);
    }

    public void enterSearchCriteriaToSearchBox(String searchKey) {
        clickOnSearchBox();
        baseCommands.clearAndEnterText(homeMap.SEARCH_TEXT_BOX, searchKey);
    }

    public void clickOnSearchSubmitButton() {
        baseCommands.clickOnElement(homeMap.SEARCH_QUERY_SUBMIT);
    }

    public boolean isSearchResultsDisplayed(String searchKey) {
        return baseCommands.isElementDisplayed(searchKey);
    }

    public String getSearchResult(String searchKey) {
        return baseCommands.getElementText(searchKey);
    }

    public void assertSearchResult(String searchKey, String expectedSearchItem) {
        assertEquals(getSearchResult(searchKey), expectedSearchItem);
    }

    public List<String> getSearchResults(String searchKey) {
        return baseCommands.getElementsText(searchKey);
    }

    public void clickOnSearchResultItem(String itemName) {
        baseCommands.clickOnElement(itemName);
    }

    public int numberOfElements(String searchKey) {
        return baseCommands.numberOfElements(searchKey);
    }

    public void assertNumberOfSearchResults(String searchKey, int expectedSearchResultNumbers) {
        assertEquals(numberOfElements(searchKey), expectedSearchResultNumbers);
    }
}