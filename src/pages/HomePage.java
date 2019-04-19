package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 唤起浏览器，进入到知乎的首页，然后通过找到登录按钮，跳转到页面
 * @author Administrator
 *
 */
public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		// 少了下面这一句，会报空指针错误；
		this.driver = driver;
		System.out.println("HomePage构造方法");
	}
	
	String baseURL = "https://www.zhihu.com";
	
	//点击登录链接，跳转到登录页面
	By signInButtonBy = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[2]/span");
	
	public HomePage goToN11(){
		System.out.println("goToN11");

		driver.get(baseURL);
		
		System.out.println("url");
		
		return this;
	}
	
	public LoginPage goToLoginPage() {
		click(signInButtonBy);
		
		System.out.println("goToLoginPage");
		
		return new LoginPage(driver);
	}
}
