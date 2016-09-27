package com.qianmi.autotest.app.page;

/**
 * APP登录页面
 * Created by liuzhaoming on 16/9/26.
 */
public abstract class AppLoginPage extends BasePage{
    /**
     * 登录并跳转到首页
     *
     * @param username 用户名
     * @param password 密码
     * @return APP首页
     */
    public abstract AppPageFacade login(String username, String password);
}
