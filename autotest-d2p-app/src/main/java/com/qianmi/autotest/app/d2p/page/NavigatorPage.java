package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.common.Logoutable;
import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 带下方工具条页面
 *
 */
@Component
public abstract class NavigatorPage extends BasePage implements Logoutable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NavigatorPage.class);

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"首页\")")
    private WebElement homeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"我的\")")
    private WebElement userButton;

    @AndroidFindBy(accessibility = "user:info-btn")
    private WebElement myInfoButton;

    @AndroidFindBy(accessibility = "user-info:logout-btn")
    private WebElement logoutButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").text(\"确定\")")
    private WebElement confirmButton;

    /**
     * 退出登录,如果是未登录状态,则什么都不做
     */
    public void logout() {
        try {
            wait(userButton).click();
            wait(myInfoButton).click();
            wait(logoutButton).click();
            WaitMobileElement(confirmButton).click();
        } catch (Exception e) {
            LOGGER.warn("logout fail", e);
        }
    }

    /**
     * 前往APP主页
     *
     * @return APP主页
     */
    public HomePage gotoHomePage() {
        WaitMobileElement(homeButton).click();

        return gotoPage(HomePage.class);
    }
}
