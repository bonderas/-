package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testExistWordSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        String search_word = SearchPageObject.getTitleSearch();
        assertEquals(
                "В строке поиска в Вики , нет слова Search",
                "Search…",
                search_word
        );

    }

    @Test
    public void testSearchResulsDisabled() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Ford");
        SearchPageObject.waitForSearchResult("Car model");
        SearchPageObject.waitForSearchResult("Automotive brand manufacturer");
        SearchPageObject.waitForCancelButtonToAppiear();
        SearchPageObject.clickCancelSearch();

    }

}
