package com.qianmi.autotest.app.d2p.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component
public class HomePage extends NavigatorPage {

    @AndroidFindBy(accessibility = "overlay-search:search-btn")
    private WebElement searchButton;

    @AndroidFindBy(accessibility = "function-nav:all-cats-btn")
    private  WebElement categories;

    /**
     * 页面跳转到搜索页面Page
     *
     * @return 搜索页面
     */
    public SearchPage gotoSearchPage() {
        WaitMobileElement(searchButton).click();

        return gotoPage(SearchPage.class);

    }

    /**
     * 页面跳转到分类页面Page
     *
     * @return 分类页面
     */

    public CategoriesPage gotoCategoriesPage() {
        categories.click();
        return gotoPage(CategoriesPage.class);
    }
}
