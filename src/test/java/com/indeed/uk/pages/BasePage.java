package com.indeed.uk.pages;

import com.indeed.uk.utilities.BrowserUtils;
import com.indeed.uk.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage() { //Constructor oluşturduk, this:in order to call current class' instance(örnek) of object
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "text-input-what")
    public WebElement whatBox;

    @FindBy(id = "text-input-where")
    public WebElement whereBox;

    @FindBy(xpath = "//button[@class='yosegi-InlineWhatWhere-primaryButton']")
    public WebElement findJobsButton;

    @FindBy(xpath = "//div[@id='searchCountPages']")
    public WebElement numberOfJobs;

    @FindBy(xpath = "//button[@id='filter-radius']")
    public WebElement radiusButton;


    @FindBy(xpath = "//ul[@id='filter-radius-menu']//a")
    public List<WebElement> radiusList;


    //Day 3 Locators

    @FindBy(xpath = "//button[@class='icl-CloseButton icl-Card-close']")
    public WebElement signInWithGoogleCloseButton;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//button[@aria-label='close promo banner']")
    public WebElement ukraine;

    //button[@class='popover-x-button-close icl-CloseButton']  (old xpath)
    @FindBy(xpath = "//*[@id=\"popover-x\"]/button") // new xpath
    public WebElement sendEmailCloseBox;



    public WebElement getRadiusFilter(int radius) {

        System.out.println(radius);

        switch (radius) {
            case 0:
                return radiusList.get(0);
            case 5:
                return radiusList.get(1);
            case 10:
                return radiusList.get(2);
            case 15:
                return radiusList.get(3);
            case 25:
                return radiusList.get(4);
            case 50:
                return radiusList.get(5);
            case 100:
                return radiusList.get(6);
            default:
                System.out.println("wrong radius");
                return null;
        }
    }

    public void closeWindows() {


        if (BrowserUtils.webElementExists(acceptAllCookiesButton)) {
            acceptAllCookiesButton.click();
        }

        if (BrowserUtils.webElementExists(ukraine)) {
            ukraine.click();
        }
        if (BrowserUtils.webElementExists(signInWithGoogleCloseButton)) {
            signInWithGoogleCloseButton.click();
        }
    }

    public void closeEmailWindow() {
        BrowserUtils.waitFor(10);
        if (BrowserUtils.webElementExists(sendEmailCloseBox)) {
            BrowserUtils.waitForClickablility(sendEmailCloseBox,5);
            sendEmailCloseBox.click();
        }
    }


}
