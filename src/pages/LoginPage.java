package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 找到账号和密码元素所在的位置，然后进行填充
 * @author Administrator
 *
 */
public class LoginPage extends BasePage {
	
	By usernameBy = By.name("username");
	
	By passwordBy = By.name("password");
	
	//By captcha = By.name("captcha");//图形验证码
	
	//By loginButtonBy = By.className("SignFlow-submitButton");
	By loginButtonBy = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[1]/form/button");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 使用用户名和密码登录知乎
	 * @param username
	 * @param password
	 * @return
	 */
	public LoginPage loginToZhihu(String username,String password) {
		writeText(usernameBy, username);
		
		writeText(passwordBy, password);
		
		// 点击登录按钮
		click(loginButtonBy);
		
		return this;
	}
	
	public LoginPage verifyLoginUserName(String expectedText) {
		By errorMessageUsernameBy = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div[2]");
		
		assertEquals(errorMessageUsernameBy, expectedText);
		
		return this;
	}
	
	/**
	 * errorMessagePasswordBy：表示的是实际结果
	 * @param expectedText：表示预期结果
	 * @return
	 */
	public LoginPage verifyLoginPassword(String expectedText) {
		
		By errorMessagePasswordBy = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]");
		
		assertEquals(errorMessagePasswordBy, expectedText);
		
		return this;
	}
}
