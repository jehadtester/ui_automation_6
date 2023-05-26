package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _08_TGWaitsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-4")).click();
    }

    @Test
    public void waitForRedBox(){
        WebElement redBox = driver.findElement(By.cssSelector("button[red"));

        redBox.click();

        Assert.assertTrue(redBox.isDisplayed());
    }
}
