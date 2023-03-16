package TestCases;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
	/*	List<WebElement> listOfSites = driver.findElements(By.xpath("//table[@id='customers']/tbody//td[1]"));
		List<String> orgList = listOfSites.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = orgList.stream().sorted().collect(Collectors.toList());
		if(sortedList.equals(orgList)) {
			System.out.println("Sorted");
		}
		else {
			System.out.println("Not Sorted");
		}*/
		
		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@id='customers']/tbody//td[1]"));
		
		List<String> listFinal = companyNames.stream().filter(cmpnyName->cmpnyName.getText().contains("Adobe"))
				                                              .map(cmpnyName->getCountryName(cmpnyName)).collect(Collectors.toList());
	System.out.println(listFinal);
	}

	private static String getCountryName(WebElement s) {
		String country = s.findElement(By.xpath("following-sibling::td[2]")).getText();
		return country;
	}

}
