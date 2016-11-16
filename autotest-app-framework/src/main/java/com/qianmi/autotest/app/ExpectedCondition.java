package com.qianmi.autotest.app;

import com.google.common.base.Function;
import io.appium.java_client.AppiumDriver;

/**
 *
 */
public interface ExpectedCondition<T> extends Function<AppiumDriver, T> {}

