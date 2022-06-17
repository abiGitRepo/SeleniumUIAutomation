package com.ans.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestApp;

import java.util.ArrayList;
import java.util.List;

public class FlightSearchFactoryPage {

    @FindBy(xpath = "//span[@class='flag-icon flag-icon-us mr-1']") private WebElement languages;
    @FindBy(xpath="//div[@class='main-menu-content']//a[contains(text(),'flights')]") private WebElement flightSearchMenuElement;
    @FindBy(xpath = "//div[@class='row mb-3 g-1']//select[@id='flight_type']") private WebElement flightType ;

    @FindBy(xpath = "//div[@class='col-md-4 flight_types']//input[@id='one-way']") private WebElement tripTypeOneWay ;
    @FindBy(xpath = "//div[@class='col-md-4 flight_types']//input[@id='round-trip']") private WebElement tripTypeRoundTrip ;
    @FindBy(xpath = "//div[@class='autocomplete-wrapper _1 row_1']//input[@name='from']") private WebElement fromCity;
    @FindBy(xpath = "//div[@class='autocomplete-wrapper _1 row_2']//input[@name='to']") private WebElement toCity;

    @FindBy(xpath = "//*[@class='depart form-control dateleft border-top-r0' and @name='depart']") private WebElement roundTripDepartureDate;
    @FindBy(xpath = "//*[@class='returning form-control dateright border-top-l0' and @name='returning']") private WebElement roundTripReturnDate;
    @FindBy(xpath = "//input[@name='depart' and @class='depart form-control']") private WebElement oneWayDepartureDate;

    //String departDate
    @FindBy(xpath = "//body[1]/div[4]/div[2]/table[1]/thead[1]/tr[1]/th[2]")  private WebElement yearOneWay ;
    @FindBy(xpath = "//body[1]/div[4]/div[1]/table[1]/thead[1]/tr[1]/th[3]/i[1]")  private WebElement nextMonth ;


    @FindBy(xpath = "//div[@class='row g-0']//input[@id='return']") private WebElement returnDate;
    @FindBy(xpath = "//div[@class='col-lg-1 pr-0']//div/div/div/a[1]") private WebElement passengers;
    @FindBy(xpath = "//div[@class='dropdown-item']//input[@id='fadults']//following::div[1]") private WebElement increaseAdultsCount;
    @FindBy(xpath = "//div[@class='col-lg-1 pr-0']//input[@id='fadults']//preceding::div[@class='qtyDec']") private WebElement decreaseAdultsCount;
    @FindBy(xpath = "//div[@class='col-lg-1 pr-0']//input[@id='fchilds']//following::div[1]") private WebElement increaseChildCount;
    @FindBy(xpath = "//div[@class='col-lg-1 pr-0']//input[@id='fchilds']//preceding::dv[1]") private WebElement decreaseChildCount;
    @FindBy(xpath = "//div[@class='col-lg-1 pr-0']//input[@id='finfant']//following::div[1]") private WebElement increaseInfantCount;
    @FindBy(xpath = "//div[@class='col-lg-1 pr-0']//input[@id='finfant']//preceding::div[1]") private WebElement decreaseInfantCount;
    @FindBy(xpath = "//div[@class='btn-search text-center']//button[@id='flights-search']") private WebElement searchButton;

    @FindBy(xpath="//div[@class='col-md-9']/section/ul") private WebElement searchResultsOneWay;
    @FindBy(xpath="//div[@class='cc-compliance text-right float-right']/button")private WebElement complianceButton;


    WebDriver driver=TestApp.getInstance().getDriver();
    JavascriptExecutor js=(JavascriptExecutor) driver;
    public FlightSearchFactoryPage setLanguage() {
        languages.click();
        flightSearchMenuElement.click();

        return this;
    }

    public  FlightSearchFactoryPage setFlightType(String fType) throws InterruptedException {

     //   TestApp.getInstance().waitForElement((By) flightType,30);
        Select flTypes = new Select(flightType);
        flTypes.selectByVisibleText(fType);
        Thread.sleep(3000);
        return this;
    }

    public FlightSearchFactoryPage setTrip(String tripType){

        boolean selectStateOneWay = tripTypeOneWay.isSelected();
        boolean selectStateRoundTrip=tripTypeRoundTrip.isSelected();

        if (  tripType.equals("OneWay") &&  selectStateOneWay==false){
                   tripTypeOneWay.click();
            }
            else if (tripType.equals("Round")){
                   tripTypeRoundTrip.click();

                }
        return this;
    }


