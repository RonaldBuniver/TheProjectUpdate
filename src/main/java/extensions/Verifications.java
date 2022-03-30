package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);

    }

    @Step("Verify Number Of Elements")
    public static void numberOfElements(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        assertEquals(elems.size(), expected);

    }

    @Step("Verify Visibility Of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "sorry" + elem.getText() + "not displayed");
        }
        softAssert.assertAll("Some Elements Were not displayed");
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName) {
        try {
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File:" + findFailed);
            fail("Error Comparing Image File:" + findFailed);
        }

    }

    @Step("Verify Element Displayed")
    public static void existanceOfElement(List<WebElement> elements) {
        assertTrue(elements.size() > 0);
    }

    @Step("Verify Element Not Displayed")
    public static void nonexistanceOfElement(List<WebElement> elements) {
        assertFalse(elements.size() > 0);
    }
    @Step("Verify Text With text")
    public static void verifyText(String actual,String expected){
        assertEquals(actual,expected);
    }

    @Step("Verify Number With Number")
    public static void verifyNumber(int actual,int expected){
        assertEquals(actual,expected);
    }


}