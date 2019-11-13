package com.events;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Share_Functionality {
  @Test
  public void demofunction() throws InterruptedException {
      WebDriver driver;
      System.setProperty("webdriver.chrome.driver", "lib/driver/ChromeDriver/chromedriver");
      driver = new ChromeDriver();
driver.get("http://prdxnstaging.com/events/");
Thread.sleep(1000);
driver.findElement(By.xpath("//*[contains (text(), 'WAR ON CANCER 2016')]")).click();
String Actualeventtitle = driver.getTitle();
System.out.println("Event title is "  +Actualeventtitle);
driver.findElement(By.xpath("//span[@class='a2a_svg a2a_s__default a2a_s_facebook']")).click();
String parentWindowHandler = driver.getWindowHandle();
String subWindowHandler = null;
Set<String> handles = driver.getWindowHandles();
Iterator<String> iterator = handles.iterator();
while (iterator.hasNext()){
subWindowHandler = iterator.next();
}
driver.switchTo().window(subWindowHandler);
driver.manage().window().maximize();
String Facebooktitle = driver.getTitle();
String Actualname = "Facebook";
if(Facebooktitle.equals(Actualname)) {
System.out.println("Facebook page is open successfully");
}
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("prdxnemail@gmail.com");
driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("f2ce17");
driver.findElement(By.xpath("//*[@id=\"u_0_0\"]")).click();
WebElement sharedevent = driver.findElement(By.xpath("//div[@class='unclickable']"));
String sharedeventname = sharedevent.getText();
System.out.println("Shared event is "  + sharedeventname);
if((sharedeventname.contains("War on Cancer 2016"))) {
System.out.println("Test case for facebook shared functionality is passed");
}else {
System.out.println("Test case for facebook shared functionality is fail");
}
driver.close();
driver.switchTo().window(parentWindowHandler);
}
}
