import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://pagination.js.org/");
            Thread.sleep(1000);

            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"demo1\"]/div[1]/ul/li"));

            List<WebElement> pages = driver.findElements(By.xpath("//*[@id=\"demo1\"]/div[2]/div/ul/li/a"));

            String text = elements.get(5).getText();
            System.out.println(text);

            pages.get(2).click();
            wait.until(ExpectedConditions.stalenessOf(elements.get(5)));

            elements = driver.findElements(By.xpath("//*[@id=\"demo1\"]/div[1]/ul/li"));

            text = elements.get(5).getText();
            System.out.println(text);

            Thread.sleep(10000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
            driver.quit();
        }

    }
}