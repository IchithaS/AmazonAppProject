package Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToysandGames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\seleniumdrivers\\FireFox\\geckodriver.exe");
        //Initialize browser
	    WebDriver driver3=new FirefoxDriver();
	    driver3.manage().window().maximize();
	    
	    driver3.get("https://www.google.com");
	    Thread.sleep(1000);
	   
        driver3.get("https://www.flipkart.com");
        
        
        driver3.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
        //driver3.findElement(By.linkText("Grocery")).click();

       
        WebElement searchboxmob = driver3.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
        searchboxmob.sendKeys("toys for kids");
        searchboxmob.submit();

        driver3.close();
        driver3.quit();
	}

}
