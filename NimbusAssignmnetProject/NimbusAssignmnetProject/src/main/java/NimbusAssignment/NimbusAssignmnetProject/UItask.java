package NimbusAssignment.NimbusAssignmnetProject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class UItask {
	
	public static WebDriver driver;
	
	Functions fun= new Functions();
	
	
	
	@Test(invocationCount=10)
	public void UItest() throws InterruptedException {
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navneetkaur055\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("http://AutoTest.Time2Work.com");
	
	driver.findElement(By.id("tbUsername")).sendKeys("Manish@Time2Work.com");
	driver.findElement(By.id("tbPassword")).sendKeys("@Manish");
	
	driver.findElement(By.id("btnLogin_btn_btnLogin_input")).click();
	
	Thread.sleep(5000);
	
	driver.navigate().refresh();
	
	WebElement Staff= driver.findElement(By.xpath("//span[@class='rnvText' and text()='Staff']"));
	
	WebDriverWait wait =new WebDriverWait(driver, 30);
	
	wait.until(ExpectedConditions.visibilityOf(Staff));
	 
	Staff.click();
	Actions action = new Actions(driver);
	
	
	WebElement staffM= driver.findElement(By.xpath("//span[@class='rnvText' and text()='Staff Management']"));
	wait.until(ExpectedConditions.visibilityOf(staffM));
	action.moveToElement(staffM).click().build().perform();
	
	String title= driver.getTitle();
	
	Assert.assertEquals("Staff Management", title);
	
	driver.findElement(By.xpath("//span[@class='rbText rbPrimary' and text()='Add new record']")).click();
	
	StringBuilder username= fun.generateRandomAlphanumeric(10);
	
	driver.findElement(By.id("cphContent_cphContent_frmEdit_Username")).sendKeys(username+"@Time2Work.com");
	
	
	
	
	
	
	driver.findElement(By.id("cphContent_cphContent_frmEdit_Forename")).sendKeys(username.substring(0, 5));
	driver.findElement(By.id("cphContent_cphContent_frmEdit_Surname")).sendKeys(username.substring(5, 9)+username.charAt(9));
	driver.findElement(By.id("cphContent_cphContent_frmEdit_Payroll")).sendKeys(username.substring(3, 8));
	driver.findElement(By.xpath("//input[@id='cphContent_cphContent_frmEdit_tbStaffPassword']")).sendKeys(username.reverse());
	
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DAY_OF_YEAR, 7);
	Date futureDateTime = calendar.getTime();
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");



	// Now format the date
	String dateFormatted= dateFormat.format(futureDateTime);
	
	System.out.println(dateFormatted);
	
	driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_frmEdit_StartDate_dateInput")).clear();
	driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_frmEdit_StartDate_dateInput")).sendKeys(dateFormatted);
	
	driver.findElement(By.xpath("//input[@id= 'cphContent_cphContent_frmEdit_Rosterable']")).click();
	
    driver.findElement(By.xpath("//td[@class='rcbArrowCell rcbArrowCellRight']//a[@id='ctl00_ctl00_cphContent_cphContent_frmEdit_TitleDescription_cb_TitleDescription_Arrow']")).click();
	
	WebElement Title= driver.findElement(By.xpath("//div[@id= 'ctl00_ctl00_cphContent_cphContent_frmEdit_TitleDescription_cb_TitleDescription_DropDown']/div/ul/li[text()='Ms.']"));
	//wait.until(ExpectedConditions.visibilityOf(Title));
	//action.moveToElement(Title).click().build().perform();
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", Title);
	
	
    driver.findElement(By.xpath("//td[@class='rcbArrowCell rcbArrowCellRight']//a[@id='ctl00_ctl00_cphContent_cphContent_frmEdit_GenderDescription_cb_GenderDescription_Arrow']")).click();
	
	WebElement gender= driver.findElement(By.xpath("//div[@class= 'rcbScroll rcbWidth']/ul/li[contains(text(), 'Female')]"));
	//wait.until(ExpectedConditions.visibilityOf(gender));
	//action.moveToElement(gender).click().build().perform();
	
	executor.executeScript("arguments[0].click();", gender);
	
	driver.findElement(By.xpath("//a[@id='ctl00_ctl00_cphContent_cphContent_frmEdit_TimezoneDescription_cb_TimezoneDescription_Arrow']")).click();
	WebElement TZ= driver.findElement(By.xpath("//div[@class= 'rcbScroll rcbWidth']/ul/li[contains(text(), 'AEST (AUS Eastern Standard Time)')]"));
	
	
	executor.executeScript("arguments[0].click();", TZ);
	
	
	
	
	WebElement saveB= driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_frmEdit_btnSave_btn_btnSave_input"));
	executor.executeScript("arguments[0].click();", saveB);
	
	// adding location
	
	Thread.sleep(3000);
	
	
	WebElement LocationB = driver.findElement(By.xpath("//span[contains(text(),'Location')]/ancestor::span[1]"));
	//executor.executeScript("arguments[0].click();", LocationB);
	action.moveToElement(LocationB).click().build().perform();
	
    driver.findElement(By.xpath("//span[contains(text(),'Add new record')]")).click();
    
    
    driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")).clear();
	driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_RDIPEffectiveFrom_dateInput")).sendKeys(dateFormatted);

    driver.findElement(By.xpath("//a[@id='ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_ddlLocation_cb_ddlLocation_Arrow']")).click();
	
   	WebElement Loc= driver.findElement(By.xpath("//div[@class='rcbScroll rcbWidth']/ul/li[contains(text(), 'Test Location')]"));
  
   	
   	executor.executeScript("arguments[0].click();", Loc);
   	
   	
   	
	WebElement saveB1= driver.findElement(By.id("ctl00_ctl00_cphContent_cphContent_tgUserLocation_ctl00_ctl02_ctl04_PerformInsertButton"));
	executor.executeScript("arguments[0].click();", saveB1);
    
    
    driver.quit();

	}	

}
