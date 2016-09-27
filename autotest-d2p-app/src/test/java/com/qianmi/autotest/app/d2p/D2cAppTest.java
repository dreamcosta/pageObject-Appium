package com.qianmi.autotest.app.d2p;

import com.qianmi.autotest.app.common.PageTest;
import com.qianmi.autotest.app.d2p.page.HomePage;
import com.qianmi.autotest.app.d2p.page.SearchPage;
import com.qianmi.autotest.app.d2p.page.SearchResultPage;
import com.qianmi.autotest.app.d2p.page.UserOrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * D2P APP 测试类
 * Created by liuzhaoming on 16/9/27.
 */
public class D2cAppTest extends PageTest {
    /**
     * 下单不参加任何营销活动
     * 步骤:2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单去结算6)提交订单7)订单列表搜索订单
     */
    @Test
    public void testBuy() {
        String productName = inputData.getProperty("productName1");
        String price = inputData.getProperty("productPrice1");

        UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName, price).addToCart().gotoCartPage()
                .selectAllProduct().pay()
                .submitOrder()
                .back();

        Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));
    }

    /**
     * 下单参加满赠活动，支付方式货到付款
     * 2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单选择赠品6)采购单去结算7)提交订单页支付方式选择货到付款8)订单列表搜索订单9)
     */
    @Test(priority = 1)
    public void testBuyWithGiftAndPayOnDelivery() {
        String productName = inputData.getProperty("productName2");
        String price = inputData.getProperty("productPrice2");

        UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName, price).addToCart().gotoCartPage()
                .selectAllProduct().selectSecondGift().pay()
                .selectPayOnDelivery().submitOrder()
                .back();
        
        Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));
    }
}
