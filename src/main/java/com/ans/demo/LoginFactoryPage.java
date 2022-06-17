package com.ans.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestApp;

import java.util.concurrent.TimeUnit;

public class LoginFactoryPage {

    @FindBy(xpath = "//*[@name='email']") private WebElement emailID;
    @FindBy(xpath = "//*[@name='password']") private WebElement password;
    @FindBy(xpath = "//*[text()='Remember Me']") private WebElement rchb;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']") private WebElement loginBtn;

    public LoginFactoryPage setEmail(String email) {
       //. TestApp.getInstance().waitForElement((By) emailID, 20);
        emailID.sendKeys(email);
        return this;
    }

    public LoginFactoryPage setPassword(String pwd){
        password.sendKeys(pwd);
        return this;
    }

    public LoginFactoryPage setRememberChb(){

        rchb.click();
        return this;
    }
    public LoginSuccessFactoryPage Submit() {

        loginBtn.click();
         return PageFactory.initElements(TestApp.getInstance().getDriver(), LoginSuccessFactoryPage.class);
    }

}
