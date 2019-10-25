import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseSeleniumTest {
    protected WebDriver driver;
    @BeforeTest

    public void setUp(){//metoda włącza się przed testem
        System.out.println("Przed testem!!!");
        String driverPath="C:\\Users\\wasia\\IdeaProjects\\seleniumkurs\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(500,500);//zmienna określająca wielkość okna
        driver.manage().window().maximize();//ustawia pełne okno przeglądarki
    }
    @AfterTest
    public void tearDown(){
        System.out.println("Po teście!!");
        driver.quit();

    }
}


