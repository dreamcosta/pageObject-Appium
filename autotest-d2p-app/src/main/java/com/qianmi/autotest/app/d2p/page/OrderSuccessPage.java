package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * 订单提交成功页面
 * Created by liuzhaoming on 16/9/27.
 */
@Component
public class OrderSuccessPage extends BasePage {
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"订单列表\")")
    private WebElement orderListButton;

    /**
     * 跳转到订单列表页面
     *
     * @return 订单列表页面
     */
    public UserOrderPage gotoOrderListPage() {
        orderListButton.click();

        return gotoPage(UserOrderPage.class);
    }
}
