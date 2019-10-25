import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchTest extends BaseSeleniumTest{

    @FindBy(name = "q")
    private List<WebElement> searchInput;

    @Test
    public void googleSearchTest(){
        PageFactory.initElements(driver,this);
        driver.get("http://www.google.com");
        driver.manage().window().maximize();//ustawia pełne okno przeglądarki
        searchInput.get(0).sendKeys("Selenium");
        searchInput.get(0).sendKeys(Keys.ENTER);
        WebElement linkTextSelenium = driver.findElement(By.partialLinkText("Selenium - Web Browser Automation"));
        linkTextSelenium.click();
        String expectedTitle = "Selenium - Web Browser Automation";
        System.out.println((driver.getTitle()));
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }


}
