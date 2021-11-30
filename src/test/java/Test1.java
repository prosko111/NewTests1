import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test1 {
    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://accounts.spotify.com/login");       // Open web-site
        driver.findElement(By.id("login-username")).sendKeys("po4ta@nepravv.ru");
        driver.findElement(By.id("login-password")).sendKeys("igogogo43");

        driver.findElement(By.xpath("//*[@class=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();  // Нажатие кнопки Лог Ин, локатор Xpath (по тексту)

        WebElement errorMessage = driver.findElement(By.xpath("//span[@class=\"ng-binding ng-scope\"]"));
        String strText = errorMessage.getText();
        String strExpected1 = "Your request failed. Please try again.";
        String strExpected2 = "Неправильное имя пользователя или пароль.";
        String strActual = strText;
        System.out.println(strActual);
        if (strExpected1.equals(strActual) || strExpected2.equals(strActual)) {
            System.out.println("Строки равны");
        }
        else {
            System.out.println("Строки не равны");
        }
        driver.close();
    }
}
