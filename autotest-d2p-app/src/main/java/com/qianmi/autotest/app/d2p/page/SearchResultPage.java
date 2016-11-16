package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * 搜索结果页面
 *
 */
@Component
public class SearchResultPage extends BasePage {
    @AndroidFindBy(accessibility = "goods-list:goods-name-0-btn")
    private WebElement exploreProductButton;
    @AndroidFindBy(accessibility = "goods-category-list:back-btn")
    private  WebElement goodsListBackBtn;

    /**
     * 浏览商品详情
     *
     * @return 商品详情页面
     */
    public ProductPage exploreProduct() {
        WaitMobileElement(exploreProductButton).click();
        return gotoPage(ProductPage.class);
    }
    /**
     * 商品列表返回按钮
     *
     * @return 搜索页面
     */
    public SearchPage gotoSearchPage() {
        WaitMobileElement(goodsListBackBtn).click();
        return gotoPage(SearchPage.class);
    }

}
