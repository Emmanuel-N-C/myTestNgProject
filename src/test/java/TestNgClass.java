import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestNgClass {

    WebDriver driver;
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(7000);
        driver.quit();
    }
    @Test (priority = 0)
    public void openBrowser() throws InterruptedException {
        System.out.println("Opening the browser");
        driver.navigate().to("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);

    }
    @Test (priority = 1)
    public void signupScreen(){
        System.out.println("Signing up");
        driver.findElement(By.linkText("Form Authentication")).click();
    }
    @Test (priority = 2)
    public void SignupInput(){
        System.out.println("Logging in");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
    }
    @Test (priority = 3)
    public void sortedTables() throws InterruptedException {
        System.out.println("loading up to the screen");
        driver.navigate().to("https://the-internet.herokuapp.com/tables");


    }
    @Test (priority = 4)
    public void TableInfo(){
        System.out.println("Table informations");
        WebElement table = driver.findElement(By.id("table1"));
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        System.out.println(tableRows.size());
        for (int i = 0; i < tableRows.size(); i++) {
            System.out.println("Row " + (i+1) + ": " + tableRows.get(i).getText());
        }
    }

}
