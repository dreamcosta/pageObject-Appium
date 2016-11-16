package com.qianmi.autotest.app.page;

import com.qianmi.autotest.app.common.BeanFactory;
import com.qianmi.autotest.app.common.Logoutable;
import org.springframework.stereotype.Component;

/**
 * APP页面门户
 *
 */
@Component
public class AppPageFacade extends BasePage {
    /**
     * 退出当前登录用户
     */
    public void logout() {
        Logoutable logoutable = BeanFactory.getBeanByType(Logoutable.class);
        logoutable.logout();
    }
}
