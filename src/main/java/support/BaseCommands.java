package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BaseCommands {

    DriverInit driverInit = new DriverInit();

    public WebDriver getWebDriver() {
        return driverInit.getWebDriver();
    }

    public void wait(int milliSeconds) {
        try {
            getWebDriver().wait(milliSeconds);
        } catch (Exception e) {
            System.out.println("Waiting for " + milliSeconds + " milliseconds");
        }
    }

    public void assertBrowserTitle(String expectedTitle) {
        assertEquals(getWebDriver().getTitle(), expectedTitle);
    }

    public void switchToFrame(String frame) {
        getWebDriver().switchTo().frame(frame);
    }

    public WebElement element(String selector) {
        WebElement webElement = getWebDriver().findElement(By.cssSelector(selector));
        return webElement;
    }

    public List<WebElement> elements(String selector) {
        return getWebDriver().findElements(By.cssSelector(selector));
    }

    public void clickOnElement(String selector) {
        element(selector).click();
    }

    public String getElementText(String selector) {
        return element(selector).getText();
    }

    public void assertElementText(String selector, String expectedText) {
        assertEquals(getElementText(selector), expectedText);
    }

    public int numberOfElements(String selector) {
        List<WebElement> webElements = elements(selector);
        int counter = 0;
        if (null != webElements || webElements.isEmpty()) counter = webElements.size();
        return counter;
    }

    public List<String> getElementsText(String selector) {
        List<WebElement> webElements = elements(selector);
        List<String> elementsText = new LinkedList<>();
        if (null != webElements || webElements.isEmpty()) {
            for (WebElement webElement : webElements) {
                elementsText.add(webElement.getText());
            }
        }
        return elementsText;
    }

    public String getAttributeValue(String selector) {
        return element(selector).getAttribute("value");
    }

    public void clearAndEnterText(String selector, String textToEnter) {
        element(selector).clear();
        element(selector).sendKeys(textToEnter);
    }

    public boolean isElementDisplayed(String selector) {
        return element(selector).isDisplayed();
    }

    public boolean isElementEnabled(String selector) {
        return element(selector).isEnabled();
    }

    public boolean isElementSelected(String selector) {
        return element(selector).isSelected();
    }

    public void closeAllTabsAndGetMainWindowsHandle() {
        String originalHandle = getWebDriver().getWindowHandle();
        for (String handle : getWebDriver().getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                getWebDriver().switchTo().window(handle);
                getWebDriver().close();
            }
        }
        getWebDriver().switchTo().window(originalHandle);
    }

    public void getNewWindowHandle() {
        String originalHandle = getWebDriver().getWindowHandle();
        for (String handle : getWebDriver().getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                getWebDriver().switchTo().window(handle);
            }
        }
    }
}