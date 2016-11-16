package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * 搜索输入框页面
 *
 */
@Component
public class SearchPage extends BasePage {
    @AndroidFindBy(accessibility = "goods-search:query-text")
    private WebElement queryStringField;

    @AndroidFindBy(accessibility = "goods-search:query-btn")
    private WebElement searchButton;

    @AndroidFindBy(accessibility = "goods-search:back-btn")
    private WebElement searchBackBtn;

    /**
     * 搜索商品
     *
     * @param queryString 关键词
     * @return 搜索结果页面Page
     */
    public SearchResultPage search(String queryString) {
        queryStringField.sendKeys(queryString);
        WaitMobileElement(searchButton).click();

        return gotoPage(SearchResultPage.class);
    }
    /**
     * 返回到搜索页面
     *
     * @return 首页
     */
    public HomePage gotoHomePage() {
        WaitMobileElement(searchBackBtn).click();
        return gotoPage(HomePage.class);
    }

}
