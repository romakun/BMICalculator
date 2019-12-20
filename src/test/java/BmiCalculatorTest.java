import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BmiCalculatorTest {

    @Test
    public void calculateKgCmsNormal() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        /*

         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("85");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();
        String si = driver.findElement(By.name("si")).getAttribute("value");
        String us = driver.findElement(By.name("us")).getAttribute("value");
        String uk = driver.findElement(By.name("uk")).getAttribute("value");
        String category = driver.findElement(By.name("desc")).getAttribute("value");

        assertEquals(category,"Your category is Normal", "Категория не совпадает с ожидаемой");
        assertEquals(si,"24.84", "SI не совпадает с ожидаемым");
        assertEquals(us,"25.25", "US не совпадает с ожидаемым");
        assertEquals(uk,"157.73", "UK не совпадает с ожидаемым");

        driver.quit();

    }

    @Test
    public void calculateKgCmsStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        /*

         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("12");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();
        String si = driver.findElement(By.name("si")).getAttribute("value");
        String us = driver.findElement(By.name("us")).getAttribute("value");
        String uk = driver.findElement(By.name("uk")).getAttribute("value");
        String category = driver.findElement(By.name("desc")).getAttribute("value");

        assertEquals(category,"Your category is Starvation", "Категория не совпадает с ожидаемой");
        assertEquals(si,"3.51", "SI не совпадает с ожидаемым");
        assertEquals(us,"3.57", "US не совпадает с ожидаемым");
        assertEquals(uk,"22.29", "UK не совпадает с ожидаемым");

        driver.quit();

    }

    @Test
    public void calculateKgCmsObese() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        /*

         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("90");
        driver.findElement(By.name("ht")).sendKeys("100");
        driver.findElement(By.name("cc")).click();
        String si = driver.findElement(By.name("si")).getAttribute("value");
        String us = driver.findElement(By.name("us")).getAttribute("value");
        String uk = driver.findElement(By.name("uk")).getAttribute("value");
        String category = driver.findElement(By.name("desc")).getAttribute("value");

        assertEquals(category,"Your category is Obese", "Категория не совпадает с ожидаемой");
        assertEquals(si,"90", "SI не совпадает с ожидаемым");
        assertEquals(us,"91.51", "US не совпадает с ожидаемым");
        assertEquals(uk,"571.5", "UK не совпадает с ожидаемым");

        driver.quit();

    }
}
