package com.qianmi.autotest.app.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 测试数据
 * Created by liuzhaoming on 16/9/27.
 */
@ConfigurationProperties(locations = "classpath:data.properties")
@Data
@Component
public class AutoTestData {
    private Properties input;

    private Properties output;

    @Bean
    public Properties inputData() {
        return input;
    }

    @Bean
    public Properties outputData() {
        return output;
    }
}
