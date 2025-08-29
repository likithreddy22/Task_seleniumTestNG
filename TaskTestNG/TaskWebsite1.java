package TaskTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class TaskWebsite1 {
	WebDriver driver;
  @Test
  public void form() throws IOException {
	  FileReader fr = new FileReader("C:\\Users\\likithreddy.konda\\eclipse-workspace\\Selenium\\TestNGJava\\src\\TaskTestNG\\inputdata.properties");
	  Properties p = new Properties();
	  p.load(fr);
	  
	  WebElement firstname= driver.findElement(By.id("first_name"));
	  firstname.sendKeys(p.getProperty("first"));
	  System.out.println(firstname.getAttribute("value"));
	  
	  WebElement lastname= driver.findElement(By.id("last_name"));
	  lastname.sendKeys(p.getProperty("last"));
	  System.out.println(lastname.getAttribute("value"));
	  
	  WebElement email = driver.findElement(By.id("email"));
	  email.sendKeys(p.getProperty("mail"));
	  System.out.println(email.getAttribute("value"));
	  
	  WebElement mobile = driver.findElement(By.id("phone"));
	  mobile.sendKeys(p.getProperty("number"));
	  System.out.println(mobile.getAttribute("value"));
	  
	  WebElement org = driver.findElement(By.id("organization"));
	  org.sendKeys(p.getProperty("company"));
	  System.out.println(org.getAttribute("value"));
	  
	  Select countryname = new Select(driver.findElement(By.xpath("//select[@class='addressCountry form-control']")));
	  countryname.selectByVisibleText(p.getProperty("country"));
	  
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Select users = new Select(driver.findElement(By.id("users")));
	  users.selectByVisibleText(p.getProperty("user"));
	 
	  
	  WebElement check = driver.findElement(By.id("type_hosted"));
	  check.click();
	  
	  WebElement host = driver.findElement(By.id("hostname"));
	  host.sendKeys(p.getProperty("hostname"));
	  System.out.println(host.getAttribute("value"));
	  
	  WebElement check1 = driver.findElement(By.id("tos"));
	  check1.click();
	  
	  WebElement check2 = driver.findElement(By.id("gdpr"));
	  check2.click();
	  
	  WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	  submit.click();
	  
	  
	  
  }
  @BeforeTest
  public void browsersetup() throws IOException {
	  FileReader fr = new FileReader("C:\\Users\\likithreddy.konda\\eclipse-workspace\\Selenium\\TestNGJava\\src\\TaskTestNG\\inputdata.properties");
	  Properties p = new Properties();
	  p.load(fr);
	  driver = new ChromeDriver();
	  String one = driver.getWindowHandle();
	  driver.get(p.getProperty("url1"));
	  driver.manage().window().maximize();
	  driver.switchTo().newWindow(WindowType.TAB);
	  driver.get(p.getProperty("url2"));
	  driver.switchTo().window(one);
  }

  @AfterTest
  public void teardown() {
	  System.out.println(driver.getTitle());
	  driver.close();
  }

}
