package com.ans.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

public class RegisterSuccessFactoryPage {


     //String salutationMessageElement=prop.getProperty("config","salutation.message.signup");

    public String getSalutationMessage(){


      //  TestApp.getInstance().waitForElement(By.xpath("//*[contains(text(),'Signup Successful')]"),10);
        String message = TestApp.getInstance().getDriver().switchTo().alert().getText();
        return message;

    }
}
