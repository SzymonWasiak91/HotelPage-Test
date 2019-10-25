package com.travelers.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {
    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultsTable;

    public ResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    public List<String> getHotelNames(){
        List<String>hotelNames = new ArrayList<>();
        List<WebElement>hotelNamesWebElements = resultsTable.findElements(By.xpath("//h4//b"));
        for (WebElement hotelNameElement : hotelNamesWebElements) {
            System.out.println(hotelNameElement.getAttribute("textContent"));
            hotelNames.add(hotelNameElement.getAttribute("textContent"));
        }
        return hotelNames;
    }
    public List<String> getHotelPrices(){
        List<WebElement>hotelPrices = resultsTable.findElements(By.xpath("//div[@class='col-md-3 col-xs-4 col-sm-4 go-left pull-right price_tab']//b"));
        List<String>prices = hotelPrices.stream().map(element->element.getAttribute("textContent")).collect(Collectors.toList());
        return prices;
    }
}
