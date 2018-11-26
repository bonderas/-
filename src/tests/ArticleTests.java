package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObjects;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase
{
    @Test
    public void testSaveTwoArticlesToMyList() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Ford");
        String title_article_1 = "Ford Motor Company";
        String title_article_2 = "Ford F-Series";
        String Folder = "Bla-Bla";
        SearchPageObject.clickByArticleWithSubstring(title_article_1);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.addArticleInMyList(Folder);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.clickHistResultSearchSubstring("Ford");
        SearchPageObject.clickByArticleWithSubstring(title_article_2);
        ArticlePageObject.clickButtonAddArticleInMyList();

        MyListsPageObjects MyListsPageObjects = new MyListsPageObjects(driver);
        MyListsPageObjects.clickByFolderWithSubstring(Folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickButtonMyLists();
        MyListsPageObjects.clickByFolderWithSubstring(Folder);

        MyListsPageObjects.swipeByArticleToDelete(title_article_1);
        SearchPageObject.clickByArticleWithSubstring(title_article_2);
        String title_articlebox_2 = ArticlePageObject.getArticleTitle();
        assertTrue("Заголовок статьи номер 2 не совпадает с изначальным", title_articlebox_2.contains(title_article_2));
    }




    @Test
    public void testSearchTitleInArticle() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Ford");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        SearchPageObject.clickByArticleWithSubstring("Ford Motor Company");
        String get_title_for_check =  ArticlePageObject.getArticleTitle();
        ArticlePageObject.existTitleInArticle();

    }
}
