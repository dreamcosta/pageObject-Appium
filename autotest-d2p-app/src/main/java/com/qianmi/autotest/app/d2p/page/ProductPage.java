package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.common.AutotestException;
import com.qianmi.autotest.app.common.CommonUtils;
import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * 商品详情页面
 *
 */
@Component
public class ProductPage extends BasePage {
    @AndroidFindBy(accessibility = "goods-detail:name-text")
    private WebElement nameText;

    @AndroidFindBy(accessibility = "goods-detail:level-price-text")
    private WebElement priceText;

    @AndroidFindBy(accessibility = "goods-detail:buy-num-plus-btn")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "goods-detail:shopping-cart-btn")
    private WebElement cartButton;

    @AndroidFindBy(accessibility = "goods-detail:back-btn")
    private WebElement detailBackBtn;

    @AndroidFindBy(accessibility = "goods-detail:favorite-btn")
    private WebElement favoriteBtn;

    /**
     * 校验商品信息
     *
     * @param name  商品名称
     * @param price 商品价格
     * @return 商品详情页面
     */
    public ProductPage verifyProduct(String name, String price) {
        String actualName = nameText.getText();
        String actualPrice = CommonUtils.getPriceStr(priceText.getText());

        if (actualName.equals(name) && CommonUtils.getPriceStr(actualPrice).equals(price)) {
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
        WaitMobileElement(addToCartButton).click();

        return this;
    }

    /**
     * 跳转到购物车页面
     *
     * @return 购物车页面
     */
    public CartPage gotoCartPage() {
        WaitMobileElement(cartButton).click();

        return gotoPage(CartPage.class);
    }
    /**
     * 跳转到搜索结果页面上
     *
     * @return 搜索结果页面
     */
    public SearchResultPage gotoSearchResultPage() {
        WaitMobileElement(detailBackBtn).click();
        return gotoPage(SearchResultPage.class);
    }

    public ProductPage clickFavoriteBtn() {
        WaitMobileElement(favoriteBtn).click();
        return this;

    }

}
