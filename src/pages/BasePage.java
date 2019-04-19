package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * BasePage类是所有page类的基类，包括初始化浏览器驱动和一些常见的页面操作
 * @author Administrator
 *
 */
public class BasePage {

	 public WebDriver driver;
	 
	 public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		super();
		wait = new WebDriverWait(driver, 15);
		//这个一定要写，不然会报空指针错误
		this.driver = driver;
		System.out.println("BasePage构造方法");
	}
	
	//休眠
	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}
	
	/**
	 * 单击
	 * @param elementBy
	 */
	public void click(By elementBy) {
		waitVisibility(elementBy);
		System.out.println("单击事件");
		driver.findElement(elementBy).click();
	}
	
	/**
	 * 往文本框内输入内容
	 * @param elementBy
	 * @param text
	 */
	public void writeText(By elementBy,String text) {
		waitVisibility(elementBy);
		
		driver.findElement(elementBy).sendKeys(text);
	}
	
	/**
	 * 读取文本框里面的内容
	 * @param elementBy
	 * @return
	 */
	public String readText(By elementBy) {
		waitVisibility(elementBy);
		
		return driver.findElement(elementBy).getText();
	}
	
	/**
	 * 断言
	 * @param elementBy
	 * @param expectedText
	 */
	public void assertEquals(By elementBy,String expectedText) {
		waitVisibility(elementBy);
		
		//判断实际结果与预期结果是否相同
		Assert.assertEquals(readText(elementBy), expectedText);
	}
	
}
