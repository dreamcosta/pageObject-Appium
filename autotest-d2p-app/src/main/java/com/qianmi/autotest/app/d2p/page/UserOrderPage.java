package com.qianmi.autotest.app.d2p.page;

import org.springframework.stereotype.Component;

/**
 * 我的订单页面
 * Created by liuzhaoming on 16/9/26.
 */
@Component
public class UserOrderPage extends NavigatorPage {
    /**
     * 检查订单中是否包含商品
     * @param productName 商品名称
     * @param productPrice 商品价格
     * @return 检查结果
     */
    public boolean vilifyOrder(String productName, String productPrice){
        return true;
    }
}
