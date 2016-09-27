package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * 搜索结果页面
 * Created by liuzhaoming on 16/9/26.
 */
@Component
public class SearchResultPage extends BasePage {
    @AndroidFindBy(accessibility = "goods-list:goods-name-0-btn")
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
