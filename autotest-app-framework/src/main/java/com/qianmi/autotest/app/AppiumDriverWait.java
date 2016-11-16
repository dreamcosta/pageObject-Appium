package com.qianmi.autotest.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 */
public class AppiumDriverWait extends FluentWait<AppiumDriver> {
    public final static long DEFAULT_SLEEP_TIMEOUT = 500;
    private final WebDriver driver;

    public AppiumDriverWait(AppiumDriver driver, long timeOutInSeconds) {
          this(driver, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
    }

    public AppiumDriverWait(AppiumDriver driver, long timeOutInSeconds, long sleepInMillis) {
            this(driver, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, sleepInMillis);
           }

    public AppiumDriverWait(AppiumDriver driver, Clock clock, Sleeper sleeper, long timeOutInSeconds,
                            long sleepTimeOut) {
             super(driver, clock, sleeper);
             withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
             pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
             ignoring(NotFoundException.class);
             this.driver = driver;
           }

    @Override
       protected RuntimeException timeoutException(String message, Throwable lastException) {
             TimeoutException ex = new TimeoutException(message, lastException);
            ex.addInfo(WebDriverException.DRIVER_INFO, driver.getClass().getName());
             if (driver instanceof RemoteWebDriver) {
                   RemoteWebDriver remote = (RemoteWebDriver) driver;
                   if (remote.getSessionId() != null) {
                         ex.addInfo(WebDriverException.SESSION_ID, remote.getSessionId().toString());
                       }
                   if (remote.getCapabilities() != null) {
                         ex.addInfo("Capabilities", remote.getCapabilities().toString());
                      }
                 }
             throw ex;
           }

}
