package Flipkart;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Eletronics {
	
	@BeforeTest
	@Parameters(value= {"browser"})
	public void setUPTest(String browser) {
		//chrome Browser
		if(browser.equalsIgnoreCase("chrome"))
		{
				System.setProperty("webdriver.chrome.driver", "C:\\seleniumdrivers\\Chrome\\chromedriver.exe");
		        // Initialize browser
				driver1=new ChromeDriver();
	}else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\seleniumdrivers\\FireFox\\geckodriver.exe");
        //Initialize browser
	 driver1=new FirefoxDriver();
	}
	}
	
	static WebDriver driver1;
	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	 
        
       //chrome Browser
		//ystem.setProperty("webdriver.chrome.driver", "C:\\seleniumdrivers\\Chrome\\chromedriver.exe");
        // Initialize browser
		//driver1=new ChromeDriver();
		
		//firefox browser
		//System.setProperty("webdriver.gecko.driver", "C:\\seleniumdrivers\\FireFox\\geckodriver.exe");
        // Initialize browser
	    //WebDriver driver=new FirefoxDriver();
	@Test
         public void Test2() throws InterruptedException {
	  //implicit wait
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//maximize window
		driver1.manage().window().maximize();
		
		
	   // Open Google
		driver1.get("https://www.google.com");
	    Thread.sleep(1000);
	   
        Thread.sleep(2000);
        
       //opening Amazon
        driver1.get("https://www.amazon.com");
        Thread.sleep(1000);
        
        
        driver1.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        Thread.sleep(2000);
        
       //login to account
        driver1.findElement(By.id("ap_email")).sendKeys("ichitha02@gmail.com");
        driver1.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        driver1.findElement(By.id("ap_password")).sendKeys("Ichitha123");
        driver1.findElement(By.id("signInSubmit")).click();
        Thread.sleep(1000);
       
        
        driver1.get("https://www.amazon.in/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1&action=sign-out&ref_=nav_AccountFlyout_signout&");
       
       //searching for product
        WebElement searchboxmob = driver1.findElement(By.id("twotabsearchtextbox"));
        searchboxmob.sendKeys("iphone x");
        searchboxmob.submit();
        driver1.findElement(By.linkText("Apple iPhone XR (128GB) - (Product) RED")).click();
        switchToWindow();
        Thread.sleep(2000);
       
       
        WebElement dropdown = driver1.findElement(By.xpath("//select[@name='quantity']"));
        Select selectObject = new Select(dropdown);
        //selectObject.selectByIndex(1);
        selectObject.selectByValue("2");
        Thread.sleep(1000);
        /*WebElement cart = driver1.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        cart.click();*/
        //driver1.switchTo().window("https://www.amazon.in/New-Apple-iPhone-XR-128GB/dp/B08L89NSQK/ref=sr_1_1_sspa?crid=2CHMACBOJZ4M6&keywords=iphone%2Bx&qid=1653993408&sprefix=%2Caps%2C317&sr=8-1-spons&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyRElWWURYQ0wxTkwyJmVuY3J5cHRlZElkPUEwNTkwMjIzMjA2TDdFT1gwTUZDUSZlbmNyeXB0ZWRBZElkPUEwNDc4Mjg5M05OVDI5SlM1NDExRSZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU&th=1");
        //driver1.switchTo().newWindow("https://www.amazon.in/New-Apple-iPhone-XR-128GB/dp/B08L89NSQK/ref=sr_1_1_sspa?crid=2CHMACBOJZ4M6&keywords=iphone%2Bx&qid=1653993408&sprefix=%2Caps%2C317&sr=8-1-spons&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyRElWWURYQ0wxTkwyJmVuY3J5cHRlZElkPUEwNTkwMjIzMjA2TDdFT1gwTUZDUSZlbmNyeXB0ZWRBZElkPUEwNDc4Mjg5M05OVDI5SlM1NDExRSZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU&th=1");
        
       //add to cart
        WebElement addcart = driver1.findElement(By.xpath("//*[@id='add-to-cart-button']"));
       ((JavascriptExecutor)driver1).executeScript("arguments[0].click()",addcart);
        driver1.findElement(By.id("attach-close_sideSheet-link")).click();
        Thread.sleep(1000);
        //opening cart
        driver1.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
        Thread.sleep(1000);
        
       
     //purchasing Laptop
       WebElement searchboxlaptop = driver1.findElement(By.id("twotabsearchtextbox"));
       searchboxlaptop.sendKeys("Laptop");
       searchboxlaptop.submit();
       Thread.sleep(1000);
       driver1.findElement(By.linkText("Honor MagicBook X 15, Intel Core i3-10110U / 15.6 inch (39.62 cm) FHD IPS Anti-Glare Thin and Light Laptop (8GB/256GB PCIe SSD/Windows 10/Aluminium Metal Body/1.56Kg), Silver, (BohrBR-WAI9A)")).click();
       switchToWindow();
       
       Thread.sleep(1000);
     
      //add to cart
       WebElement addcartlaptop = driver1.findElement(By.xpath("//*[@id='add-to-cart-button']"));
       ((JavascriptExecutor)driver1).executeScript("arguments[0].click()",addcartlaptop);
       driver1.findElement(By.id("attach-close_sideSheet-link")).click();
       driver1.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
      
       Thread.sleep(1000);
       
       //WebElement cart1 = driver1.findElement(By.xpath("//input[@class='a-button-input']"));
       //((JavascriptExecutor)driver1).executeScript("arguments[0].click()",cart1);
       //driver1.findElement(By.xpath("//input[@class='a-button-input']")).click();
       //WebElement deletecart = driver1.findElement(By.xpath("//*[@value='Delete']"));
       //((JavascriptExecutor)driver1).executeScript("arguments[0].click()",deletecart);
       
      //Delete product 
       WebElement deletecart = driver1.findElement(By.xpath("//*[@value='Delete']"));
       ((JavascriptExecutor)driver1).executeScript("arguments[0].click()",deletecart);
       //driver1.findElement(By.id("delete")).click();
     
       Thread.sleep(1000);
       
       //driver1.switchTo().newWindow("https://www.amazon.in/New-Apple-iPhone-XR-128GB/dp/B08L89NSQK/ref=sr_1_1_sspa?crid=2CHMACBOJZ4M6&keywords=iphone%2Bx&qid=1653993408&sprefix=%2Caps%2C317&sr=8-1-spons&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyRElWWURYQ0wxTkwyJmVuY3J5cHRlZElkPUEwNTkwMjIzMjA2TDdFT1gwTUZDUSZlbmNyeXB0ZWRBZElkPUEwNDc4Mjg5M05OVDI5SlM1NDExRSZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU&th=1");
      //driver1.findElement(By.xpath("//span[@id='submit.add-to-cart-announce' and contains(text(),'Add to Cart')]")).click();
       /*screenshot
       File srcFile = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(srcFile,new File("./image1.png"));*/
     
       //Closing window
       //driver1.close();
       
      //closing report
      
       //driver1.quit();
         }
    @AfterTest
	public void tearDownTest()
	{
		//Closing window
	       driver1.close();
	      
	      //closing report
	      
	       driver1.quit();
	       System.out.println("completed");
	}
	
	//method for swtching window
	public static boolean switchToWindow()
	{
		String pw=driver1.getWindowHandle();
	       String cw=null;
	       Set<String> avaiblewindows=driver1.getWindowHandles();
	       Iterator<String> handle=avaiblewindows.iterator();
	       while(handle.hasNext())
	       { cw=handle.next();}
	       driver1.switchTo().window(cw);
	       return true;
	}
	
	

}

