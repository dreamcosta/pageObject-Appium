package com.qianmi.autotest.app.page;

import com.qianmi.autotest.app.AppiumDriverWait;
import com.qianmi.autotest.app.common.BeanFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * APP测试基类
 *
 */
public abstract class BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    @Autowired
    protected AppiumDriver driver;

    @Value("${config.loadTimeout}")
    private int loadTimeout = 5;

    @Value("${config.refreshRate}")
    private int refreshRate = 1;

    @Value("${config.waitTime}")
    private int pageWaitTime = 3;

    @Value("${config.swipeDuringMillTime}")
    private int swipeDuringMillTime = 1000;

    @Autowired
    protected TouchAction touchAction;

    /**
     * 页面跳转
     *
     * @param tClass Page Class
     * @param <T>    泛型
     * @return Page页面
     */
    public <T extends BasePage> T gotoPage(Class<T> tClass) {
        T page = BeanFactory.getBean(tClass);
        PageFactory.initElements(new AppiumFieldDecorator(driver), page);
        sleep();
        page.afterConstruct();
        return page;
    }

    /**
     * 初始化页面
     *
     * @param page page
     * @param <T>  泛型
     * @return 页面
     */
    protected <T extends BasePage> T initPage(T page) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), page);
        sleep();
        page.afterConstruct();
        return page;
    }

    /**
     * 线程阻塞,供页面渲染
     */
    protected void sleep() {
        sleep(pageWaitTime);
    }

    /**
     * 线程阻塞,供页面渲染
     */
    protected void sleep(int secTime) {
        if (secTime > 0) {
            try {
                Thread.sleep(secTime * 1000);
            } catch (InterruptedException e) {
                LOGGER.error("Page sleep fail", e);
            }
        }
    }

    /**
     * Page元素构造完成后需要执行的操作
     */
    protected void afterConstruct() {

    }

    /**
     * This Method for swipe Left
     *
     * @param during 滑动速度 等待多少毫秒
     */
    protected void swipeLeft(int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
    }


    /**
     * This Method for swipe up
     *
     * @param during 滑动速度 等待多少毫秒
     */
    protected void swipeUp(int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        // wait for page loading
    }

    /**
     * This Method for swipe down
     *
     * @param during 滑动速度 等待多少毫秒
     */
    protected void swipeDown(int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
        // wait for page loading
    }

//    /**
//     * This Method for swipe Left
//     */
//    protected void swipeLeft() {
//        swipeLeft(swipeDuringMillTime);
//    }


    /**
     * This Method for swipe up
     */
    protected void swipeUp() {
        swipeUp(swipeDuringMillTime);
    }

    /**
     * This Method for swipe down
     */
    protected void swipeToDown() {
        swipeDown(swipeDuringMillTime);
    }

    /**
     * 等待Page加载某个元素或者查询条件完成
     *
     * @param id 元素id
     * @return WebElement
     */
    protected WebElement wait(String id) {
        WebElement webElement = (new WebDriverWait(driver, pageWaitTime)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id(id));
            }
        });

        return webElement;
    }

    /**
     * 等待Page加载某个元素
     *
     * @param webElement 页面元素
     * @return WebElement
     */
    protected WebElement wait(WebElement webElement) {
        WebElement resultWebElement = (new WebDriverWait(driver, pageWaitTime)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                webElement.isDisplayed();
                return webElement;
            }
        });

        return resultWebElement;
    }

//    protected WebElement WaitMobileElement(final  String s) {
//        //wait for 60s if WebElemnt show up less than 60s , then return , until 60s
//        WebElement showClose = (new AppiumDriverWait(driver,pageWaitTime))
//                .until(new ExpectedCondition<WebElement>() {
//
//
//                    public WebElement apply(WebDriver webDriver) {
//                        return driver.findElementByAccessibilityId(s);
//                    }
//
//
//                });
//        return showClose;
//    }

    protected WebElement WaitMobileElement(WebElement webElement) {
        //wait for 60s if WebElemnt show up less than 60s , then return , until 60s
        WebElement showClose = (new AppiumDriverWait(driver,pageWaitTime))
                .until(new ExpectedCondition<WebElement>() {


                    public WebElement apply(WebDriver webDriver) {
                        webElement.isDisplayed();
                        return webElement;
                    }


                });
        return showClose;
    }


    /**
     * 判断Page 元素是否存在
     *
     * @param webElement Page元素
     * @return boolean
     */
    protected boolean isExist(WebElement webElement) {
        if (null == webElement) {
            return false;
        }

        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
