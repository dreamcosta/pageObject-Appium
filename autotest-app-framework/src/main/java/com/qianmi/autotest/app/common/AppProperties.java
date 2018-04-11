package com.qianmi.autotest.app.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 配置文件,主要是处理框架的配置信息
 * Created by liuzhaoming on 16/9/27.
 */
@ConfigurationProperties
@Data
@Component
public class AppProperties extends AppiumAppProperties {

    /**
     * 默认的APP文件
     */
    @Value("${driver.app}")
    private String defaultAppfile;

    @Bean
    public String _appfile() {
        return System.getProperty("appfile", defaultAppfile);
    }
}

