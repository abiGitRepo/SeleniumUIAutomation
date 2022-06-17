package com.ans.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.TestApp;

public class RegisterFactoryPage {
    //@FindBy(name = "first_name") private WebElement first_name;
    @FindBy(xpath="//input[@name='first_name']") private WebElement first_name;
    @FindBy(xpath="//input[@name='last_name']") private WebElement last_name;
    @FindBy(xpath="//input[@name='phone']") private WebElement phone;
    @FindBy(xpath="//input[@name='email']") private WebElement email;
    @FindBy(xpath="//*[@name='password']") private WebElement password;
    @FindBy(xpath="//*[@id='account_type']") private WebElement type;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']") private WebElement signUpBtn;

    public RegisterFactoryPage setFirstName(String fName){
        TestApp.getInstance().waitForElement(By.xpath("//input[@name='first_name']"),30);
        first_name.sendKeys(fName);
        return this;
    }

    public  RegisterFactoryPage setLastName(String lName){
        last_name.sendKeys(lName);
        return this;
    }

    public  RegisterFactoryPage setPhone(String phoneNum){
        phone.sendKeys(phoneNum);
        return this;
    }

    public  RegisterFactoryPage setEmail(String emailID){
        email.sendKeys(emailID);
        return this;
    }

    public  RegisterFactoryPage setPassword(String pwd){
        password.sendKeys(pwd);
        return this;
    }

    public  RegisterFactoryPage setType(String accType) throws InterruptedException {

        Select acTypes = new Select(type);
        acTypes.selectByVisibleText(accType);
        Thread.sleep(2000);
        return this;
    }

    public RegisterSuccessFactoryPage Submit() {
        signUpBtn.submit();
        return PageFactory.initElements(TestApp.getInstance().getDriver(), RegisterSuccessFactoryPage.class);

    }


}
