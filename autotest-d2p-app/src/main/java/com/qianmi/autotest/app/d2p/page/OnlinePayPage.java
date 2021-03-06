package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * 在线支付页面
 *
 */
@Component
public class OnlinePayPage extends BasePage {
    @AndroidFindBy(accessibility = "qm-header:back-btn")
    private WebElement backButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").text(\"确定\")")
    private WebElement confirmButton;

    /**
     * 退出在线支付页面,页面会跳转到我的订单页面
     *
     * @return 我的订单页面
     */
    public UserOrderPage
    back() {
        backButton.click();
        WaitMobileElement(confirmButton).click();

        return gotoPage(UserOrderPage.class);
    }
}
