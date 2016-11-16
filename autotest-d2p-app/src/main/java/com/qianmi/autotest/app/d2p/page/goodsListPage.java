package com.qianmi.autotest.app.d2p.page;

import com.qianmi.autotest.app.page.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component
public class goodsListPage extends BasePage {

    @AndroidFindBy(accessibility = "goods-category-list:back-btn")
    private WebElement listBtn;

     public CategoriesPage goBack() {
         WaitMobileElement(listBtn).click();

         return gotoPage(CategoriesPage.class);
     }

}
