package com.ans.demo.demo;

import com.ans.demo.HomeFactoryPage;
import com.ans.demo.LoginSuccessFactoryPage;
import com.ans.demo.RegisterFactoryPage;
import com.ans.demo.RegisterSuccessFactoryPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyFileReader;
import utils.TestApp;

public class UserRegistrationFactoryTest {
    HomeFactoryPage homePage=null;
    RegisterFactoryPage regPage;
    RegisterSuccessFactoryPage regSuccess;
    utils.PropertyFileReader property = new PropertyFileReader();

    String fName=property.getProperty("registrationProperties", "firstName");
    String lName=property.getProperty("registrationProperties", "lastName");
    String phone=property.getProperty("registrationProperties", "phoneNo");
    String email=property.getProperty("registrationProperties", "signUpEmailID");
    String password=property.getProperty("registrationProperties", "signUpPassword");
    String accType=property.getProperty("registrationProperties", "accType");

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();

        homePage=PageFactory.initElements(TestApp.getInstance().getDriver(), HomeFactoryPage.class);
        regPage=homePage.clickOnRegisterLink();
    }

    @Test
    public void testSignup() throws InterruptedException {

        regPage.setFirstName(fName)
                .setLastName(lName)
                .setPhone(phone)
                .setEmail(email)
                .setPassword(password)
                .setType(accType)
                .Submit();


        regSuccess= PageFactory.initElements(TestApp.getInstance().getDriver(), RegisterSuccessFactoryPage.class);

       /*String actualMessage=regSuccess.getSalutationMessage();
        Assert.assertEquals(actualMessage,"Hi, "+property.getProperty("config","loginFirstName")+" Welcome Back");
*/

    }


}
