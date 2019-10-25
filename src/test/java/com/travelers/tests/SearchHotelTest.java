package com.travelers.tests;
import com.travelers.pages.HomePageObject;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchHotelTest extends Base{
    @Test
    public void searchHotelTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.kurs-selenium.pl/demo/");

        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.sendKeysToCityInput("Dubai");
        homePageObject.dataRange("10/11/2019","11/12/2019");
        homePageObject.peresonCountClick();
        homePageObject.personCount("3","11");
        homePageObject.ButtonClick();


        ResultPage resultPage = new ResultPage(driver);
        List<String>hotelNames = resultPage.getHotelNames();
        Assert.assertEquals("Jumeirah Beach Hotel",hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower",hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana",hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth",hotelNames.get(3));
        List<String>prices =  resultPage.getHotelPrices();
        Assert.assertEquals("$22",prices.get(0));
        Assert.assertEquals("$50",prices.get(1));
        Assert.assertEquals("$80",prices.get(2));
        Assert.assertEquals("$150",prices.get(3));
            }
}
