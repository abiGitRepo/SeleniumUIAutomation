package com.ans.demo.demo;

import com.ans.demo.HomeFactoryPage;
import com.ans.demo.LoginFactoryPage;
import com.ans.demo.LoginSuccessFactoryPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ReporterConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyFileReader;
import utils.TestApp;

public class UserLoginFactoryTest {
    HomeFactoryPage homePage=null;
    LoginFactoryPage lgnPage;
    LoginSuccessFactoryPage loginSuccessPage;
    utils.PropertyFileReader property = new PropertyFileReader();

    String fName=property.getProperty("loginProperties","loginFirstName");
    String email=property.getProperty("loginProperties","signUpEmailID");
    String password=property.getProperty("loginProperties","signUpPassword");

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();

        homePage= PageFactory.initElements(TestApp.getInstance().getDriver(), HomeFactoryPage.class);
        lgnPage=homePage.clickOnLoginLink();


    }

    @Test
    public void testLogin() throws InterruptedException {
        lgnPage.setEmail(email)
                .setPassword(password)
                .setRememberChb()
                .Submit();


        loginSuccessPage= PageFactory.initElements(TestApp.getInstance().getDriver(), LoginSuccessFactoryPage.class);

        //For a Successful login Scenario
      //  String actualMessage=loginSuccessPage.getSalutationMessage();
      //  Assert.assertEquals(actualMessage,"Hi, "+fName+" Welcome Back");

        //When logged in with an incorrect credentials
        String actualErrorMessage=loginSuccessPage.getLoginErrorMessage();
        Assert.assertEquals(actualErrorMessage,"Wrong credentials. try again!");



    }
}