    public  FlightSearchFactoryPage setFromLocation(String fromLocation){

       fromCity.sendKeys(fromLocation);
       TestApp.getInstance().getDriver().findElement(By.xpath("//div[@data-index='0']")).click();

        return this;
    }

    public  FlightSearchFactoryPage setToLocation(String toLocation){
        toCity.sendKeys(toLocation);
        TestApp.getInstance().getDriver().findElement(By.xpath("//div[@data-index='0']")).click();

        return this;

    }

    public  FlightSearchFactoryPage setDepartureDate(String tripType, String oneWayDepDate, String roundTripDepDate , String roundTripRetDate) {

        boolean selectStateOneWay = tripTypeOneWay.isSelected();

        if (  tripType.equals("OneWay")  ) {
            oneWayDepartureDate.click();
            oneWayDepartureDate.clear();
            oneWayDepartureDate.sendKeys(oneWayDepDate);
           }
        else if(tripType.equals("Round")){
            roundTripDepartureDate.click();
            roundTripDepartureDate.clear();
            roundTripDepartureDate.sendKeys(roundTripDepDate);

            roundTripReturnDate.click();
            roundTripReturnDate.clear();
            roundTripReturnDate.sendKeys(roundTripRetDate);

        }

        return this;

    }


    public FlightSearchFactoryPage setPassengerCount( String adultsCount,String childrenCount, String infantsCount){
        TestApp.getInstance().waitForElement(By.xpath("//div[@class='col-lg-1 pr-0']//div/div/div/a[1]"), 20);

        int adultCount=Integer.parseInt(adultsCount);
        int childCount=Integer.parseInt(childrenCount);
        int infantCount=Integer.parseInt(infantsCount);

            passengers.click();
           // System.out.println("Passengers Clicked");

        if(adultCount > 1 ) {
            for (int i = 1; i < adultCount; i++) {
                increaseAdultsCount.click();
            }
        }
        if(childCount > 0){

            for(int j=0; j < childCount; j++){
                increaseChildCount.click();
            }
        }
         if(infantCount > 0){

            for(int k=0; k < childCount; k++){
                increaseInfantCount.click();
            }
        }


        return this;
    }


    public FlightSearchFactoryPage Submit() {
        //System.out.println("Inside Submit");
        searchButton.click();
       // System.out.println("After Click ");
        return this;
   }
      //     return PageFactory.initElements(TestApp.getInstance().getDriver(), FlightSearchSuccessFactoryPage.class);

   public FlightSearchFactoryPage ChooseTheFlight(String fName) throws InterruptedException {

       WebDriverWait wait = new WebDriverWait(TestApp.getInstance().getDriver(), 30);
       wait.until(ExpectedConditions.visibilityOf(complianceButton));
       complianceButton.click();

       wait.until(ExpectedConditions.visibilityOf(searchResultsOneWay));
       System.out.println("Inside the CheckDesiredFlightOneWay");

       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@href='#searchResultsItem-0']"))));

       String[] NameOfTheFlights=new String[7];
       WebElement SearchResultItem;
       WebElement FlightName;

       for(int i=0; i<=7; i++){

           SearchResultItem = driver.findElement(By.xpath("//div[@href='#searchResultsItem-"+i+"']"));
           SearchResultItem.click();
           System.out.println("Search Result Item "+i);
           Thread.sleep(2000);

           String path="//*[@id='searchResultsItem-"+i+"']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li";
           FlightName =  driver.findElement(By.xpath(path));

           NameOfTheFlights[i]=FlightName.getText();
           System.out.println("Flight Name "+i);

           System.out.println( "On the Flight "+NameOfTheFlights[i]);

           SearchResultItem.click();
           Thread.sleep(2000);

           if(NameOfTheFlights[i].equals(fName)){
               //*[@id="data"]/ul/li[5]/div/form/div/div[2]/div/button
               WebElement reserveButton =driver.findElement(By.xpath("//*[@id='data']/ul/li["+i+"]/div/form/div/div[2]/div/button"));
               reserveButton.click();
               break;
           }

         //  js.executeScript("window.scrollBy(0,100)", "");
           WebElement searchResultItem2 = driver.findElement(By.xpath("//div[@href='#searchResultsItem-"+(i+1)+"']"));
           js.executeScript("arguments[0].scrollIntoView();", searchResultItem2);
           System.out.println("End of loop"+i);

       }


        return this;
    }



}
