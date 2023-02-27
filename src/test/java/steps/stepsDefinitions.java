package steps;

import Utils.BrowserManager;
import Utils.TestDataReader;
import Utils.envProps;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.homePage;

import java.util.*;

public class stepsDefinitions {

    private WebDriver driver;
    homePage homepage;
    String url;
    Select dropdown;
    String url2;
    String url3;
    String url4;
    HashMap<String, String> data;
    Scenario scenario;

    public stepsDefinitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario) {
        this.scenario = scenario;

    }

    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        url = envProps.getValue("url");
        driver.get(url);

    }

    @When("the user cancel the notification")
    public void theUserCancelTheNotification() {
        homepage = new homePage(driver);
        //  homepage.getRemoveNotification().click();
    }

    @And("the user select products")
    public void theUserSelectProducts() {
        homepage.getClickOnShoes().click();
    }

    @Then("Notification got canceled and open user selected products")
    public void notificationGotCanceledAndOpenUserSelectedProducts() {
        url3 = envProps.getValue("url3");
        Assert.assertEquals(driver.getCurrentUrl(), url3);
    }


    @Given("the user wants to view homepage of ajio")
    public void the_user_wants_to_view_homepage_of_ajio() {

    }

    @When("the user click on homepage button")
    public void the_user_click_on_homepage_button() {
        homepage.getAjioHomepage().click();

    }

    @Then("the current page redirected to home page")
    public void the_current_page_redirected_to_home_page() {
        url3 = envProps.getValue("url");
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Given("the user filter options by selecting relevance")
    public void theUserFilterOptionsBySelectingRelevance() {
        dropdown = new Select(homepage.getDropdown());
        dropdown.selectByIndex(2);
        data = TestDataReader.getData(scenario.getName());

    }

    @When("the user select discount option to view products")
    public void theUserSelectDiscountOptionToViewProducts() {
        dropdown.selectByIndex(2);

    }

    @Then("the product results should be displayed according to discount")
    public void theProductResultsShouldBeDisplayedAccordingToDiscount() {
        List<WebElement> sortBy = homepage.getSortBy();
        List<String> sortString = Arrays.asList(data.get("value"));
        for (int i = 1; i < sortBy.size(); i++) {
            Assert.assertEquals(sortBy.get(i).getText(), sortString.get(i - 1));
        }
    }

    @Given("the user search for products by enter their names")
    public void the_user_search_for_products_by_enter_their_names() {
        data = TestDataReader.getData(scenario.getName());
        System.out.println(data.get("value"));

    }

    @When("the user enter names of the products for {string}")
    public void theUserEnterNamesOfTheProductsFor(String arg0) {
        homepage.getSearch().sendKeys(arg0);
        homepage.getSearch().sendKeys(Keys.ENTER);
    }
    @Then("the search items should be displayed as item as {string}")
    public void theSearchItemsShouldBeDisplayedAsItemAs(String arg0) {
        String searchText = homepage.getGetSearchText().getText();
        Assert.assertEquals(searchText,arg0);
    }

    @Given("the user select men's clothing page")
    public void the_user_select_men_s_clothing_page() {

    }

    @When("the user click on the men's clothing page")
    public void the_user_click_on_the_men_s_clothing_page() {
        homepage.getMen_cloths().click();

    }

    @Then("the home page should redirected to men's clothing page")
    public void the_home_page_should_redirected_to_men_s_clothing_page() {
        url4 = envProps.getValue("url4");
        Assert.assertEquals(driver.getCurrentUrl(),url4);

    }


    @Given("the user select hand bags")
    public void theUserSelectHandBags() {
        url = envProps.getValue("url");
        driver.get(url);

    }

    @When("the user click on the hand bags")
    public void theUserClickOnTheHandBags() {
        homepage.getBags().click();

    }
    @And("sorted by using relevance")
    public void sortedByUsingRelevance() {
        dropdown = new Select(homepage.getDropdown());
        dropdown.selectByIndex(2);
        data = TestDataReader.getData(scenario.getName());
    }


    @Then("the home page should redirected to hand bags page")
    public void theHomePageShouldRedirectedToHandBagsPage() {
        url2 = envProps.getValue("url2");
        Assert.assertEquals(driver.getCurrentUrl(),url2);
    }


    @Given("the user search for products by enter item names")
    public void theUserSearchForProductsByEnterItemNames() {

    }

    @When("the user search for a specific product")
    public void theUserSearchForASpecificProduct() {
        data = TestDataReader.getData(scenario.getName());
        homepage.getSearch().sendKeys(data.get("Value"));
        homepage.getSearch().sendKeys(Keys.ENTER);

    }

    @Then("the required items should be shown")
    public void theRequiredItemsShouldBeShown() {
        String searchText = homepage.getGetSearchText().getText();
        Assert.assertEquals(searchText,data.get("Assertion values"));
    }

    @Given("the user select a product")
    public void the_user_select_a_product() {
//        data = TestDataReader.getData(scenario.getName());
//        System.out.println(data.get("value"));


    }

    @When("the user selected product results will shown in new window")
    public void the_user_selected_product_results_will_shown_in_new_window() {
        homepage.getProduct().click();

    }

    @Then("the product result open in new window")
    public void the_product_result_open_in_new_window() {
        Set<String> windowset = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowset);
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());
     driver.get(url);
        url = envProps.getValue("url");
        Assert.assertEquals(driver.getCurrentUrl(), url);


    }

}














