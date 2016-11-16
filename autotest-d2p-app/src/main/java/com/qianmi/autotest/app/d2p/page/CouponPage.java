package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class CouponPage extends BasePage {

    @AndroidFindBy(accessibility ="coupon-use-list:coupon-0-radio")

    private WebElement selectCoupon;

    @AndroidFindBy(accessibility = "coupon-use-list:save-btn")
    private WebElement couponSave;


    /**
     * 选择优惠券
     *
     */
    public ConfirmOrderPage clickCouponSave() {
        WaitMobileElement(couponSave).click();
        return gotoPage(ConfirmOrderPage.class);
    }

    public CouponPage selectCoupon2(){
        WaitMobileElement(selectCoupon).click();
        return this;

    }
}
