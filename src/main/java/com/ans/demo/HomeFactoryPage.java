package com.ans.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.TestApp;

public class HomeFactoryPage {

    @FindBy(linkText = "Signup") private WebElement registerMenuElement;
    @FindBy(linkText ="Login") private  WebElement loginMenuElement;
    @FindBy(xpath = "//div[@class='header-right-action pt-1 pe-2 multi_language']//button[@id='languages']") private WebElement LangSelection;
    //@FindBy(xpath="//div[@class='main-menu-content']//a[contains(text(),'flights')]") private WebElement flightSearchMenuElement;

    public RegisterFactoryPage clickOnRegisterLink() {
        TestApp.getInstance().waitForElement(By.linkText("Signup"), 30);
        registerMenuElement.click();
        //return new RegisterFactoryPage();
        return PageFactory.initElements(TestApp.getInstance().getDriver(), RegisterFactoryPage.class);
    }

    public LoginFactoryPage clickOnLoginLink(){
        TestApp.getInstance().waitForElement((By.linkText("Login")),30);
        loginMenuElement.click();
        return PageFactory.initElements(TestApp.getInstance().getDriver(), LoginFactoryPage.class);
    }


    public FlightSearchFactoryPage clickOnFlightsLink()  {
        TestApp.getInstance().waitForElement(By.xpath("//div[@class='header-right-action pt-1 pe-2 multi_language']//button[@id='languages']"),20);
        LangSelection.click();

        return PageFactory.initElements(TestApp.getInstance().getDriver(), FlightSearchFactoryPage.class);
    }

    }
