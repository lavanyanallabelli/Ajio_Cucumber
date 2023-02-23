package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.util.Arrays;
import java.util.List;

public class homePage {
    private WebDriver driver;


    public homePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"ic-close-quickview\"]")
    @Getter
    WebElement RemoveNotification;

    @FindBy(xpath = "//a[@href=\"/s/up-to-60-percent-off-4957-63331\"]")
    @Getter
    WebElement ClickOnShoes;

    @FindBy(xpath = "//div[@class=\"facet-linkhead\"]")
    @Getter
    WebElement Gender;


    @FindBy(xpath = "//div[@class=\"five-grid\"]")
    @Getter
    WebElement Grid;

    @FindBy(xpath = "//div[@class=\"five-grid\"]")
    @Getter
    WebElement gridLocation;

    @FindBy(xpath = "//li[@class=\"breadcrumb-list\"]")
    @Getter
    WebElement ajioHomepage;

    @FindBy(tagName = "Select")
    @Getter
    WebElement dropdown;


    @FindBy(tagName = "Select")
    @Getter
    List<WebElement> sortBy;


    @FindBy(xpath = "(//div[@class=\"preview\"])[2]")
    @Getter
    WebElement product;

    @FindBy(xpath = "//input[@name=\"searchVal\"]")
    @Getter
    WebElement Search;

    @FindBy(xpath = "//div[@class=\"five-grid-container \"]")
    @Getter
    WebElement FivegridOption;

    @FindBy(xpath = "//div[@class=\"header2\"]")
    @Getter
    WebElement searchText;

}
//    @FindBy(xpath = "(//div[@class=\"facet-linkfref \"])[6]")
//    @Getter
//    WebElement category;
//
//    @FindBy(xpath = "//label[@for=\"Women - Sports Shoes\"]")
//    @Getter
//    WebElement categoryText;
//
//    @FindBy(xpath = "//div[@class=\"facet-head \"]")
//    @Getter
//    WebElement price;
//
//    @FindBy(xpath = "(//div[@class=\"facet-linkfref \"])[13]")
//    @Getter
//    WebElement selectPrice;
//
//    @FindBy(xpath = "//label[@for=\"Rs.2001-2500\"]")
//    @Getter
//    WebElement getPriceText;

