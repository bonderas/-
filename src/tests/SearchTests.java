package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testExistWordSearch()
    {
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

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
        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Ford");
        SearchPageObject.waitForSearchResult("Car model");
        SearchPageObject.waitForSearchResult("Automotive brand manufacturer");
        SearchPageObject.waitForCancelButtonToAppiear();
        SearchPageObject.clickCancelSearch();

    }

}
