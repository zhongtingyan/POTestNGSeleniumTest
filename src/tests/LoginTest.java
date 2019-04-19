package tests;

import org.testng.annotations.Test;

import pages.HomePage;

/**
 * 针对知乎登录写的具体测试用例
 * 
 * @author Administrator
 *
 */
public class LoginTest extends BaseTest {
	
	/**
	 * 用例一：
	 * 	使用错误的账号和密码进行登录
	 */
	@Test
	public void invalidLoginTest_InvalidUserNameInvalidPassword() {
		HomePage  homepage = new HomePage(driver);
		
		homepage.goToN11().goToLoginPage().loginToZhihu("email@qq.com", "password").verifyLoginPassword("账号或密码错误");
	}
	
	/**
	 * 用例二：
	 * 	用户名和密码均为空
	 */
	//@Test
	public void invalidLoginTest_EmptyUsernameAndPassword() {
		HomePage homepage = new HomePage(driver);
		
		System.out.println("输入空值");
		
		homepage.goToN11().goToLoginPage().loginToZhihu("", "").verifyLoginUserName("请输入手机号或邮箱").verifyLoginPassword("请输入密码");
	}
}
