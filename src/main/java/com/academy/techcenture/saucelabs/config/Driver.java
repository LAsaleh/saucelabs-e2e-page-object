package com.academy.techcenture.saucelabs.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {

    private static WebDriver driver;

    private Driver (){

    }

   public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");

       switch (browser){
           case "chrome":
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break;
           case "firefox":
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
               break;
           case "ie":
               WebDriverManager.iedriver().setup();
              driver = new InternetExplorerDriver();
              break;
           case "safari":
               WebDriverManager.safaridriver().setup();
               driver = new SafariDriver();
               break;
           case "edge":
               WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
               break;
       }

       if (driver != null){
           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTime"))));
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWaits"))));
           return driver;
       }

       throw new RuntimeException("No Driver Was Found");
   }
}
