import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HanfligFramesTest extends BaseSeleniumTest{


    @Test
    public void HandlingFramesTest(){
        driver.get("file:///C:/Users/wasia/OneDrive/Desktop/Java%20Selenium/iFrameTest.html");
        driver.switchTo().frame(0);
        WebElement clickOneMeButton = driver.findElement(By.id("clickOnMe"));
        clickOneMeButton.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        List<WebElement>headers = driver.findElements(By.tagName("h1"));
        System.out.println(headers.size());
        headers.forEach(webElement ->
                System.out.println(webElement.getText()));


    }


}
