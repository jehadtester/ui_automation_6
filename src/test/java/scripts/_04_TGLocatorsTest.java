package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.font.FontRunIterator;

import java.util.List;

public class _04_TGLocatorsTest extends Base{
    /*
    Test case 1
    Go to "https://techglobal-training.com/frontend/xpath-css-locators"
    Validate the header is "Xpath-CSS Locators"
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-2")).click();
    }

    @Test
    public void validateTheHeader(){
        WebElement header = driver.findElement(By.cssSelector("#main_heading"));

        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(header.getText(), "Xpath-CSS Locators");

    }

    /*
    Test case 2
    Go to "https://techglobal-training.com/frontend/"
    Validate the languages are Java, JavaScript, C#
     */

    @Test
    public void validateLanguages(){
        List<WebElement> languages = driver.findElements(By.xpath("(//h3[@class='Xpath_subheader__VOtsU'])[1]/../ul/li"));

        String[] expectedTexts = {"Java", "JavaScript", "C#"};

        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(languages.get(i).isDisplayed());
            Assert.assertEquals(languages.get(i).getText(), expectedTexts[i]);
        }
    }

     /*
    Test case 3:
    Go to "https://techglobal-training.com/frontend/"
    Click on "Xpath-CSS Locators" card
    Validate the automation tools are "Selenium WebDriver", "WebDriverIO", "Cypress", "Playwright"
     */
    @Test
    public void validateAutomationTools(){

        List<WebElement> automation = driver.findElements(By.xpath("(//h3[@class='Xpath_subheader__VOtsU'])[2]/..//li"));

        String[] expectedAutomation = {"Selenium WebDriver", "WebDriverIO", "Cypress", "Playwright"};

        for (int i = 0; i <= 3; i++) {
            Assert.assertTrue(automation.get(i).isDisplayed());
            Assert.assertEquals(automation.get(i).getText(), expectedAutomation[i]);
        }


    }

    /*
Test case 4:
Go to "https://techglobal-training.com/frontend/"
Click on "Xpath-CSS Locators" card
Validate the headings "Programming Languages", "Automation Tools"
 */

    @Test
    public void validateListHeaders(){
        List<WebElement> headings = driver.findElements(By.tagName("h3"));


        String[] expectedHeadings = {"Programming Languages", "Automation Tools"};

        for (int i = 0; i <= 1; i++) {
            Assert.assertTrue(headings.get(i).isDisplayed());
            Assert.assertEquals(headings.get(i).getText(), expectedHeadings[i]);
        }

    }


}