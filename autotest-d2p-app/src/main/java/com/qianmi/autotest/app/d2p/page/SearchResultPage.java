package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 搜索结果页面
 * Created by liuzhaoming on 16/9/26.
 */
public class SearchResultPage extends BasePage {
    @FindBy(id = "goods-list:goods-name-0-btn")
    private WebElement exploreProductButton;

    /**
     * 浏览商品详情
     *
     * @return 商品详情页面
     */
    public ProductPage exploreProduct() {
        wait(exploreProductButton).click();
        return gotoPage(ProductPage.class);
    }
}
