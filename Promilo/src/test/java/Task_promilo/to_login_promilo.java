package Task_promilo;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class to_login_promilo {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		Properties pro = new Properties();
		pro.load(pfis);
		String browser = pro.getProperty("Browser");
		String url = pro.getProperty("Url");
		String Email_id = pro.getProperty("Email");
		String user_Password = pro.getProperty("Password");
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		// WebDriver setup
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"btn submit-btn fw-bold code-text font-16 p-25\"]")).click();
		//login
		driver.findElement(By.linkText("LogIn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Email Or Mob No.\" and @class=\"border-right font-16 form-control\"]")).sendKeys(Email_id);
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Password\" and @type=\"password\"]")).sendKeys(user_Password);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@type=\"button\" and @class=\"signup-btn font-18 fw-bold mt-2 border-0 btn btn-primary d-block w-100\"]")).click();
		System.out.println("sign in");
		Thread.sleep(2000);
		driver.quit();
	
	}

}
