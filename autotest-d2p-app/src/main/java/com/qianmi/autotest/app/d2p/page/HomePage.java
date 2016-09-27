package com.qianmi.autotest.app.d2p.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * D2P APP 主页
 * Created by liuzhaoming on 16/9/26.
 */
public class HomePage extends NavigatorPage  {
    @FindBy(id = "guide:image")
    private WebElement guideSwap;

    @FindBy(id = "overlay-search:search-btn")
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
