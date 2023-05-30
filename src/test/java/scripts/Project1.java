package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class Project1 extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-1");

    }

    @Test (priority = 1)
    public void validateContactUs() {
        WebElement contactUs = driver.findElement(By.cssSelector("div[class='mb-5']>h1"));
        WebElement address = driver.findElement(By.cssSelector("p[id='address']"));
        WebElement email = driver.findElement(By.cssSelector("p[id='email']"));
        WebElement phoneNumber = driver.findElement(By.cssSelector("p[id='phone-number']"));

        String[] expectedText = {"Contact Us", "2860 S River Rd Suite 350, Des Plaines IL 60018", "info@techglobalschool.com",
                "(773) 257-3010"};


        Assert.assertEquals(contactUs.getText(), "Contact Us");
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
        Assert.assertEquals(email.getText(), "info@techglobalschool.com");
        Assert.assertEquals(phoneNumber.getText(), "(773) 257-3010");
    }

    @Test (priority = 2)
    public void validateFullNameInputBox() {
        WebElement fullNameInputBox = driver.findElement(By.cssSelector("input[placeholder='Enter your full name']"));
        WebElement label = driver.findElement(By.cssSelector("label[for='name']"));


        Assert.assertTrue(fullNameInputBox.isDisplayed());
        Assert.assertTrue(fullNameInputBox.isEnabled());
        Assert.assertEquals(label.getText(), "Full name *");
        Assert.assertEquals(fullNameInputBox.getAttribute("placeholder"), "Enter your full name");
    }

    @Test (priority = 3)
    public void validateGenderRadioButton() {
        WebElement gender = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[12]/form/div[2]/div/label[1]"));
        List<WebElement> options = driver.findElements(By.className("radio"));

        Assert.assertEquals(gender.getText(), "Gender");
        Assert.assertTrue(gender.isEnabled());
        Assert.assertEquals(options.get(0).getText(), "Male");
        Assert.assertEquals(options.get(1).getText(), "Female");
        Assert.assertEquals(options.get(2).getText(), "Prefer not to disclose");

        Assert.assertTrue(options.get(0).isEnabled());
        Assert.assertTrue(options.get(1).isEnabled());
        Assert.assertTrue(options.get(2).isEnabled());

        Assert.assertFalse(options.get(0).isSelected());
        Assert.assertFalse(options.get(1).isSelected());
        Assert.assertFalse(options.get(2).isSelected());

        options.get(0).click();

        Assert.assertTrue(options.get(0).isSelected());
        Assert.assertFalse(options.get(1).isSelected());
        Assert.assertFalse(options.get(2).isSelected());

        options.get(1).click();

        Assert.assertFalse(options.get(0).isSelected());
        Assert.assertTrue(options.get(1).isSelected());
        Assert.assertFalse(options.get(2).isSelected());
    }

    @Test (priority = 4)
    public void validateAddressField() {
        WebElement addressLabel = driver.findElement(By.cssSelector("div:nth-child(3) > label"));
        WebElement addressField = driver.findElement(By.cssSelector("input[placeholder='Enter your address']"));

        Assert.assertTrue(addressField.isDisplayed());

        Assert.assertEquals(addressLabel.getText(), "Address");
        Assert.assertEquals(addressField.getAttribute("placeholder"), "Enter your address");


    }

    @Test (priority = 5)
    public void validateEmail(){
        WebElement emailLabel = driver.findElement(By.cssSelector("div:nth-child(4) > label"));
        WebElement emailInput = driver.findElement(By.cssSelector("input[placeholder='Enter your email']"));

        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertEquals(emailLabel.getText(), "Email");
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "Enter your email");

    }

    @Test ( priority = 6)
    public void validatePhone(){
        WebElement phoneLabel = driver.findElement(By.cssSelector("div:nth-child(5) > label"));
        WebElement phoneInput = driver.findElement(By.cssSelector("input[placeholder='Enter your phone number']"));

        Assert.assertTrue(phoneInput.isDisplayed());
        Assert.assertEquals(phoneLabel.getText(), "Phone");
        Assert.assertEquals(phoneInput.getAttribute("placeholder"), "Enter your full name");
    }

    @Test ( priority = 7)
    public void validateMessage(){
        WebElement messageLabel = driver.findElement(By.cssSelector("div:nth-child(6) > label"));
        WebElement messageInput = driver.findElement(By.cssSelector("textarea[placeholder='Type your message here...']"));

        Assert.assertTrue(messageInput.isDisplayed());
        Assert.assertEquals(messageLabel.getText(), "Message");
        Assert.assertEquals(messageInput.getText(), "Type your message here...");

    }

    @Test ( priority = 8)
    public void validateConsentCheckBox(){
        WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']"));


        Assert.assertTrue(checkBox.isEnabled());
        checkBox.click();

        Assert.assertTrue(checkBox.isSelected());
        checkBox.click();
        Assert.assertFalse(checkBox.isSelected());



    }

    @Test ( priority = 9)
    public void validateSubmitButton(){
        WebElement submit = driver.findElement(By.cssSelector("button[class='button is-link']"));


        Assert.assertTrue(submit.isEnabled());

        Assert.assertTrue(submit.isDisplayed());

        Assert.assertEquals(submit.getText(), "SUBMIT");




    }

    @Test ( priority = 10)
    public void validateFormSubmission(){
        List<WebElement> genderOptions = driver.findElements(By.className("radio"));
        WebElement gender = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[12]/form/div[2]/div/label[1]"));
        WebElement fullNameInputBox = driver.findElement(By.cssSelector("input[placeholder='Enter your full name']"));
        WebElement addressField = driver.findElement(By.cssSelector("input[placeholder='Enter your address']"));
        WebElement phoneInput = driver.findElement(By.cssSelector("input[placeholder='Enter your full name']"));
        WebElement emailInput = driver.findElement(By.cssSelector("input[placeholder='Enter your email']"));
        WebElement messageInput = driver.findElement(By.cssSelector("textarea[placeholder='Type your message here...']"));
        WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement submit = driver.findElement(By.cssSelector("button[class='button is-link']"));

        fullNameInputBox.sendKeys("John Doe");
        genderOptions.get(0).click();
        addressField.sendKeys("123 Chicago Dr, Chicago IL 60446");
        emailInput.sendKeys("johndoe@gmail.com");
        phoneInput.sendKeys("(123) 123-1234");
        messageInput.sendKeys("Hello World!");
        checkBox.click();
        submit.click();
        WebElement formMessage = driver.findElement(By.cssSelector(".mt-5"));

        Waiter.pause(5);


        Assert.assertEquals(formMessage.getText(), "Thanks for submitting!");

    }



}
