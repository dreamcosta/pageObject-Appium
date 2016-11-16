package com.qianmi.autotest.app;

import com.qianmi.autotest.app.common.AppProperties;
import com.qianmi.autotest.app.common.AutotestException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.net.URL;
import java.util.Properties;

/**
 * APP自动化测试主程序入口
 *
 */
@SpringBootApplication
@ComponentScan("com.qianmi.autotest")
public class AutotestAppApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppProperties.class);

    @Value("${appUrl}")
    private String appUrl;

    @Autowired
    private AppiumDriver driver;

    @Resource
    private Properties driverConfig;

    @Bean
    public AppiumDriver getAppiumDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (String name : driverConfig.stringPropertyNames()) {
            setCapabilities(name, driverConfig.getProperty(name), capabilities);
        }

        try {
            if (driverConfig.getProperty("platformName", "Android").equals("Ios")) {
                return new IOSDriver(new URL(appUrl), capabilities);
            } else {
                return new AndroidDriver(new URL(appUrl), capabilities);
            }
        } catch (Exception e) {
            LOGGER.error("Create appium driver fail", e);
            throw new AutotestException("Create appium driver fail");
        }
    }

    @Bean
    @Autowired
    public TouchAction getTouchAction(AppiumDriver driver) {
        return new TouchAction(driver);
    }

    /**
     * 设置配置属性
     *
     * @param name         属性名称
     * @param value        属性值
     * @param capabilities 配置容器
     */
    private void setCapabilities(String name, String value, DesiredCapabilities capabilities) {
        if (null == value) {
            return;
        }

        capabilities.setCapability(name, value);
    }

    @PreDestroy
    public void closeDriver() {
        if (null != driver) {
           // driver.closeApp();
            driver.quit();
        }
    }
}
