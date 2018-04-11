package com.qianmi.autotest.app.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * 通用工具类
 * Created by liuzhaoming on 16/9/27.
 */
public final class CommonUtils {
    private CommonUtils() {
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

        String formatStr = StringUtils.strip(priceStr, "￥ ");
        return BigDecimal.valueOf(NumberUtils.toDouble(formatStr, 0d));
    }

    /**
     * 获取价格
     *
     * @param priceStr 价格字符串,格式为'￥30'
     * @return 价格 数值类型字符串
     */
    public static String getPriceStr(String priceStr) {
        if (StringUtils.isBlank(priceStr)) {
            return "";
        }

        return StringUtils.strip(priceStr, "￥ ");
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

    /**
     * 获取 webelement的描述信息
     *
     * @param webElement webElement
     * @return 字符串描述信息
     */
    public static String getWebElementDesc(WebElement webElement) {
        StringBuilder sb = new StringBuilder("WebElement[");
        try {
            sb.append("class=");
            sb.append(webElement.getClass().toString());
            sb.append(" ,tag=");
            sb.append(webElement.getTagName());
            sb.append(" ,text=");
            sb.append(webElement.getText());
            sb.append(" ,location=");
            sb.append(webElement.getLocation());
        } catch (Exception e) {
        }

        sb.append("]");

        return sb.toString();
    }

    /**
     * 线程sleep
     *
     * @param timeInMills 毫秒值
     */
    public static void sleep(long timeInMills) {
        try {
            Thread.sleep(timeInMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取测试方法的测试场景
     *
     * @param method 测试方法
     * @return 测试场景
     */
    public static Scene getScene(Method method) {
        Scene scene = method.getAnnotation(Scene.class);
        if (null != scene) {
            return scene;
        }

        Class methodClass = method.getDeclaringClass();
        return (Scene) methodClass.getAnnotation(Scene.class);
    }

    /**
     * 获取方法测试场景名称
     *
     * @param method 测试方法
     * @return 测试场景
     */
    public static String getSceneName(Method method) {
        Scene scene = getScene(method);
        if (null != scene) {
            return scene.value();
        }

        return "";
    }

    /**
     * 获取测试方法的测试模块
     *
     * @param method 测试方法
     * @return 测试模块
     */
    public static Module getModule(Method method) {
        Module module = method.getAnnotation(Module.class);
        if (null != module) {
            return module;
        }

        Class methodClass = method.getDeclaringClass();
        return (Module) methodClass.getAnnotation(Module.class);
    }

    /**
     * 获取方法测试模块名称
     *
     * @param method 测试方法
     * @return 测试模块
     */
    public static String getModuleName(Method method) {
        Module module = getModule(method);
        if (null != module) {
            return module.value();
        }

        return "";
    }
}
