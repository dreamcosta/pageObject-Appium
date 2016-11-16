package com.qianmi.autotest.app.d2p.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * 我的订单页面
 *
 */
@Component
public class UserOrderPage extends NavigatorPage {
    /**
     * 检查订单中是否包含商品
     * @param productName 商品名称
     * @param productPrice 商品价格
     * @return 检查结果
     */
    public boolean vilifyOrder(String productName, String productPrice){
        return true;
    }

    /**
     * 取消订单按钮
     */

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"取消订单\")")
    private WebElement cancelButton;

    /**
     * 再次购买
     */
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"再次购买\")")
    private WebElement buyAgain;


    public UserOrderPage orderCancel(){

        WaitMobileElement(cancelButton).click();
        return this;
    }

    public CartPage buyAgain(){
        WaitMobileElement(buyAgain).click();
        return gotoPage(CartPage.class);
    }





}
