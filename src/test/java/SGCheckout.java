import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SGCheckout {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://sgdev.euyansang.com/");
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement menu = driver.findElement(By.id("supermoms"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		driver.findElement(By.linkText("Energy")).click();
		
		WebElement addtocart = driver.findElement(By.xpath("//*[@id=\"product-search-results\"]//div[2]/div[2]/div/div//div/div/div[2]/button"));
		addtocart.click();
		
		WebElement clickcart = driver.findElement(By.xpath("//div[@class='d-flex align-items-center']/div[2]"));
		clickcart.click();
		
		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"maincontent\"]//div/div[3]/div/div/div/a[2]"));
		checkout.click();
		
		WebElement email = driver.findElement(By.id("email-guest"));
		email.sendKeys("satyam.mittal+sg1@ranosys.com");
		
		WebElement continueguest = driver.findElement(By.name("submit"));
		continueguest.click();
			
		WebElement date = driver.findElement(By.xpath("//*[@id=\"dwfrm_shipping\"]/div[1]/div[2]/div[2]/div/input"));
		date.click();
		
		WebElement selectdate = driver.findElement(By.xpath("//*[@id=\"ext-gen44\"]/body/div[2]/div[1]/table/tbody/tr[3]/td[4]"));
		selectdate.click();
		
		WebElement firstname = driver.findElement(By.xpath("//input[@aria-describedBy='defaultFirstName']"));
		firstname.sendKeys("Satyam");
		
		WebElement lastname = driver.findElement(By.id("shippingLastNamedefault"));
		lastname.sendKeys("Satyam");
		
		WebElement Address1 = driver.findElement(By.id("shippingAddressOnedefault"));
		Address1.sendKeys("Test Address");
		
		WebElement postalcode = driver.findElement(By.id("shippingZipCodedefault"));
		postalcode.sendKeys("302022");
		
		WebElement MobileNum = driver.findElement(By.id("shippingPhoneNumberdefault"));
		MobileNum.sendKeys("7023793220");
		
		WebElement submit = driver.findElement(By.xpath("//button[@value='submit-shipping']"));
		submit.click();
		
		WebElement tabcc = driver.findElement(By.xpath("//a[@data-method-id='CREDIT_CARD']"));
		tabcc.click();
		
		WebElement cardholdername = driver.findElement(By.id("cardholder-name"));
		cardholdername.sendKeys("Satyam");
	
		driver.switchTo().frame(1);
			
		WebElement cardnum = driver.findElement(By.xpath("//*[@name='cardnumber']"));
		cardnum.sendKeys("41111111111111110626123");
		
		driver.switchTo().parentFrame();
		
		WebElement payment = driver.findElement(By.xpath("//button[@value='submit-payment']"));
		payment.click();
		
		System.out.println("Successfully Completed");
		
		driver.close();
		
	}

}
