package com_utimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-5 - ProjectName : com-utimateqa
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class UltimateQaMultiBrowser {
    static String browser = "edge";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;
    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else{
            System.out.println("Wrong browser name");
        }
        //Open URL.
        driver.get(baseUrl);
        // Maximise the browser window
        driver.manage().window().maximize();
        // We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Print the title of the page.
        String getTitle = driver.getTitle();
        System.out.println("Page Title: " +getTitle);
        //Print the current url.
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Page Current URL: " +currentUrl);
        //Print the page source.
        String pageSource = driver.getPageSource();
        System.out.println("Page Page Source: " +pageSource);
        //Click on ‘Sign In’ link
        WebElement signInButton = driver.findElement(By.className("header__nav-sign-in"));
        signInButton.click();
        //Print the current url.
        String prtCurrentUrl = driver.getCurrentUrl();
        System.out.println("Page Current URL: " +prtCurrentUrl);
        //Enter the email to email field.
        WebElement emailID = driver.findElement(By.name("user[email]"));
        emailID.sendKeys("Prime123@gmail.com");
        //Enter the password to password field.
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("12345");
        //Click on Login Button.
        WebElement loginButton = driver.findElement(By.className("button-primary"));
        loginButton.click();
        //Navigate to baseUrl.
        driver.navigate().to(baseUrl);
        //Navigate forward to Homepage.
        driver.navigate().forward();
        //Navigate back to baseUrl.
        driver.navigate().to(baseUrl);
        //Refresh the page.
        driver.navigate().refresh();
        //Close the browser.
        driver.quit();



    }
}
