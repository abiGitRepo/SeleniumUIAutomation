package com.ans.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestApp;
import org.openqa.selenium.WebElement;

import java.util.*;


public class FlightSearchSuccessFactoryPage {

    WebDriver driver=TestApp.getInstance().getDriver();
    @FindBy(xpath = "//div[@class='container text-center']") private WebElement searchResultsSection;
    @FindBy(xpath = "//div[@class='container text-center']/img[@alt='no results']") private WebElement noSearchResultsImg;
    @FindBy(xpath="//*[@id='data']/ul/li[1]/div/form/div/div[1]/div[1]/div[@href='#searchResultsItem-0']") private WebElement firstSearchResults;
    @FindBy(xpath="//*[@id='data']/ul/li[1]/div/form/div/div[1]/div[1]/div[@href='#searchResultsItem-0']/@aria-expanded") private WebElement searchResultsExpanded;
    @FindBy(xpath="//div[@class='col-md-9']/section/ul") private WebElement searchResultsOneWay;
    @FindBy(xpath="//div[@class='cc-compliance text-right float-right']/button")private WebElement complianceButton;

  //  WebDriver driver;
    // @FindBy(xpath=appi)private WebElement searchResult;



    public FlightSearchSuccessFactoryPage(WebDriver driver) {
       // this.driver = driver;
        PageFactory.initElements( driver, this);
        this.driver = driver;
    }

    // FlightSearchSuccessFactoryPage flSearchSuccessPage;


    public FlightSearchSuccessFactoryPage CheckDesiredFlightOneWay( String fName){
        WebDriverWait wait=new WebDriverWait(TestApp.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(complianceButton));
        complianceButton.click();
        //System.out.println("Driver print"+TestApp.getInstance().getDriver());

        wait.until(ExpectedConditions.visibilityOf(searchResultsOneWay));

        // flSearchSuccessPage= PageFactory.initElements(TestApp.getInstance().getDriver(),FlightSearchSuccessFactoryPage.class);

      /*  List<Object> listofSearchResults=new ArrayList<>();
        for (WebElement webElement : webElements) {
            //add each webElements label to the labelsList
            labelsList.add(webElement.getText());
        }
        for(WebElement webElement: searchResultsOneWay){
            listofSearchResults.add(webElement.findElement());
        }*/
        System.out.println("Inside the CheckDesiredFlightOneWay");
        for(int i=0; i<5; i++ ){

            String path="//*[@id='searchResultsItem-"+i+"']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li";
           // WebElement a= driver.findElement(By.xpath(path));

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path))));
           // System.out.println(path);
            WebElement FlightName=  driver.findElement(By.xpath(path));
            FlightName.click();
            String FlightName1=FlightName.getText();
            System.out.println(FlightName1 +"FlightName");

            if(FlightName.equals(fName)){

                System.out.println( "On the Flight"+FlightName);
            }


        }
        System.out.println("out of the message");
        return this;
    }

    //search Results container
    //div[@class='col-md-9']/section[@data-ref='container']
   // @FindBy(xpath = "//*[@id='searchResultsItem-0']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li") private WebElement upFlight;
  //  @FindBy(xpath = "//*[@id='searchResultsItem-0']/div/div[3]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li") private WebElement downFlight;

  //  @FindBy(xpath = "//*[@id='searchResultsItem-"+i+"']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li")  WebElement upFlight;

    //Scenario
    //choose a Srilankan Airlines flight for both up and down from the Search results and reserve
    //flight - Up


    // Flight- down
    //*[@id="searchResultsItem-0"]/div/div[3]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li

    //no of search results per page
    //[@id="data"]/div/div[2] => get text

    //to get the next page
    ////div[@class='controls-pagination']/div/button[contains(text(),'»')]



    //Constructor, as every page needs a Webdriver to find elements
////*[@id="data"]/ul/li[1]/div/form/div/div[1]/div[1]/div[1]
    //*[@id="data"]/ul/li[1]/div/form/div/div[1]/div[1]/div[1]
/*
    public FlightSearchSuccessFactoryPage checkForDesiredFlight(String fName) {

//*[@id="data"]/ul/li[1]/div/form/div/div[1]/div[1]/div[@href='#searchResultsItem-0']

        WebDriverWait wb=new WebDriverWait(TestApp.getInstance().getDriver(), 30);

        WebElement errorMessage;
        errorMessage=  wb.until(ExpectedConditions.visibilityOf(firstSearchResults));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstSearchResults).click().perform();

      //  WebElement a=searchResultsExpanded;
        System.out.println(searchResultsExpanded);

        firstSearchResults.sendKeys(Keys.RETURN);

       /* String chosenFlight;
        firstSearchResults.
        System.out.println("clicked on the 1st Sear results");
*/
       // String upFlightName = TestApp.getInstance().getDriver().findElement(By.xpath("//*[@id='searchResultsItem-0']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li")).getText();
     //   System.out.println("Upflight Name" + upFlightName);

        /*int i = 0;
        while (i < 3) {




            // TestApp.getInstance().waitForElement(By.xpath("//*[@id='searchResultsItem-" + i + "']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li"), 20);
            //TestApp.getInstance().waitForElement(By.xpath("//*[@id='searchResultsItem-" + i + "']/div/div[3]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li"), 20);

          //  TestApp.getInstance().getDriver().findElement(By.xpath("//*[@id='searchResultsItem-0']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li")).click();
            String upFlightName=   TestApp.getInstance().getDriver().findElement(By.xpath("//*[@id='searchResultsItem-0']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li")).getText();

            WebElement upPath  = driver.findElement(By.xpath("//*[@id='searchResultsItem-0']/div/div[2]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li"));
           // String upFlightName=upPath.getText();
            System.out.println("Upflight Name"+upFlightName);

            String downFlightName = driver.findElement(By.xpath("//*[@id='searchResultsItem-0']/div/div[3]/div/div/div/div[2]/div/ul/li/div[2]/div[1]/ul/li")).getText();
            System.out.println("downflight Name"+downFlightName);
            System.out.println("inside while loop method");

            if (upFlightName == fName && downFlightName == fName) {
                chosenFlight=upFlightName;
                System.out.println("Choosen up Flight is "+chosenFlight);
                        //  System.out.println("Choosen up Flight is " + upFlightName);
               // System.out.println("Choosen down Flight is " + downFlightName);

                int j=i+1;
                WebElement reserveButton=driver.findElement(By.xpath("//section[@data-ref='container']/ul/li["+j+"]/div/form/div/div[2]/div/button[@class='btn btn-primary btn-block theme-search-results-item-price-btn ladda waves-effect']"));
                reserveButton.click();
                System.out.println("button Clicked ");

                break;

            }
            else {
                i++;
            }

        }

            return this;





    }*/



    public Boolean noSearchResultsErrorMessage(){
        WebDriverWait wb=new WebDriverWait(TestApp.getInstance().getDriver(), 30);
        WebElement errorMessage;
        errorMessage=  wb.until(ExpectedConditions.visibilityOf(noSearchResultsImg));
        boolean message=noSearchResultsImg.isDisplayed();
        //System.out.println("print the bool value "+message);
        return message;

    }
}
