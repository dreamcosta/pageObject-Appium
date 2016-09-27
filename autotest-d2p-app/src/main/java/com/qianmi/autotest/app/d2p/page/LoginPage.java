package com.qianmi.autotest.app.d2p.page;


import com.qianmi.autotest.app.page.AppLoginPage;
import com.qianmi.autotest.app.page.AppPageFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

/**
 * D2P APP登录页面
 * Created by liuzhaoming on 16/9/26.
 */
@Component
public class LoginPage extends AppLoginPage {
    @FindBy(name = "guide:image")
    private WebElement guideSwap;

    @FindBy(name = "guide:login-btn")
    private WebElement experienceeButton;

    @FindBy(name = "login:user-name-text")
    private WebElement usernameField;

    @FindBy(name = "login:user-password-text")
    private WebElement passwordField;

    @FindBy(name = "login:login-btn")
    private WebElement submitButton;


    /**
     * 登录并跳转到首页
     *
     * @param username 用户名
     * @param password 密码
     * @return APP首页
     */
    @Override
    public AppPageFacade login(String username, String password) {
        initPage(this);
        wait(usernameField).sendKeys(username);
        wait(passwordField).sendKeys(password);
        wait(submitButton).click();

        return gotoPage(AppPageFacade.class);
    }

    /**
     * Page元素构造完成后需要执行的操作
     */
    @Override
    protected void afterConstruct() {
        touchAction.press(guideSwap).perform();
        IntStream.range(0, 3).forEach(item -> swipeLeft());

        wait(experienceeButton).click();
    }
}
