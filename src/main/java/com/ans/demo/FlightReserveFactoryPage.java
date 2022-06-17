package com.ans.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightReserveFactoryPage {

    @FindBy(xpath="//input[@name='firstname']") private WebElement firstName;
    @FindBy(xpath="//input[@name='lastname']") private WebElement lastName;
    @FindBy(xpath="//input[@name='email']") private WebElement email;
    @FindBy(xpath="//input[@name='phone']") private WebElement phone;
    @FindBy(xpath="//input[@name='address']") private WebElement address;
    @FindBy(xpath="//*[@id='select2-country_code-sx-container']") private WebElement country; ////*[@id="select2-country_code-sx-container"]
    @FindBy(xpath="//*[@id='select2-nationality-b9-container']") private WebElement nationality;
    ////*[@id='select2-country_code-sx-container']
    ////*[@id='select2-nationality-b9-container']
    //Traveller 1
    @FindBy(xpath="//select[@name='title_1']") private WebElement title; ////*[@id="fadein"]/div[2]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[7]/div/div/div/span/span[1]/span
    @FindBy(xpath="//input[@name='firstname_1']") private WebElement firstName_1;
    @FindBy(xpath="//input[@name='lastname_1']") private WebElement lastName_1;
    @FindBy(xpath="//select[@name='nationality_1']") private WebElement nationality_1;
    @FindBy(xpath="//select[@name='dob_month_1']") private WebElement  dob_month_1;
    @FindBy(xpath="//select[@name='dob_day_1']") private WebElement dob_day_1;
    @FindBy(xpath="//select[@name='dob_year_1']") private WebElement dob_year_1;
    @FindBy(xpath="//input[@name='passport_5']") private WebElement passport_1;
    @FindBy(xpath="//select[@name='passport_issuance_month_5']") private WebElement passport_issuance_month_5;
    @FindBy(xpath="//select[@name='passport_issuance_day_5']") private WebElement passport_issuance_day_5;
    @FindBy(xpath="//select[@name='passport_issuance_year_5']']") private WebElement passport_issuance_year_5;
    @FindBy(xpath="//select[@name='passport_month_5']") private WebElement passport_month_5;
    @FindBy(xpath="//select[@name='passport_day_5']") private WebElement passport_day_5;
    @FindBy(xpath="//select[@name='passport_year_5']") private WebElement passport_year_5;

    @FindBy(xpath="//input[@id='gateway_bank-transfer']") private WebElement payment_method;
    @FindBy(xpath="//input[@id='agreechb']") private WebElement agreeChb;
    @FindBy(xpath="//button[@id='booking']") private WebElement confirmButton;

    @FindBy(xpath="//input[@class='btn btn-success btn-block']") private WebElement paymentConfirmation;

    //div[@class='col-md-3 pt-2 text-center']//h4  -- to get the invoice total
    //div[@class='form-title-wrap']//h3/span/ -- to get the reservation number


    //input[@value='Request Cancellation']
    //button[@id='download']

    public FlightReserveFactoryPage reserveFlight(){



        return this;
    }


}
