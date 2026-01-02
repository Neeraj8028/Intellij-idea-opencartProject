package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC004_SearchPageTest extends BaseClass {

    @Test(priority = 1, groups = "Master")
    public void ValidateSearchProduct() {
        HomePage HP = new HomePage(driver); // now driver will not be null
        HP.clickMyAccount();
        HP.clickLogin();

        SearchProductPage searchProduct;
        searchProduct = new SearchProductPage(driver);

        searchProduct.SearchProduct("Product 8");
    }
    @Test(priority = 2, groups = "Master")
    public void validateSearchResultText() throws InterruptedException {
//		HomePage hp;
//   	 	hp = new HomePage(driver); // now driver will not be null
//        hp.ClickMyAccount();
//        hp.ClickLogin();

        SearchProductPage searchProduct;
        searchProduct = new SearchProductPage(driver);

        String searchResText = searchProduct.SearchResultText();
        System.out.println(searchResText);

        Assert.assertEquals(searchResText, "Search - Product 8");
    }
    //
    @Test(priority = 3, groups = "Master")
    public void validateProductAddtionMessage() {
//		HomePage hp;
//   	 	hp = new HomePage(driver); // now driver will not be null
//        hp.ClickMyAccount();
//        hp.ClickLogin();
//
        SearchProductPage searchProduct;
        searchProduct = new SearchProductPage(driver);

        Assert.assertTrue(searchProduct.ProductAddtionMessage());
    }
}
