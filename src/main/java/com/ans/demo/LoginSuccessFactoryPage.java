package com.ans.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestApp;

public class LoginSuccessFactoryPage {

    WebDriver driver= TestApp.getInstance().getDriver();

    @FindBy(xpath = "//*[contains(text(),'Hi')]") private WebElement loginSuccessMessage;
    @FindBy(xpath="//div[@class='alert alert-danger failed']") private WebElement loginFailureMessage;
    public String getSalutationMessage(){


        String message = loginSuccessMessage.getText();
        return message;

    }

    public String getLoginErrorMessage(){
      //  TestApp.getInstance().waitForElement(loginFailureMessage, 20);

        WebDriverWait wb=new WebDriverWait(TestApp.getInstance().getDriver(), 20);
        WebElement errorMessage;
        errorMessage=  wb.until(ExpectedConditions.visibilityOf(loginFailureMessage));
        String message=loginFailureMessage.getText();
        return message;
    }




    private WebElement waitUntilNextElement(By locator, int timeOut, WebDriver driver ){
        WebElement element=new WebDriverWait(driver,timeOut).until(
                ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

}
