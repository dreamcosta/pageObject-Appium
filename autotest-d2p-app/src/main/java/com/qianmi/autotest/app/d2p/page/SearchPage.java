package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * 搜索输入框页面
 * Created by liuzhaoming on 16/9/26.
 */
@Component
public class SearchPage extends BasePage {
    @FindBy(id = "goods-search:query-text")
    private WebElement queryStringField;

    @FindBy(id = "goods-search:query-btn")
    private WebElement searchButton;

    /**
     * 搜索商品
     *
     * @param queryString 关键词
     * @return 搜索结果页面Page
     */
    public SearchResultPage search(String queryString) {
        queryStringField.sendKeys(queryString);
        searchButton.click();

        return gotoPage(SearchResultPage.class);
    }
}
