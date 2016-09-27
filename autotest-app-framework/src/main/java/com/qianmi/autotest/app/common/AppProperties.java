package com.qianmi.autotest.app.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Bean容器, 主要配置框架使用的Bean对象
 * Created by liuzhaoming on 16/9/27.
 */
@ConfigurationProperties
@Data
@Component
public class AppProperties {
    private Properties driver;

    @Bean
    public Properties driverConfig() {
        return driver;
    }
}

