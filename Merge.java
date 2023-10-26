package week7.day3;


	import java.util.ArrayList;


	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;
	public class Merge {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> childWindow = driver.getWindowHandles();
		List<String> openedWindow=new ArrayList<String>(childWindow);
		driver.switchTo().window(openedWindow.get(1));                    
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();   	
		Set<String> ParentWindow = driver.getWindowHandles();
		List<String> mainWindow= new ArrayList<String>(ParentWindow);
		driver.switchTo().window(mainWindow.get(0));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='To Lead']/following::img")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> childWindow2=new ArrayList<String>(windowHandles);
		driver.switchTo().window(childWindow2.get(1));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[4]")).click();
		driver.switchTo().window(mainWindow.get(0));
		 driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}
	}

