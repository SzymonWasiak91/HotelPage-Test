package com.travelers.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
    @FindBy(partialLinkText = "Search by Hotel or City Name")
    private WebElement searchSpan;
    @FindBy(xpath = "//input[@name='hotel_s2_text']")
    private WebElement searchCityInput;
    @FindBy(xpath = "//input[@class='form input-lg dpd1']")
    private WebElement checkInInput;
    @FindBy(xpath = "//input[@class='form input-lg dpd2']")
    private WebElement checkOutInput;
    @FindBy(id = "travellersInput")
    private WebElement travellersInput;
    @FindBy(name = "adults")
    private WebElement adultsInput;
    @FindBy(name = "child")
    private WebElement childInput;
    @FindBy(xpath = "//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")
    private WebElement searchButton;

    public HomePageObject(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void sendKeysToCityInput(String cityName ) throws InterruptedException {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        Thread.sleep(2000);
        searchCityInput.sendKeys(Keys.ENTER);
    }
    public void dataRange(String checkInDate,String checkOutDate){
        checkOutInput.sendKeys(checkInDate);
        checkInInput.sendKeys(checkOutDate);
    }
    public void peresonCountClick(){
        travellersInput.click();
        adultsInput.clear();
        childInput.clear();
    }
    public void personCount(String countAdult, String countChild){
        adultsInput.sendKeys(countAdult);
        childInput.sendKeys(countChild);
    }
    public void ButtonClick() throws InterruptedException {
        searchButton.click();
    }


}


