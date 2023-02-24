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

public class stepsDefenitions {

    private WebDriver driver;
    homePage homepage;
    String url;
    Point point;
    Select dropdown;
    String url2;
    String url3;
    String search;
    HashMap<String,String> data;
    Scenario scenario;


    public stepsDefenitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }
    @Before(order = 1)
    public void before(Scenario scenario){
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
        Assert.assertEquals(driver.getCurrentUrl(),url3);
    }




    @Given("the user filter options by selecting grid options")
    public void the_user_filter_options_by_selecting_grid_options() {
        data = TestDataReader.getData(scenario.getName());
        System.out.println(data.get("value"));


    }

    @When("the user select five-grid option to view products")
    public void the_user_select_five_grid_option_to_view_products() {
        homepage.getGrid().click();

    }

    @Then("the product results should be displayed in five-grid mode")
    public void the_product_results_should_be_displayed_in_five_grid_mode() {
        point = homepage.getGridLocation().getLocation();
        Assert.assertEquals(point.getX(), 804);
        Assert.assertEquals(point.getY(), 241);


    }

    @Given("the user wants to view homepage of ajio")
    public void the_user_wants_to_view_homepage_of_ajio() {
//        data = TestDataReader.getData(scenario.getName());
//        System.out.println(data.get("value"));


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

    @Given("the user select a product")
    public void the_user_select_a_product() {
        data = TestDataReader.getData(scenario.getName());
        System.out.println(data.get("value"));


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
        url2 = envProps.getValue("url2");
        Assert.assertEquals(driver.getCurrentUrl(),url2);


    }
    @Given("the user search for products by enter their names")
    public void the_user_search_for_products_by_enter_their_names() {
        data = TestDataReader.getData(scenario.getName());
        System.out.println(data.get("value"));



    }
    @When("the user enter names of the products for {string}")
    public void the_user_enter_names_of_the_products_for(String item) {
        homepage.getSearch().sendKeys(item);
        homepage.getSearch().sendKeys(Keys.ENTER);
    }
   @And("the user select five-grid option to view selected products")
    public void theUserSelectFiveGridOptionToViewSelectedProducts() {
        homepage.getFivegridOption().click();


    }
    @Then("the search items should be displayed")
    public void the_search_items_should_be_displayed() {
        point = homepage.getGridLocation().getLocation();
        Assert.assertEquals(point.getX(), 804);
        Assert.assertEquals(point.getY(), 241);

//        System.out.println(point.getX());
//        System.out.println(point.getY());





    }



}


//    @Given("the user filter options by selecting boys")
//    public void theUserFilterOptionsBySelectingBoys() {
//        data = TestDataReader.getData(scenario.getName());
//        System.out.println(data.get("value"));
//
//    }
//
//    @When("the user select boys as an option for filter the products")
//    public void the_user_select_boys_as_an_option_for_filter_the_products() {
//        homepage.getGender().click();
//
//    }
//
//    @Then("the product results should be displayed which is belongs to boys")
//    public void the_product_results_should_be_displayed_which_is_belongs_to_boys() {
//        String text = homepage.getGender().getText();
//        Assert.assertEquals(text, data.get("Assertion values"));
//
//    }


//data.get("name")
//    @Given("the user filter options by selecting sports shoes")
//    public void the_user_filter_options_by_selecting_sports_shoes() {
//
//    }
//
//    @When("the user select sports shoes as an option to filter the products")
//    public void the_user_select_sports_shoes_as_an_option_to_filter_the_products() {
//        homepage.getCategory().click();
//    }
//
//    @Then("the product results should be displayed which is belongs to sports shoes")
//    public void the_product_results_should_be_displayed_which_is_belongs_to_sports_shoes() {
//        String name = homepage.getCategoryText().getText();
//        Assert.assertEquals(name, "Sports Shoes (360)");
//
//    }
//
//    @Given("the user filter options by selecting price")
//    public void the_user_filter_options_by_selecting_price() {
//        homepage.getPrice().click();
//
//    }
//
//    @When("the user select price Rs.{int}-{int} \\({int}) as an option to filter the products")
//    public void the_user_select_price_rs_as_an_option_to_filter_the_products(Integer int1, Integer int2, Integer int3) {
//        homepage.getSelectPrice().click();
//
//    }
//
//    @Then("the product results should be displayed which is belongs to user selected price")
//    public void the_product_results_should_be_displayed_which_is_belongs_to_user_selected_price() {
//        String price = homepage.getGetPriceText().getText();
//        Assert.assertEquals(price, "Rs.2001-2500 (114)");
//
//    }
//

