package com.qianmi.autotest.app.common;

import com.qianmi.autotest.app.AutotestAppApplication;
import com.qianmi.autotest.app.page.AppLoginPage;
import com.qianmi.autotest.app.page.AppPageFacade;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Test基类
 *
 */
@SpringApplicationConfiguration(AutotestAppApplication.class)
public class PageTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected AppLoginPage loginPage;

    @Autowired
    protected AppPageFacade pageFacade;

    @Autowired
    protected AppiumDriver appiumDriver;

    @Autowired
    protected TouchAction touchAction;

    @Resource
    protected Properties inputData;

    @Resource
    protected Properties outputData;

    /**
     * 注销用户
     */
    @AfterMethod
    public void logout() {
        pageFacade.logout();
    }

    @BeforeMethod
    public void login(Method method) {
      AppLoginPage loginPage = BeanFactory.getBeanByType(AppLoginPage.class);
        //scene 实现某个场景下的特殊赋值

        String sceneName = CommonUtils.getSceneName(method);
        String userName = inputData.getProperty("userName");
        String password = inputData.getProperty("password");

        loginPage.login(userName, password);
    }
}
