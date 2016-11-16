package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.common.AutotestException;
import com.qianmi.autotest.app.common.Utilities;
import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class CategoriesPage extends BasePage {

    /**
     * 商品分类左侧返回按钮
     */
    @AndroidFindBy(accessibility = "goods-category:back-btn")
    private WebElement backButton;

    /**
     * 右侧二级分类
     */

    @AndroidFindBy(accessibility = "goods-category:second-cat-0-btn")
    private  WebElement secondCategory;
    /**
     * 获取页面上的一级的标题
     */

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"食品、饮料\")")
    private WebElement cateGoryName;

    /**
     * 点击商品分类页面上的返回按键
     */

    public HomePage categoryBack() {
        backButton.click();
        return gotoPage(HomePage.class);

    }

    /**
     * 点击右侧食品、饮料下的二级分类
     */

    public goodsListPage clickCategoried() {
        secondCategory.click();
        return gotoPage(goodsListPage.class);
    }

    /**
     * 校验分类名称
     *
     * @param cateName 分类名称

     */
    public CategoriesPage verifyProduct(String cateName) {
        String actualName = cateGoryName.getText();
        if (actualName.equals(cateName) ) {
            return this;
        }

        throw new AutotestException("The cateGory is invalid");
    }


}
