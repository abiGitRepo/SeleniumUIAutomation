package com.ans.demo.demo;

import com.ans.demo.FlightSearchFactoryPage;
import com.ans.demo.FlightSearchSuccessFactoryPage;
import com.ans.demo.HomeFactoryPage;
import com.ans.demo.RegisterFactoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyFileReader;
import utils.TestApp;

public class FlightSearchFactoryTest {

    HomeFactoryPage homePage=null;
    FlightSearchFactoryPage flSearchPage;
    FlightSearchSuccessFactoryPage flSearchSuccessPage;

    utils.PropertyFileReader property = new PropertyFileReader();

    String fType=property.getProperty("flightSearchProperties","fType");
    String trip=property.getProperty("flightSearchProperties","tripType");
    String from=property.getProperty("flightSearchProperties","fromLocation");
    String to=property.getProperty("flightSearchProperties","toLocation");

    String onewayDepDate=property.getProperty("flightSearchProperties","onewayDepDate");
    String roundDepDate=property.getProperty("flightSearchProperties","roundDepDate");
    String roundRetDate=property.getProperty("flightSearchProperties","roundRetDate");

    String adultCount=property.getProperty("flightSearchProperties","adultCount");
    String childCount=property.getProperty("flightSearchProperties","childCount");
    String infantCount=property.getProperty("flightSearchProperties","infantCount");
    String fName=property.getProperty("flightSearchSuccess","flightName");

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();

        homePage= PageFactory.initElements(TestApp.getInstance().getDriver(), HomeFactoryPage.class);
        flSearchPage=homePage.clickOnFlightsLink();
    }

    @Test
    public void testFlightSearch() throws InterruptedException {

        flSearchPage
                .setLanguage()
                .setFlightType(fType)
                .setTrip(trip)
                .setFromLocation(from)
                .setToLocation(to)
                .setDepartureDate(trip,onewayDepDate, roundDepDate,roundRetDate)
                .setPassengerCount(adultCount,childCount,infantCount)
                .Submit()
                .ChooseTheFlight(fName);


      //  flSearchSuccessPage= PageFactory.initElements(TestApp.getInstance().getDriver(),FlightSearchSuccessFactoryPage.class);

      //  flSearchSuccessPage.CheckDesiredFlightOneWay(fName);

        /* Assertion for no search results
        flSearchSuccessPage=PageFactory.initElements(TestApp.getInstance().getDriver(),FlightSearchSuccessFactoryPage.class);
        Boolean displayNoSearchResults= flSearchSuccessPage.noSearchResultsErrorMessage();
        Assert.assertTrue(displayNoSearchResults,"No Search Results Found");
        */
        //to reserve a flight from Search results
      //  flSearchSuccessPage.checkForDesiredFlight(fName);
    }

   /* @Test
    public void testReserveFlight() {

        flSearchSuccessPage.checkForDesiredFlight(fName);

    }*/
}
