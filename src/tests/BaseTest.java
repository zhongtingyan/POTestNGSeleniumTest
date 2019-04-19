package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * 实现测试前的准备动作，测试完成后的动作
 * @author Administrator
 *
 */
public class BaseTest {

	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		//读取驱动文件
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32 2.45\\chromedriver.exe");
		//加载驱动
		driver = new ChromeDriver();
		
		// 窗口最大化
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		//关闭浏览器驱动
		driver.quit();
	}
	
}
