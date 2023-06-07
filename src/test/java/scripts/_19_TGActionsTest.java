package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _19_TGActionsTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);
    }

    /**
     * TEST CASE 1
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"
     * Perform a right-click action on the second web element labeled "Right-Click on me"
     * Verify that the message appears next to the element stating, "You right-clicked on a button!"
     * Perform a double-click action on the third web element labeled "Double-Click on me"
     * Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */
    @Test
    public void mouseActions(){

        WebElement clickAction = driver.findElement(By.cssSelector("button[id='click']"));
        WebElement rightAction = driver.findElement(By.cssSelector("button[id='right-click']"));
        WebElement doubleAction = driver.findElement(By.cssSelector("button[id='double-click']"));



        Assert.assertEquals(driver.getCurrentUrl(), "https://techglobal-training.com/frontend/actions");


        clickAction.click();
        WebElement clickActionResult = driver.findElement(By.cssSelector("[id='click_result']"));
        Assert.assertEquals(clickActionResult.getText(), "You clicked on a button!");

        actions.moveToElement(rightAction).contextClick().perform();
        WebElement rightClickActionResult = driver.findElement(By.cssSelector("[id='right_click_result']"));
        Assert.assertEquals(rightClickActionResult.getText(), "You right-clicked on a button!");

        actions.moveToElement(doubleAction).doubleClick() .perform();
        WebElement doubleClickActionResult = driver.findElement(By.cssSelector("[id='double_click_result']"));
        Assert.assertEquals(doubleClickActionResult.getText(), "You double-clicked on a button!");

    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the web element stating, "An element dropped here!"
     */

    @Test
    public void dragAndDrop(){
        WebElement dragMe = driver.findElement(By.id("drag_element"));
        WebElement dropHere = driver.findElement(By.id("drop_element"));

        Assert.assertTrue(dragMe.isDisplayed());
        Assert.assertTrue(dropHere.isDisplayed());

        Assert.assertEquals(dragMe.getText(), "Drag Me");
        Assert.assertEquals(dropHere.getText(), "Drop Here");

        actions.dragAndDrop(dragMe, dropHere).perform();
        WebElement result = driver.findElement(By.id("drag_and_drop_result"));
        Waiter.waitForVisibilityOfElement(result, 10);
        Assert.assertEquals(result.getText(), "An element dropped here!");

    }
}