package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.common.AutotestException;
import com.qianmi.autotest.app.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * 商品详情页面
 * Created by liuzhaoming on 16/9/26.
 */
@Component
public class ProductPage extends BasePage {
    @FindBy(id = "goods-detail:name-text")
    private WebElement nameText;

    @FindBy(id = "goods-detail:level-price-text")
    private WebElement priceText;

    @FindBy(id = "goods-detail:buy-num-plus-btn")
    private WebElement addToCartButton;

    @FindBy(id = "goods-detail:shopping-cart-btn")
    private WebElement cartButton;

    /**
     * 校验商品信息
     *
     * @param name  商品名称
     * @param price 商品价格
     * @return 商品详情页面
     */
    public ProductPage verifyProduct(String name, String price) {
        String actualName = nameText.getText();
        String actualPrice = priceText.getText();

        if (actualName.equals(name) && actualPrice.equals(price)) {
            return this;
        }

        throw new AutotestException("The product is invalid");
    }

    /**
     * 添加商品到购物车
     *
     * @return 返回商品详情页面
     */
    public ProductPage addToCart() {
        addToCartButton.click();

        return this;
    }

    /**
     * 跳转到购物车页面
     * @return 购物车页面
     */
    public CartPage gotoCartPage() {
        cartButton.click();

        return gotoPage(CartPage.class);
    }
}
