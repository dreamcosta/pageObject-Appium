package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * 确认订单页面
 *
 */
@Component
public class ConfirmOrderPage extends BasePage {
    /**
     * 提交订单按钮
     */
    @AndroidFindBy(accessibility = "order-confirm:confirm-btn")
    private WebElement submitOrderButton;

    /**
     * 货到付款按钮
     */
    @AndroidFindBy(accessibility = "order-confirm:pay-type-1-radio")
    private WebElement payOnDeliveryButton;

    /**
     * 在线支付按钮
     */
    @AndroidFindBy(accessibility = "order-confirm:pay-type-0-radio")
    private WebElement onlinePayButton;

    /**
     * 开启积分按钮
     */
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[7]/android.widget.Switch[1]")
    private WebElement points;

    /**
     * 优惠券
     */
    @AndroidFindBy(accessibility = "order-confirm:coupon-btn")
    private WebElement coupon;


    /**
     * 提交订单
     *
     * @return 跳转到在线支付页面
     */
    public OnlinePayPage submitOrder() {
        WaitMobileElement(submitOrderButton).click();
        return gotoPage(OnlinePayPage.class);
    }

    /**
     * 货到付款方式提交订单
     *
     * @return 跳转到订单成功页面
     */
    public OrderSuccessPage submitOrderByOnDeliveryPay() {
        WaitMobileElement(submitOrderButton).click();
        return gotoPage(OrderSuccessPage.class);
    }

    /**
     * 选择支付方式为货到付款
     *
     * @return 订单确认页面
     */
    public ConfirmOrderPage selectPayOnDelivery() {
        WaitMobileElement(payOnDeliveryButton).click();

        return this;
    }

    /**
     * 选择支付方式为在线支付
     *
     * @return 订单确认页面
     */
    public ConfirmOrderPage selectPayOnline(){
        WaitMobileElement(onlinePayButton).click();
        return this;

    }

    /**
     * 开启积分

     */

    public ConfirmOrderPage clickPoints() {
        WaitMobileElement(points).click();
        return this;
    }
    /**
     * 选择优惠券

     */
    public CouponPage gotoCouponPage() {
        WaitMobileElement(coupon).click();
        return gotoPage(CouponPage.class);


    }

}
