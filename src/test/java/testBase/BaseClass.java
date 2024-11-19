package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //for logger
import org.apache.logging.log4j.Logger; //for logger
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Logger logger;// for Logging
	public static WebDriver driver;// make it static so that you can use same instance in Extent report manager
	public Properties p;
	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters("browser")
	public void setUp(String br) throws IOException {
		
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);

		logger = LogManager.getLogger(this.getClass());// For Logger (Log4j)

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("No matching browser...");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("appUrl")); // get url from config.properties file
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return generatedString;
	}

	public String randomNumeric() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphanumeric() {
		String Alpha = RandomStringUtils.randomAlphabetic(3);
		String Number = RandomStringUtils.randomNumeric(3);
		return (Alpha + Number);
	}
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
			/*File target=new File(destination);
			
			source.renameTo(target);
			return destination;*/

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;

		}

	}


