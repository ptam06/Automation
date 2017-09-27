package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Amal on 9/13/2017.
 */
public class InitiateDriver {
    public static WebDriver instance;
    private static HashMap<String,String>browserproperties=new HashMap<String, String>();
    private static String browser;
    private static String drivername;
    private static String driverpath;
    @Test
     static void getInstance() throws IOException {
      browserproperties=PropertyReader.getFileinfo("/config.properties");
      browser=browserproperties.get("browser");
      drivername=browserproperties.get("ChromeDriver");
      driverpath=browserproperties.get("ChromeDriverPath");
      if(instance==null)
      {
         if(browser.equalsIgnoreCase("chrome"))
         {
             System.setProperty(drivername,driverpath);
             instance=new ChromeDriver();
         }
      }

    }

    private InitiateDriver() {


    }
}
