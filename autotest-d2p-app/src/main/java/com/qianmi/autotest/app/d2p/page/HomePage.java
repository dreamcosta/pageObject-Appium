package com.qianmi.autotest.app.d2p.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * D2P APP 主页
 * Created by liuzhaoming on 16/9/26.
 */
@Component
public class HomePage extends NavigatorPage {
    @AndroidFindBy(accessibility = "guide:image")
    private WebElement guideSwap;

    @AndroidFindBy(accessibility = "overlay-search:search-btn")
    private WebElement searchButton;

    /**
     * 页面跳转到搜索页面Page
     *
     * @return 搜索页面
     */
    public SearchPage gotoSearchPage() {
        searchButton.click();


        return gotoPage(SearchPage.class);
    }

}
