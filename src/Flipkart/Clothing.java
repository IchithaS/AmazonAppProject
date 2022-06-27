package Flipkart;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Clothing {

	static WebDriver driver2;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	    // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("Execution of ecommerce app", "Sample description");
        test.info("Amazon website");
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdrivers\\Chrome\\chromedriver.exe");

		// Initialize browser
		 driver2=new ChromeDriver();
        
		//implicit wait
		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Open Google
		driver2.get("https://www.google.com");
	    Thread.sleep(1000);
	    test.log(Status.PASS, "open Google");

	    //System.setProperty("webdriver.gecko.driver", "C:\\seleniumdrivers\\FireFox\\geckodriver.exe");
        // Initialize browser
	    //WebDriver driver=new FirefoxDriver();

	    
        driver2.get("https://www.amazon.com");
        Thread.sleep(1000);
        test.log(Status.PASS, "launching amazon website");
        
        driver2.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        Thread.sleep(1000);
        driver2.findElement(By.id("ap_email")).sendKeys("ichitha02@gmail.com");
        driver2.findElement(By.id("continue")).click();
        Thread.sleep(1000);
        driver2.findElement(By.id("ap_password")).sendKeys("Ichitha123");
        driver2.findElement(By.id("signInSubmit")).click();
        Thread.sleep(1000);
        test.log(Status.PASS, "Login");
       //String u=driver1.getCurrentUrl();
        //driver2.get("https://www.amazon.in/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1&action=sign-out&ref_=nav_AccountFlyout_signout&");
       
        WebElement searchboxmob = driver2.findElement(By.id("twotabsearchtextbox"));
        searchboxmob.sendKeys("Womens wear");
        searchboxmob.submit();
        test.log(Status.PASS, "search for product");
        
        driver2.get("https://www.amazon.in/s?k=Womens+wear&rh=n%3A1953602031%2Cn%3A1968445031&dc&qid=1654423401&rnid=3576079031&ref=sr_nr_n_4");
       // driver2.findElement(By.linkText("Apple iPhone XR (128GB) - (Product) RED")).click();
        //switchToWindow();
        Thread.sleep(2000);
        
        /*WebElement chkbrand = driver2.findElement(By.xpath("//*[@id=\"p_89/Harpa\"]/span/a/div/label/input"));
        chkbrand.click();
        System.out.println("Check Box..");*/
        
        driver2.findElement(By.linkText("Ray Cook Gyro Women's Graphite Golf Set - Right Hand - Ladies Flex - 9 Clubs + Bag")).click();
        switchToWindow();
        WebElement addcartdress = driver2.findElement(By.xpath("//*[@id='add-to-cart-button']"));
        ((JavascriptExecutor)driver2).executeScript("arguments[0].click()",addcartdress);
        driver2.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span")).click();
        driver2.get("https://www.amazon.in/gp/cart/view.html?ref_=sw_gtc");
        test.log(Status.PASS, "add to cart");
        driver2.close();
        test.log(Status.PASS, "close browser");
        extent.flush();
        driver2.quit();
        
        
	}
	
	public static boolean switchToWindow()
	{
		String pw=driver2.getWindowHandle();
	       String cw=null;
	       Set<String> avaiblewindows=driver2.getWindowHandles();
	       Iterator<String> handle=avaiblewindows.iterator();
	       while(handle.hasNext())
	       { cw=handle.next();}
	       driver2.switchTo().window(cw);
	       return true;
	}

}
