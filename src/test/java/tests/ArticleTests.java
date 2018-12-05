package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectsFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase
{
    private final static
    String search_query = "Ford";
    String title_article_1 = "Ford Motor Company";
    String title_article_2 = "Ford F-Series";
    String Folder = "Bla-Bla";
    String login = "bonderas2018";
    String password = "123654789";


    @Test
    public void testSaveTwoArticlesToMyList() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        MyListsPageObjects MyListsPageObjects = MyListsPageObjectsFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);



        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_query);


        if (Platform.getInstance().isAndroid()) {
            SearchPageObject.clickByArticleWithSubstring(title_article_1);
            ArticlePageObject.addArticleInMyList(Folder);
            ArticlePageObject.closeArticle();
            SearchPageObject.initSearchInput();
            SearchPageObject.clickHistResultSearchSubstring(search_query);
            SearchPageObject.clickByArticleWithSubstring(title_article_2);
            ArticlePageObject.clickButtonAddArticleInMyList();
            MyListsPageObjects.clickByFolderWithSubstring(Folder);
            ArticlePageObject.closeArticle();
            NavigationUI.clickButtonMyLists();
            MyListsPageObjects.clickByFolderWithSubstring(Folder);
            MyListsPageObjects.swipeByArticleToDelete(title_article_1);
            SearchPageObject.clickByArticleWithSubstring(title_article_2);
            String title_articlebox_2 = ArticlePageObject.getArticleTitle();
            assertTrue("Заголовок статьи номер 2 не совпадает с изначальным", title_articlebox_2.contains(title_article_2));
        } else if (Platform.getInstance().isIOS()) {
            SearchPageObject.clickByArticle_1();
            ArticlePageObject.addArticleInMyiOSList();
            ArticlePageObject.closePlacesAuthClose();
            ArticlePageObject.closeArticle();
            SearchPageObject.initSearchInput();
            SearchPageObject.clickByArticle_2();
            ArticlePageObject.addArticleInMyiOSList();
            ArticlePageObject.closePlacesAuthClose();
            ArticlePageObject.closeArticle();
            NavigationUI.clickButtonMyLists();
            MyListsPageObjects.swipeByArticleToDelete(title_article_1);
            ArticlePageObject.existingArticleByLabel(title_article_2);
        } else {
            SearchPageObject.clickByArticleWithSubstring(title_article_1);
            String Zaderzka_1 = ArticlePageObject.getArticleTitle();
            ArticlePageObject.addArticleToMyList();
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submithForm();
            ArticlePageObject.waitForTitleElement();
            assertEquals("мы не на той же странице после логона",
                    title_article_1,
                    ArticlePageObject.getArticleTitle());
            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine(search_query);
            SearchPageObject.clickByArticleWithSubstring(title_article_2);
            String Zaderzka_2 = ArticlePageObject.getArticleTitle();
            String Zaderzka_3 = ArticlePageObject.getArticleTitle();
            String Zaderzka_4 = ArticlePageObject.getArticleTitle();
            ArticlePageObject.addArticleToMyList();
            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();
            MyListsPageObjects.clickForArticleSavedByTitle(title_article_2);
            ArticlePageObject.remoteArticleToMyList();
            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();
            MyListsPageObjects.clickForArticleSavedByTitle(title_article_1);
            String Zaderzka_5 = ArticlePageObject.getArticleTitle();
            String Zaderzka_6 = ArticlePageObject.getArticleTitle();
            String Zaderzka_7 = ArticlePageObject.getArticleTitle();
            ArticlePageObject.existButtonDeleteArticleFromPageList();
        }













    }


    @Test
    public void testTestovich(){


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_query);
        SearchPageObject.clickByArticleWithSubstring(title_article_1);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String Zaderzka_1 = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMyList();
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);


        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
        Auth.clickAuthButton();
        Auth.enterLoginData(login, password);
        Auth.submithForm();
        ArticlePageObject.waitForTitleElement();
        assertEquals("мы не на той же странице после логона",
                title_article_1,
                ArticlePageObject.getArticleTitle());
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_query);
        SearchPageObject.clickByArticleWithSubstring(title_article_2);
        String Zaderzka_2 = ArticlePageObject.getArticleTitle();
        String Zaderzka_3 = ArticlePageObject.getArticleTitle();
        String Zaderzka_4 = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToMyList();
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();
        MyListsPageObjects MyListsPageObjects = MyListsPageObjectsFactory.get(driver);
        MyListsPageObjects.clickForArticleSavedByTitle(title_article_2);
        ArticlePageObject.remoteArticleToMyList();


        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();
        MyListsPageObjects.clickForArticleSavedByTitle(title_article_1);
        String Zaderzka_5 = ArticlePageObject.getArticleTitle();
        String Zaderzka_6 = ArticlePageObject.getArticleTitle();
        String Zaderzka_7 = ArticlePageObject.getArticleTitle();
        ArticlePageObject.existButtonDeleteArticleFromPageList();

    }





    @Test
    public void testSearchTitleInArticle()
    {

        SearchPageObject SearchPageObject =  SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Ford");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        SearchPageObject.clickByArticleWithSubstring("Ford Motor Company");
        String get_title_for_check =  ArticlePageObject.getArticleTitle();
        ArticlePageObject.existTitleInArticle();

    }

}
