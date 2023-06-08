package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class Project3 extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-3");
    }

    @Test ( priority = 1 )
    public void validateDefaultBookTripForm(){
        WebElement oneWayRadioButton = driver.findElement(By.cssSelector("label[class='radio ml-0']"));
        WebElement roundTripRadioButton = driver.findElement(By.cssSelector("label[class='radio']"));
        WebElement cabinClassLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(2) > label"));
        WebElement cabinClassDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(2) > div"));
        WebElement fromLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(3) > label"));
        WebElement fromDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(3) > div"));
        WebElement toLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(4) > label"));
        WebElement toDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(4) > div"));
        WebElement departLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(5) > label"));
        WebElement departPickDate = driver.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div"));
        WebElement returnLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(6) > label"));
        WebElement returnPickDate = driver.findElement(By.cssSelector("div:nth-child(6) > div > div > div > div"));
        WebElement numberOfPassengersLabel = driver.findElement(By.cssSelector("div:nth-child(7) > label"));
        WebElement numberOfPassengersDropdown = driver.findElement(By.cssSelector("div:nth-child(7) > div"));
        WebElement passenger1Label = driver.findElement(By.cssSelector("div:nth-child(8) > label"));
        WebElement passenger1Dropdown = driver.findElement(By.cssSelector("div:nth-child(8) > div"));
        WebElement bookButton = driver.findElement(By.cssSelector("button[class='Button_c_button__w4+7K null']"));


        oneWayRadioButton.click();
        Waiter.pause(5);
        Assert.assertTrue(oneWayRadioButton.isDisplayed());
        Assert.assertTrue(oneWayRadioButton.isEnabled());
        Assert.assertTrue(oneWayRadioButton.isSelected());

        Assert.assertTrue(roundTripRadioButton.isDisplayed());
        Assert.assertTrue(roundTripRadioButton.isEnabled());
        Assert.assertFalse(roundTripRadioButton.isSelected());

        Assert.assertTrue(cabinClassLabel.isDisplayed());
        Assert.assertTrue(cabinClassDropdown.isDisplayed());

        Assert.assertTrue(fromLabel.isDisplayed());
        Assert.assertTrue(fromDropdown.isDisplayed());

        Assert.assertTrue(toLabel.isDisplayed());
        Assert.assertTrue(toDropdown.isDisplayed());

        Assert.assertTrue(departLabel.isDisplayed());
        Assert.assertTrue(departPickDate.isDisplayed());

        Assert.assertTrue(returnLabel.isDisplayed());
        Assert.assertTrue(returnPickDate.isDisplayed());

        Assert.assertTrue(numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(numberOfPassengersDropdown.getText(), "1");

        Assert.assertTrue(passenger1Label.isDisplayed());
        Assert.assertTrue(passenger1Dropdown.isDisplayed());
        Assert.assertEquals(passenger1Dropdown.getText(), "Adult (16-64)");

        Assert.assertTrue(bookButton.isDisplayed());
        Assert.assertTrue(bookButton.isEnabled());
        Waiter.pause(5);

    }

    @Test ( priority = 2)
        public void validateBookTripWithRoundTrip(){
        WebElement oneWayRadioButton = driver.findElement(By.cssSelector("label[class='radio ml-0']"));
        WebElement roundTripRadioButton = driver.findElement(By.cssSelector("label[class='radio']"));
        WebElement cabinClassLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(2) > label"));
        WebElement cabinClassDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(2) > div"));
        WebElement fromLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(3) > label"));
        WebElement fromDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(3) > div"));
        WebElement toLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(4) > label"));
        WebElement toDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(4) > div"));
        WebElement departLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(5) > label"));
        WebElement departPickDate = driver.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div"));
        WebElement returnLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(6) > label"));
        WebElement returnPickDate = driver.findElement(By.cssSelector("div:nth-child(6) > div > div > div > div"));
        WebElement numberOfPassengersLabel = driver.findElement(By.cssSelector("div:nth-child(7) > label"));
        WebElement numberOfPassengersDropdown = driver.findElement(By.cssSelector("div:nth-child(7) > div"));
        WebElement passenger1Label = driver.findElement(By.cssSelector("div:nth-child(8) > label"));
        WebElement passenger1Dropdown = driver.findElement(By.cssSelector("div:nth-child(8) > div"));
        WebElement bookButton = driver.findElement(By.className("Button_c_button__w4+7K null"));

        roundTripRadioButton.click();

        Assert.assertTrue(roundTripRadioButton.isSelected());
        Assert.assertFalse(oneWayRadioButton.isSelected());

        Assert.assertTrue(cabinClassLabel.isDisplayed());
        Assert.assertTrue(cabinClassDropdown.isDisplayed());

        Assert.assertTrue(fromLabel.isDisplayed());
        Assert.assertTrue(fromDropdown.isDisplayed());

        Assert.assertTrue(toLabel.isDisplayed());
        Assert.assertTrue(toDropdown.isDisplayed());

        Assert.assertTrue(departLabel.isDisplayed());
        Assert.assertTrue(departPickDate.isDisplayed());

        Assert.assertTrue(returnLabel.isDisplayed());
        Assert.assertTrue(returnPickDate.isDisplayed());

        Assert.assertTrue(numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(numberOfPassengersDropdown.getText(), "1");

        Assert.assertTrue(passenger1Label.isDisplayed());
        Assert.assertTrue(passenger1Dropdown.isDisplayed());
        Assert.assertEquals(passenger1Dropdown.getText(), "Adult (16-64)");

        Assert.assertTrue(bookButton.isDisplayed());
        Assert.assertTrue(bookButton.isEnabled());


        }
        @Test ( priority = 3)
        public void validateBooking1PassengerOneWay(){
            WebElement oneWayRadioButton = driver.findElement(By.cssSelector("label[class='radio ml-0']"));
            WebElement cabinClassDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(2) > div"));
            WebElement fromDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(3) > div"));
            WebElement toDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(4) > div"));
            WebElement departPickDate = driver.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div"));
            WebElement numberOfPassengersDropdown = driver.findElement(By.cssSelector("div:nth-child(7) > div"));
            WebElement passenger1Dropdown = driver.findElement(By.cssSelector("div:nth-child(8) > div"));
            WebElement bookButton = driver.findElement(By.className("Button_c_button__w4+7K null"));

            oneWayRadioButton.click();
            cabinClassDropdown.findElement(By.cssSelector("div:nth-child(2) > div > select > option:nth-child(3)")).click();
            fromDropdown.findElement(By.cssSelector("div:nth-child(3) > div > select > option:nth-child(15)")).click();
            toDropdown.findElement(By.cssSelector("div:nth-child(4) > div > select > option:nth-child(11)")).click();
            departPickDate.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div > input.react-date-picker__inputGroup__input.react-date-picker__inputGroup__day")).sendKeys("15");
            numberOfPassengersDropdown.findElement(By.cssSelector("div:nth-child(7) > div > select > option:nth-child(1)")).click();
            passenger1Dropdown.findElement(By.cssSelector("div:nth-child(8) > div > select > option:nth-child(2)")).click();
            bookButton.click();
            WebElement departMessage = driver.findElement(By.className("ml-3"));
            Assert.assertEquals(departMessage.getText(), "DEPART\n" +
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
            WebElement roundTripRadioButton = driver.findElement(By.cssSelector("label[class='radio']"));
            WebElement cabinClassDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(2) > div"));
            WebElement fromDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(3) > div"));
            WebElement toDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(4) > div"));
            WebElement departPickDate = driver.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div"));
            WebElement returnPickDate = driver.findElement(By.cssSelector("div:nth-child(6) > div > div > div > div"));
            WebElement numberOfPassengersDropdown = driver.findElement(By.cssSelector("div:nth-child(7) > div"));
            WebElement passenger1Dropdown = driver.findElement(By.cssSelector("div:nth-child(8) > div"));
            WebElement bookButton = driver.findElement(By.className("Button_c_button__w4+7K null"));

            roundTripRadioButton.click();
            cabinClassDropdown.findElement(By.cssSelector("div:nth-child(2) > div > select > option:nth-child(4)")).click();
            fromDropdown.findElement(By.cssSelector("div:nth-child(3) > div > select > option:nth-child(6)")).click();
            toDropdown.findElement(By.cssSelector("div:nth-child(4) > div > select > option:nth-child(15)")).click();
            departPickDate.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div > input.react-date-picker__inputGroup__input.react-date-picker__inputGroup__day")).sendKeys("15");
            returnPickDate.findElement(By.cssSelector("div:nth-child(6) > div > div > div > div > input.react-date-picker__inputGroup__input.react-date-picker__inputGroup__month")).sendKeys("7");
            numberOfPassengersDropdown.findElement(By.cssSelector("div:nth-child(7) > div > select > option:nth-child(1)")).click();
            passenger1Dropdown.findElement(By.cssSelector("div:nth-child(8) > div > select > option:nth-child(1)")).click();
            bookButton.click();
            WebElement message = driver.findElement(By.className("ml-3"));

            Assert.assertEquals(message.getText(), "DEPART\n" +
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
            WebElement oneWayRadioButton = driver.findElement(By.cssSelector("label[class='radio ml-0']"));
            WebElement roundTripRadioButton = driver.findElement(By.cssSelector("label[class='radio']"));
            WebElement cabinClassLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(2) > label"));
            WebElement cabinClassDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(2) > div"));
            WebElement fromLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(3) > label"));
            WebElement fromDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(3) > div"));
            WebElement toLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(4) > label"));
            WebElement toDropdown = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(4) > div"));
            WebElement departLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(5) > label"));
            WebElement departPickDate = driver.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div"));
            WebElement returnLabel = driver.findElement(By.cssSelector("div.Projects_container__g8xeT > div:nth-child(6) > label"));
            WebElement returnPickDate = driver.findElement(By.cssSelector("div:nth-child(6) > div > div > div > div"));
            WebElement numberOfPassengersLabel = driver.findElement(By.cssSelector("div:nth-child(7) > label"));
            WebElement numberOfPassengersDropdown = driver.findElement(By.cssSelector("div:nth-child(7) > div"));
            WebElement passenger1Label = driver.findElement(By.cssSelector("div:nth-child(8) > label"));
            WebElement passenger1Dropdown = driver.findElement(By.cssSelector("div:nth-child(8) > div"));
            WebElement passenger2DDropdown = driver.findElement(By.cssSelector("div:nth-child(9) > div > select"));
            WebElement bookButton = driver.findElement(By.className("Button_c_button__w4+7K null"));

            oneWayRadioButton.click();
            cabinClassDropdown.findElement(By.cssSelector("div:nth-child(2) > div > select > option:nth-child(2)")).click();
            fromDropdown.findElement(By.cssSelector("div:nth-child(3) > div > select > option:nth-child(34)")).click();
            toDropdown.findElement(By.cssSelector("div:nth-child(4) > div > select > option:nth-child(45)")).click();
            departPickDate.findElement(By.cssSelector("div:nth-child(5) > div > div > div > div > input.react-date-picker__inputGroup__input.react-date-picker__inputGroup__day")).sendKeys("9");
            numberOfPassengersDropdown.sendKeys("2");
            passenger1Dropdown.findElement(By.cssSelector("div:nth-child(8) > div > select > option:nth-child(1)")).click();
            passenger2DDropdown.findElement(By.cssSelector("div:nth-child(9) > div > select > option:nth-child(4)")).click();
            bookButton.click();

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
