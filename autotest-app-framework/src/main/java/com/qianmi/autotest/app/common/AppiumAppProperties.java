package com.qianmi.autotest.app.common;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * Appium 程序配置参数
 * Created by liuzhaoming on 2016/12/6.
 */
@Data
public class AppiumAppProperties {
    /**
     * driver配置属性
     */
    protected Properties driver;
    /**
     * device配置属性
     */
    protected Properties device;
    /**
     * devices名称
     */
    protected String deviceName;
    /**
     * 默认device名称
     */
    @Value("${device.default}")
    protected String defaultDeviceName;

    @Bean
    public String _deviceName() {
        return System.getProperty("deviceName", defaultDeviceName);
    }

    @Bean
    public Properties deviceConfig() {
        if (StringUtils.isBlank(deviceName)) {
            deviceName = defaultDeviceName;
        }

        Properties totalDeviceProperties = new Properties();
        String deviceNamePrefix = deviceName + ".";
        device.stringPropertyNames().stream().filter(propertyName -> propertyName.startsWith(deviceNamePrefix))
                .forEach(propertyName ->
                        totalDeviceProperties.setProperty(propertyName.substring(deviceNamePrefix.length()),
                                device.getProperty(propertyName))
                );
        return totalDeviceProperties;
    }

    @Bean
    public Properties driverConfig() {
        if (StringUtils.isBlank(deviceName)) {
            deviceName = defaultDeviceName;
        }

        Properties totalDriverProperties = new Properties(driver);
        String deviceNamePrefix = deviceName + ".driver.";
        device.stringPropertyNames().stream().filter(propertyName -> propertyName.startsWith(deviceNamePrefix))
                .forEach(propertyName ->
                        totalDriverProperties.setProperty(propertyName.substring(deviceNamePrefix.length()),
                                device.getProperty(propertyName))
                );
        return totalDriverProperties;
    }
}
