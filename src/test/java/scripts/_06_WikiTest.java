package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _06_WikiTest extends Base{
    /*
Go to "https://www.wikipedia.org/"
Search for "Tesla"
Validate the main header of the page is displayed and is "Tesla"
 */

    @BeforeMethod
    public void setPage(){
        driver.get("https://www.wikipedia.org/");
    }

    @Test
    public void validateTeslaSearch(){
        WebElement searchBox = driver.findElement(By.id("searchInput"));

        searchBox.sendKeys("Tesla" + Keys.ENTER);

        Waiter.pause(5);

        WebElement heading = driver.findElement(By.id("firstHeading"));

        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(), "Tesla");

    }
}
