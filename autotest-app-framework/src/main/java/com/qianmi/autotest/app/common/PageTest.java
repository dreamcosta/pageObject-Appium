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
import java.util.Properties;

/**
 * Test基类
 * Created by liuzhaoming on 16/9/23.
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
    public void login() {
        String userName = inputData.getProperty("userName");
        String password = inputData.getProperty("password");

        loginPage.login(userName, password);
    }
}
