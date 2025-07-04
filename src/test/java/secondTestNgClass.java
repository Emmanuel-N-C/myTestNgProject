import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class secondTestNgClass {

    WebDriver driver;
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
    @Test (priority = 0)
    public void openBrowser() throws InterruptedException {

        System.out.println("Opening the browser");
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }
    @Test (priority = 1)
    public void keypressfunction()
    {
        System.out.println("Signing up");
        driver.findElement(By.linkText("Key Presses")).click();
    }
    @Test (priority = 2)
    public void insertValue(){
        char randomChar = generateRandomChar();
        System.out.println("Generated character: " + randomChar);

        // Send the value
        driver.findElement(By.id("target")).sendKeys(String.valueOf(randomChar));

        // Get the result text
        WebElement resultElement = driver.findElement(By.id("result"));
        String resultText = resultElement.getText();
        System.out.println("Displayed result: " + resultText);
    }

    private char generateRandomChar() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand = new Random();
        return chars.charAt(rand.nextInt(chars.length()));
    }

    @Test (priority = 3)
    public void FloatingMenu(){

        System.out.println("Navigating to floating menu sector");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.findElement(By.linkText("Floating Menu")).click();
    }

}
