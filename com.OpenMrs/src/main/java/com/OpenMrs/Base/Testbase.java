package com.OpenMrs.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Testbase {
	public static Properties prop;
	public static FileInputStream fis;
	public static WebDriver driver;

	public Testbase() {

		try {
			prop = new Properties();
			fis = new FileInputStream(
					"C:\\OpenMrs\\com.OpenMrs\\src\\main\\java\\com\\OpenMrs\\config\\config.properties");

			prop.load(fis);

		} catch (Exception e) {
			System.out.println("file is not found " + e.getMessage());
		}
	}

	public  static void init() {
		
		String browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\OpenMrs\\com.OpenMrs\\Browsers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\OpenMrs\\com.OpenMrs\\Browsers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("Webdriver.ie.driver", "C:\\OpenMrs\\com.OpenMrs\\Browsers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

	}

}
