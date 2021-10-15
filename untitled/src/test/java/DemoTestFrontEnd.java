import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DemoTestFrontEnd {

    @Test
    public void testGetUser() {

        System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mercadolibre.com.ar/");
       WebElement searchTextbox= driver.findElement(By.className("nav-search-input"));
       searchTextbox.sendKeys("TERMO LUMILAGRO");
       searchTextbox.submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//span[contains(text(),'Llega gratis')]/../../../../../../div[2]/a/h2")));
        WebElement link= driver.findElement(By.xpath("//span[contains(text(),'Llega gratis')]/../../../../../../div[2]/a/h2"));
        link.click();

        WebElement titulo=driver.findElement(By.cssSelector(".ui-pdp-title"));
        WebElement stock=driver.findElement(By.cssSelector(".ui-pdp-stock-information"));



        Assert.assertEquals(titulo.getText().toLowerCase(),"TERMO LUMILAGRO".toLowerCase());
        Assert.assertEquals(stock.getText().toLowerCase(),"Stock disponible".toLowerCase());
    }
}
