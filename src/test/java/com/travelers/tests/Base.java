package com.travelers.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
    protected WebDriver driver;
    @BeforeTest
    public void setUp() {
        System.out.println("Przed testem!!!");
        String driverPath = "C:\\Users\\wasia\\IdeaProjects\\seleniumkurs\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
            System.out.println("Po teście!!");
            driver.quit();
    }


}
