package Flipkart;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Grocery {
    
	static WebDriver driver3;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        
		//firefox browser
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdrivers\\Chrome\\chromedriver.exe");
		        //Initialize browser
			    WebDriver driver3=new ChromeDriver();
			    driver3.manage().window().maximize();
			    
			    driver3.get("https://www.google.com");
			    Thread.sleep(1000);
			    //opening Amazon
		        driver3.get("https://www.amazon.com");
		        Thread.sleep(1000);
		        driver3.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		        Thread.sleep(2000);
		        
		        driver3.findElement(By.id("ap_email")).sendKeys("ichitha02@gmail.com");
		        driver3.findElement(By.id("continue")).click();
		        Thread.sleep(1000);
		        driver3.findElement(By.id("ap_password")).sendKeys("Ichitha123");
		        driver3.findElement(By.id("signInSubmit")).click();
		        Thread.sleep(1000);
		        
		        WebElement searchboxmob = driver3.findElement(By.id("twotabsearchtextbox"));
		        searchboxmob.sendKeys("grocery items all");
		        searchboxmob.submit();
		        driver3.findElement(By.linkText("BRU Instant Coffee Powder 200g Pouch, Roasted Arabica & Robusta Ground Coffee Beans From South India - Rich & Strong Blend Of Coffee & Chicory")).click();
		        switchToWindow();
		        
		        WebElement addcart = driver3.findElement(By.xpath("//*[@id='submit.add-to-cart-announce']"));
		        ((JavascriptExecutor)driver3).executeScript("arguments[0].click()",addcart);
		        // driver3.findElement(By.id("attach-close_sideSheet-link")).click();
		         //Thread.sleep(1000);
		         //opening cart
		         //driver3.get("https://www.amazon.in/gp/cart/view.html?ref_=sw_gtc");
		         //Thread.sleep(1000);
		        driver3.close();
		        driver3.quit();
		        
	}
	public static boolean switchToWindow()
	{
		
		String pw=driver3.getWindowHandle();
	       String cw=null;
	       Set<String> avaiblewindows=driver3.getWindowHandles();
	       Iterator<String> handle=avaiblewindows.iterator();
	       while(handle.hasNext())
	       { cw=handle.next();}
	       driver3.switchTo().window(cw);
	       return true;
	}

}
