package de.webdriver;


import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class FirstTest {
  
  @Before
  public void openBrowser() {
    System.setProperty("webdriver.chrome.driver", "D://Git//chrome/chromedriver.exe");
    
  }
//  @After
//  public void tearDown()
//  {
//    webDriver.quit();
//  }

  @Test
  public void testGoogleWebsiteTitle(){
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("http://www.google.com");
    assertEquals("Google",webDriver.getTitle());
    webDriver.quit();
  }
  
  @Test
  public void testGoogleWebsiteURI() {
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("http://www.google.com/");
    assertThat(webDriver.getCurrentUrl(), CoreMatchers.containsString("google"));
    webDriver.quit();
  }
}

