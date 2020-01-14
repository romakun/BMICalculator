package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class BmiCalculatorTest {

    @Test
    public void calculateKgCmsNormal() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");

        //Проверка на значение в поле Вес < 11kg
        browser.findElement(By.name("wg")).sendKeys("0");
        browser.findElement(By.name("ht")).sendKeys("180");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText,"Weight should be greater than 10kgs", "Текст ошибки не совпадает с ожидаемым");
        alert.accept();

        //Проверка на значение в поле Рост < 34cm
        browser.findElement(By.name("wg")).clear();
        browser.findElement(By.name("wg")).sendKeys("80");
        browser.findElement(By.name("ht")).clear();
        browser.findElement(By.name("ht")).sendKeys("32");
        browser.findElement(By.name("cc")).click();
        alert = browser.switchTo().alert();
        String alertHeightText = alert.getText();
        assertEquals(alertHeightText,"Height should be taller than 33cms", "Текст ошибки не совпадает с ожидаемым");
        alert.accept();


        browser.findElement(By.name("ht")).clear();
        browser.findElement(By.name("ht")).sendKeys("180");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category,"Your category is Normal", "Категория не совпадает с ожидаемой");

        browser.quit();
    }

    @Test
    public void calculateKgCmsObese() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");

        browser.findElement(By.name("wg")).sendKeys("100");
        browser.findElement(By.name("ht")).sendKeys("180");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category,"Your category is Obese", "Категория не совпадает с ожидаемой");

        browser.quit();
    }
    @Test
    public void calculateKgCmsStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");

        browser.findElement(By.name("wg")).sendKeys("30");
        browser.findElement(By.name("ht")).sendKeys("180");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category,"Your category is Starvation", "Категория не совпадает с ожидаемой");

        browser.quit();
    }

    @Test
    public void calculatePoundsCmsObese() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");

        browser.findElement(By.name("wg")).sendKeys("80");
        WebElement selectElement = browser.findElement(By.name("opt1"));
        Select select = new Select(selectElement);
        select.selectByValue("pounds");
        browser.findElement(By.name("ht")).sendKeys("180");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category,"Your category is Obese", "Категория не совпадает с ожидаемой");

        browser.quit();
    }

    @Test
    public void calculatePoundsCmsNormal() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");

        browser.findElement(By.name("wg")).sendKeys("23");
        WebElement selectElement = browser.findElement(By.name("opt1"));
        Select select = new Select(selectElement);
        select.selectByValue("pounds");
        browser.findElement(By.name("ht")).sendKeys("100");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category,"Your category is Obese", "Категория не совпадает с ожидаемой");

        browser.quit();
    }

    @Test
    public void calculatePoundsCmsStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");

        browser.findElement(By.name("wg")).sendKeys("40");
        WebElement selectElement = browser.findElement(By.name("opt1"));
        Select select = new Select(selectElement);
        select.selectByValue("pounds");
        browser.findElement(By.name("ht")).sendKeys("200");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category,"Your category is Obese", "Категория не совпадает с ожидаемой");

        browser.quit();
    }


}
