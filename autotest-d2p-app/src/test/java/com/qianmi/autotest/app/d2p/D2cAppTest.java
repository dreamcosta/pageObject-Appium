package com.qianmi.autotest.app.d2p;

import com.qianmi.autotest.app.common.PageTest;
import com.qianmi.autotest.app.d2p.page.HomePage;
import com.qianmi.autotest.app.d2p.page.UserOrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * D2P APP 测试用例
 * 
 */

public class D2cAppTest extends PageTest {

    /**
     * 场景5:下单不参加任何营销活动
     * 步骤:2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单去结算6)提交订单7)订单列表搜索订单
     */
    @Test(priority = 0)
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
     * 场景6:下单参加满赠活动，支付方式货到付款
     * 2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单选择赠品6)采购单去结算7)提交订单页支付方式选择货到付款8)订单列表搜索订单9)
     */
    @Test
    public void testBuyWithGiftAndPayOnDelivery() {
        String productName = inputData.getProperty("productName2");
        String price = inputData.getProperty("productPrice2");

        UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName, price).addToCart().gotoCartPage()
                .selectAllProduct().selectSecondGift().pay()
                .selectPayOnDelivery().submitOrderByOnDeliveryPay()
                .gotoOrderListPage();

        Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));

    }

    /**
     * 场景2:查看分类
     步骤:1)用户登录2)查看分类3)返回2次4)用户退出

     */

    @Test()
    public void CategoriesTest() {
        try {
            String cateName = inputData.getProperty("cateName");


            HomePage homePage = pageFacade.gotoPage(HomePage.class)
                    .gotoCategoriesPage()
                    .verifyProduct(cateName)
                    .clickCategoried()
                    .goBack()
                    .categoryBack();
            logger.info(cateName);
            logger.info("查看分类运行完毕");
        }
        catch (Exception e) {
            logger.debug(e, e);
            logger.error(e, e);
        }

    }

    /**
     * 场景7:下单参加满减活动，支付方式在线支付
     步骤:1)用户登录2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单去结算6)提交订单页支付方式选择在线支付7)订单列表搜索订单8)用户退出
     */

    @Test
    public void testBuywithDiscount() {
        String productName = inputData.getProperty("productName3");
        String price = inputData.getProperty("productPrice3");

        UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName,price)
                .addToCart()
                .gotoCartPage()
                .selectAllProduct()
                .pay()
                .selectPayOnline()
                .submitOrder()
                .back();
        Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));

    }


    /**
     * 场景3:查看商品详情
     步骤:1)用户登录2)搜索商品3)查看商品详情4)返回3次5)用户退出

     */

    @Test
    public void productDetail() {
        String productName = inputData.getProperty("productName1");
        String price = inputData.getProperty("productPrice1");

        HomePage homePage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName,price)
                .gotoSearchResultPage()
                .gotoSearchPage()
                .gotoHomePage();

    }
    /**
     场景4:商品加入收藏夹
     步骤:1)用户登录2)搜索商品3)查看商品详情4)收藏5)返回3次6)用户退出
     */
    @Test
    public void productFavorites() {
        String productName = inputData.getProperty("productName1");
        String price = inputData.getProperty("productPrice1");

        HomePage homePage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName,price)
                .clickFavoriteBtn()
                .gotoSearchResultPage()
                .gotoSearchPage()
                .gotoHomePage();
    }

    /**
     场景8:下单使用积分
     步骤:1)用户登录2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单去结算6)提交订单页使用积分7)订单列表搜索订单8)用户退出
     */
    @Test
    public void testBuyWithPoints() {
        String productName = inputData.getProperty("productName1");
        String price = inputData.getProperty("productPrice1");

        UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName,price)
                .addToCart()
                .gotoCartPage()
                .selectAllProduct()
                .pay()
                .clickPoints()
                .submitOrder()
                .back();

        Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));
    }

    /**
     场景9:下单使用优惠券
     步骤:1)用户登录2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单去结算6)提交订单页使用优惠券7)订单列表搜索订单8)用户退出

     */
    @Test
    public void testBuyWithCoupon() {
        String productName = inputData.getProperty("productName3");
        String price = inputData.getProperty("productPrice3");

        UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName,price)
                .addToCart()
                .gotoCartPage()
                .selectAllProduct()
                .pay()
                .gotoCouponPage()
                .selectCoupon2()
                .clickCouponSave()
                .submitOrder()
                .back();

        Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));
    }


    /**
     场景10:取消订单
     步骤: 1)用户登录2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单去结算6)提交订单7)订单列表搜索订单8)取消订单9)用户退出
     */

    @Test
    public void OrderCancel() {
        String productName = inputData.getProperty("productName1");
        String price = inputData.getProperty("productPrice1");

        UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName,price)
                .addToCart()
                .gotoCartPage()
                .selectAllProduct()
                .pay()
                .submitOrder()
                .back()
                .orderCancel();

        Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));

    }
   /**
    * 场景11:再次购买
    步骤: 1)用户登录2)搜索商品3)查看商品详情4)加入采购单5) 进入采购单去结算6)提交订单7)订单列表搜索订单8)再次购买9)订单列表搜索订单10)用户退出

    * */

   @Test
   public void BuyAgain() {
       String productName = inputData.getProperty("productName1");
       String price = inputData.getProperty("productPrice1");

       UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
               .gotoSearchPage()
               .search(productName)
               .exploreProduct()
               .verifyProduct(productName,price)
               .addToCart()
               .gotoCartPage()
               .selectAllProduct()
               .pay()
               .submitOrder()
               .back()
               .buyAgain()
               .selectAllProduct()
               .pay().submitOrder()
               .back();

       Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));
   }

    /**
     *场景12:店铺商品下单
     步骤: 1)用户登录2)搜索商品3)查看商品详情4)加入采购单5)进入采购单去结算6)提交订单7)订单列表搜索订单8)用户退出

     * */
       @Test
       public void shopOrder() {
       String productName = inputData.getProperty("productName4");
       String price = inputData.getProperty("productPrice4");

       UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
               .gotoSearchPage()
               .search(productName)
               .exploreProduct()
               .verifyProduct(productName, price)
               .addToCart()
               .gotoCartPage()
               .selectAllProduct()
               .pay()
               .submitOrder()
               .back();
       Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));
   }

    /**
     *场景13:店铺和自营商品下单
     步骤: 1)用户登录2)搜索店铺商品3)查看商品详情4)加入采购单5) 返回
     6)搜索自营商品7)查看商品详情8)加入采购单9)进入采购单去结算10)提交订单11)订单列表搜索订单12)用户退出
     *
     * */
    @Test
    public void shopAndSelfOrder() {
        String productName = inputData.getProperty("productName1");
        String price = inputData.getProperty("productPrice1");
        String ShopProduct = inputData.getProperty("productName4");

        UserOrderPage userOrderPage = pageFacade.gotoPage(HomePage.class)
                .gotoSearchPage()
                .search(productName)
                .exploreProduct()
                .verifyProduct(productName, price)
                .addToCart()
                .gotoSearchResultPage()
                .gotoSearchPage()
                .gotoHomePage()
                .gotoSearchPage()
                .search(ShopProduct)
                .exploreProduct()
                .addToCart()
                .gotoCartPage()
                .selectAllProduct()
                .pay()
                .submitOrder()
                .back();

        Assert.assertTrue(userOrderPage.vilifyOrder(productName, price));
    }


}
