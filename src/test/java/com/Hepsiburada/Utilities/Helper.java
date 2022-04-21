package com.Hepsiburada.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    /**
     * Method to wait dynamically given @param element for @param seconds.
     *
     * @param element
     * @param seconds
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), seconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
