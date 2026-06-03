package com.amalw.waits;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amalw.driver.DriverFactory;
import com.amalw.exceptions.FrameworkException;

public final class WaitManager {

    private static final int DEFAULT_TIMEOUT = 15;
    private static final int POLLING_INTERVAL = 500;

    private WaitManager() {
    }

    public static WebElement waitForVisibility(By locator) {
        return waitForVisibility(locator, DEFAULT_TIMEOUT);
    }

    public static WebElement waitForVisibility(By locator, int timeout) {

        try {

            WebDriverWait wait =
                    new WebDriverWait(
                            DriverFactory.getDriver(),
                            Duration.ofSeconds(timeout));

            wait.pollingEvery(Duration.ofMillis(POLLING_INTERVAL));

            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(StaleElementReferenceException.class);

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (TimeoutException e) {

            throw new FrameworkException(
                    "Element not visible: " + locator,
                    e);
        }
    }

    public static WebElement waitForClickable(By locator, int timeout) {

        try {

            return new WebDriverWait(
                    DriverFactory.getDriver(),
                    Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.elementToBeClickable(locator));

        } catch (TimeoutException e) {

            throw new FrameworkException(
                    "Element not clickable: " + locator,
                    e);
        }
    }
}