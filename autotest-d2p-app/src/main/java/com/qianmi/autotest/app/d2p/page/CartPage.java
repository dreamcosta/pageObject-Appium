package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * 购物车页面
 * Created by liuzhaoming on 16/9/26.
 */
@Component
public class CartPage extends BasePage {
    /**
     * 选择所有商品按钮
     */
    @FindBy(id = "shopping-cart:shop-checkbox-0-btn")
    private WebElement selectAllButton;

    /**
     * 去结算按钮
     */
    @FindBy(id = "shopping-cart:settle-up-btn")
    private WebElement settleUpButton;

    /**
     * 选择赠品按钮
     */
    @FindBy(id = "shopping-cart:choose-gift-btn")
    private WebElement selectGiftButton;

    /**
     * 第二个赠品按钮
     */
    @FindBy(id = "shopping-cart:choose-gift-1-radio")
    private WebElement secondGiftRadioButton;

    /**
     * 确认赠品按钮
     */
    @FindBy(id = "shopping-cart:choose-gift-confirm-btn")
    private WebElement confirmGiftButton;

    /**
     * 选择所有商品
     *
     * @return 购物车页面
     */
    public CartPage selectAllProduct() {
        settleUpButton.click();

        return this;
    }

    /**
     * 选择第二个赠品
     * @return 购物车页面
     */
    public CartPage selectSecondGift(){
        secondGiftRadioButton.click();

        return this;
    }

    /**
     * 支付订单,跳转到确认订单页面
     *
     * @return 确认订单页面
     */
    public ConfirmOrderPage pay() {
        settleUpButton.click();

        return gotoPage(ConfirmOrderPage.class);
    }
}
