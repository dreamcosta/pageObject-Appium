package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * 确认订单页面
 * Created by liuzhaoming on 16/9/26.
 */
@Component
public class ConfirmOrderPage extends BasePage {
    /**
     * 提交订单按钮
     */
    @FindBy(id="order-confirm:confirm-btn")
    private WebElement submitOrderButton;

    /**
     * 货到付款按钮
     */
    @FindBy(id="order-confirm:pay-type-1-radio")
    private WebElement payOnDeliveryButton;

    /**
     * 在线支付按钮
     */
    @FindBy(id="order-confirm:pay-type-0-radio")
    private WebElement onlinePayButton;

    /**
     * 提交订单
     * @return 跳转到在线支付页面
     */
    public OnlinePayPage submitOrder(){
        submitOrderButton.click();
        return gotoPage(OnlinePayPage.class);
    }

    /**
     * 选择支付方式为货到付款
     * @return 订单确认页面
     */
    public ConfirmOrderPage selectPayOnDelivery(){
        payOnDeliveryButton.click();

        return this;
    }
}
