package com.events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Brochure_Form {
  @Test
  public void demofunction() throws InterruptedException {
      WebDriver driver;
      System.setProperty("webdriver.chrome.driver", "lib/driver/ChromeDriver/chromedriver");
      driver = new ChromeDriver();
      driver.manage().deleteAllCookies();
      driver.get("http://prdxnstaging.com/events/");
      driver.manage().window().maximize();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//div/a[@class= 'btn btn-default btn-blue' and text()='Brochure']")).click();
      String pagetitle = driver.getTitle();
      System.out.println("" +pagetitle );    
      String formname = driver.findElement(By.xpath("//div/h4[@class='after-success' and text()='Download Brochure']")).getText();
      System.out.println(""+formname);
      String actualname = "DOWNLOAD BROCHURE";
      System.out.println(""+actualname);
      if(formname.equals(actualname)) {
          System.out.println("Brochure form is opened");
      }else {
          System.out.println("Brochure form not opened");
      }
}
  }

