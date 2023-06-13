package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;
import utils.Waiter;

public class Project3 extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-3");
        project3Page = new Project3Page();
    }

    @Test ( priority = 1 )
    public void validateDefaultBookTripForm(){


        project3Page.oneWayRadioButton.click();
        Waiter.pause(5);
        Assert.assertTrue(project3Page.oneWayRadioButton.isDisplayed());
        Assert.assertTrue(project3Page.oneWayRadioButton.isEnabled());
        Assert.assertTrue(project3Page.oneWayRadioButton.isSelected());

        Assert.assertTrue(project3Page.roundTripRadioButton.isDisplayed());
        Assert.assertTrue(project3Page.roundTripRadioButton.isEnabled());
        Assert.assertFalse(project3Page.roundTripRadioButton.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departPickDate.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnPickDate.isDisplayed());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersDropdown.findElement(By.cssSelector("div:nth-child(7) > div > select > option:nth-child(1)")).getText(), "1");

        Assert.assertTrue(project3Page.passenger1Label.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertEquals(project3Page.passenger1Dropdown.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[7]/form/div[1]/div[8]/div/select/option[1]")).getText(), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());

    }

    @Test ( priority = 2)
        public void validateBookTripWithRoundTrip(){
        project3Page.roundTripRadioButton.click();

        Assert.assertTrue(project3Page.roundTripRadioButton.isSelected());
        Assert.assertFalse(project3Page.oneWayRadioButton.isSelected());

        Assert.assertTrue(project3Page.cabinClassLabel.isDisplayed());
        Assert.assertTrue(project3Page.cabinClassDropdown.isDisplayed());

        Assert.assertTrue(project3Page.fromLabel.isDisplayed());
        Assert.assertTrue(project3Page.fromDropdown.isDisplayed());

        Assert.assertTrue(project3Page.toLabel.isDisplayed());
        Assert.assertTrue(project3Page.toDropdown.isDisplayed());

        Assert.assertTrue(project3Page.departLabel.isDisplayed());
        Assert.assertTrue(project3Page.departPickDate.isDisplayed());

        Assert.assertTrue(project3Page.returnLabel.isDisplayed());
        Assert.assertTrue(project3Page.returnPickDate.isDisplayed());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersDropdown.getText(), "1");

        Assert.assertTrue(project3Page.passenger1Label.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertEquals(project3Page.passenger1Dropdown.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[7]/form/div[1]/div[8]/div/select/option[1]")).getText(), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());


        }
        @Test ( priority = 3)
        public void validateBooking1PassengerOneWay(){

            project3Page.oneWayRadioButton.click();
            project3Page.cabinClassDropdown.findElement(By.cssSelector("div:nth-child(2) > div > select > option:nth-child(3)")).click();
            project3Page.fromDropdown.findElement(By.cssSelector("div:nth-child(3) > div > select > option:nth-child(15)")).click();
            project3Page.toDropdown.findElement(By.cssSelector("div:nth-child(4) > div > select > option:nth-child(11)")).click();
            project3Page.departPickDate.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div > input.react-date-picker__inputGroup__input.react-date-picker__inputGroup__day")).sendKeys("15");
            project3Page.numberOfPassengersDropdown.findElement(By.cssSelector("div:nth-child(7) > div > select > option:nth-child(1)")).click();
            project3Page.passenger1Dropdown.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[7]/form/div[1]/div[8]/div/select/option[2]")).click();
            project3Page.bookButton.click();
            Assert.assertEquals(project3Page.departMessage.getText(), "DEPART\n" +
                    "IL to FL\n" +
                    "Thu Jun 15 2023\n" +
                    "\n" +
                    "Number of Passengers: 1\n" +
                    "\n" +
                    "Passenger 1: Senior (65+)\n" +
                    "\n" +
                    "Cabin class: Business");

        }

        @Test ( priority = 4 )
        public void validateBooking1PassengerRoundTtrip(){


            project3Page.roundTripRadioButton.click();
            project3Page.cabinClassDropdown.findElement(By.cssSelector("div:nth-child(2) > div > select > option:nth-child(4)")).click();
            project3Page.fromDropdown.findElement(By.cssSelector("div:nth-child(3) > div > select > option:nth-child(6)")).click();
            project3Page.toDropdown.findElement(By.cssSelector("div:nth-child(4) > div > select > option:nth-child(15)")).click();
            project3Page.departPickDate.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div > input.react-date-picker__inputGroup__input.react-date-picker__inputGroup__day")).sendKeys("15");
            project3Page.returnPickDate.findElement(By.cssSelector("div:nth-child(6) > div > div > div > div > input.react-date-picker__inputGroup__input.react-date-picker__inputGroup__month")).sendKeys("7");
            project3Page.numberOfPassengersDropdown.findElement(By.cssSelector("div:nth-child(7) > div > select > option:nth-child(1)")).click();
            project3Page.passenger1Dropdown.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[7]/form/div[1]/div[8]/div/select/option[2]")).click();
            project3Page.bookButton.click();

            Assert.assertEquals(project3Page.departMessage.getText(), "DEPART\n" +
                    "CA to IL\n" +
                    "Thu Jun 15 2023\n" +
                    "\n" +
                    "RETURN\n" +
                    "IL to CA\n" +
                    "Sat Jul 15 2023\n" +
                    "\n" +
                    "Number of Passengers: 1\n" +
                    "\n" +
                    "Passenger 1: Adult (16-64)\n" +
                    "\n" +
                    "Cabin class: First");





        }
        @Test ( priority = 5 )
        public void validateBooking2PassengersOneWay(){

            project3Page.oneWayRadioButton.click();
            project3Page.cabinClassDropdown.findElement(By.cssSelector("div:nth-child(2) > div > select > option:nth-child(2)")).click();
            project3Page.fromDropdown.findElement(By.cssSelector("div:nth-child(3) > div > select > option:nth-child(34)")).click();
            project3Page.toDropdown.findElement(By.cssSelector("div:nth-child(4) > div > select > option:nth-child(45)")).click();
            project3Page.departPickDate.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div > input.react-date-picker__inputGroup__input.react-date-picker__inputGroup__day")).sendKeys("9");
            project3Page.numberOfPassengersDropdown.sendKeys("2");
            project3Page.passenger1Dropdown.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[7]/form/div[1]/div[8]/div/select/option[2]")).click();
            project3Page.passenger2DDropdown.findElement(By.cssSelector("div:nth-child(9) > div > select > option:nth-child(4)")).click();
            project3Page.bookButton.click();

            WebElement message = driver.findElement(By.className("ml-3"));
            Assert.assertEquals(message.getText(), "DEPART\n" +
                    "NY to TX\n" +
                    "Fri Jun 09 2023\n" +
                    "\n" +
                    "Number of Passengers: 2\n" +
                    "\n" +
                    "Passenger 1: Adult (16-64)\n" +
                    "\n" +
                    "Passenger 2: Child (2-11)\n" +
                    "\n" +
                    "Cabin class: Premium Economy\n" +
                    "\n");

        }
}
