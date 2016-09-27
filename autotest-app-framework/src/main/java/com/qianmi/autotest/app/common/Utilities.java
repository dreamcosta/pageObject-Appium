package com.qianmi.autotest.app.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

/**
 * 通用工具类
 * Created by liuzhaoming on 16/9/27.
 */
public final class Utilities {
    private Utilities() {
    }

    /**
     * 获取价格
     *
     * @param priceStr 价格字符串,格式为'￥30'
     * @return 价格 数值类型
     */
    public static BigDecimal getPrice(String priceStr) {
        if (StringUtils.isBlank(priceStr)) {
            return BigDecimal.ZERO;
        }

        String formatStr = StringUtils.strip("￥ ");
        return BigDecimal.valueOf(NumberUtils.toDouble(formatStr, 0d));
    }

    /**
     * 比较两个商品价格字符串
     *
     * @param priceStr1 价格字符串,格式为'￥30'
     * @param priceStr2 价格字符串,格式为'￥30'
     * @return boolean
     */
    public static boolean comparePrice(String priceStr1, String priceStr2) {
        BigDecimal price1 = getPrice(priceStr1);
        BigDecimal price2 = getPrice(priceStr2);

        return price1.equals(price2);
    }
}
