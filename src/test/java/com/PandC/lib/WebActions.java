package com.PandC.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActions {

    /**
     * Wait for Element
     * @param driver
     * @param timeinMilliSec
     * @param cssSelector
     */
    public void waitForElementClickable(WebDriver driver,int timeinMilliSec, String cssSelector)
{
    (new WebDriverWait(driver, timeinMilliSec))
            .until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(cssSelector)
            ));
}

    /**
     * Action to Click
     * @param driver
     * @param cssSelector
     */
    public void clickAction(WebDriver driver,String cssSelector)
{
    driver.findElement(By.cssSelector(cssSelector)).click();

}

    /**
     * Wait for element
     * @param driver
     * @param timeinMilliSec
     * @param cssSelector
     */
    public void waitForElement(WebDriver driver,int timeinMilliSec, String cssSelector)
{
    (new WebDriverWait(driver, timeinMilliSec))
            .until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(cssSelector)
            ));
}

    /**
     * Replace text
     * @param driver
     * @param cssSelector
     * @param replaceWith
     */
    public void replaceText(WebDriver driver,String cssSelector,String replaceWith)
    {
        driver.findElement(
                By.cssSelector(cssSelector)
        ).sendKeys(
                Keys.chord(Keys.CONTROL, "a"),
                replaceWith);
    }

}
