package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Project2 extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    @Test ( priority = 1 )
    public void validateLoginForm(){
        WebElement usernameInputBox = driver.findElement(By.id("input[id='username']"));
        WebElement usernameInputBoxLabel = driver.findElement(By.id("label[for='username']"));
        WebElement passwordInputBox = driver.findElement(By.id("input[id='password']"));
        WebElement passwordInputBoxLabel = driver.findElement(By.id("label[for='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPassword = driver.findElement(By.cssSelector("a[href='/frontend/project-2']"));

        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertEquals(usernameInputBoxLabel.getText(), "Please enter your username");
        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertEquals(passwordInputBoxLabel.getText(), "Please enter your password");
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "LOGIN");
        Assert.assertTrue(forgotPassword.isDisplayed());
        Assert.assertTrue(forgotPassword.isEnabled());
        Assert.assertEquals(forgotPassword.getText(), "Forgot Password?");



    }
    @Test ( priority = 2 )
    public void validateValidLogin(){
        WebElement usernameInputBox = driver.findElement(By.id("input[id='username']"));
        WebElement passwordInputBox = driver.findElement(By.id("input[id='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPassword = driver.findElement(By.cssSelector("a[href='/frontend/project-2']"));


        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();
        WebElement successLogin = driver.findElement(By.id("success_lgn"));
        Assert.assertEquals(successLogin.getText(), "You are logged in");
        WebElement logoutButton = driver.findElement(By.cssSelector("button[id='logout']"));
        Assert.assertEquals(logoutButton.getText(), "LOGOUT");
    }

    @Test ( priority = 3 )
    public void validateLogout(){
        WebElement usernameInputBox = driver.findElement(By.id("input[id='username']"));
        WebElement passwordInputBox = driver.findElement(By.id("input[id='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPassword = driver.findElement(By.cssSelector("a[href='/frontend/project-2']"));

        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("button[id='logout']"));
        logoutButton.click();

        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "LOGIN");
        Assert.assertTrue(forgotPassword.isDisplayed());
        Assert.assertTrue(forgotPassword.isEnabled());
        Assert.assertEquals(forgotPassword.getText(), "Forgot Password?");
    }

    @Test ( priority = 4 )
    public void forgotPasswordLink(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("a[href='/frontend/project-2']"));
        forgotPassword.click();
        WebElement forgotPasswordHeading = driver.findElement(By.id("sub_heading"));
        WebElement closeButton = driver.findElement(By.cssSelector("button[aria-label='close']"));
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[id='email']"));
        WebElement emailInputBoxLabel = driver.findElement(By.cssSelector("label[for='email']"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[id='submit']"));

        Assert.assertTrue(forgotPasswordHeading.isDisplayed());
        Assert.assertTrue(closeButton.isDisplayed());
        Assert.assertTrue(emailInputBox.isDisplayed());
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(emailInputBoxLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    @Test ( priority = 5 )
    public void forgotPasswordModal(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("a[href='/frontend/project-2']"));
        forgotPassword.click();

        WebElement resetPasswordModal = driver.findElement(By.id("modal_title"));
        Assert.assertTrue(resetPasswordModal.isDisplayed());
        WebElement closeButton = driver.findElement(By.cssSelector("button[aria-label='close']"));
        closeButton.click();
        Assert.assertFalse(resetPasswordModal.isDisplayed());

    }

    @Test ( priority = 6 )
    public void validatePasswordResetSubmission(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("a[href='/frontend/project-2']"));
        forgotPassword.click();

        WebElement emailInputBox = driver.findElement(By.cssSelector("input[id='email']"));
        emailInputBox.sendKeys("eihfeihfkhef@gmail.com");

        WebElement submitButton = driver.findElement(By.cssSelector("button[id='submit']"));
        submitButton.click();

        WebElement confirmationMessage = driver.findElement(By.id("confirmation_message"));
        Assert.assertEquals(confirmationMessage.getText(), "A link to reset your password has been sent to your email address.");
    }

    @Test ( priority = 7 )
    public void validateInvalidLogin(){
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");

    }
    @Test ( priority = 8 )
    public void validateInvalidUsername(){
        WebElement usernameInputBox = driver.findElement(By.id("input[id='username']"));
        WebElement passwordInputBox = driver.findElement(By.id("input[id='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInputBox.sendKeys("John");
        passwordInputBox.sendKeys("Test1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }
    @Test ( priority = 9 )
    public void validateInvalidPassword(){
        WebElement usernameInputBox = driver.findElement(By.id("input[id='username']"));
        WebElement passwordInputBox = driver.findElement(By.id("input[id='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInputBox.sendKeys("TechGlobal");
        passwordInputBox.sendKeys("1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Password entered!");
    }
    @Test ( priority = 10 )
    public void validateInvalidLoginWrongUserAndPass(){
        WebElement usernameInputBox = driver.findElement(By.id("input[id='username']"));
        WebElement passwordInputBox = driver.findElement(By.id("input[id='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInputBox.sendKeys("John");
        passwordInputBox.sendKeys("1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Invalid Username entered!");
    }
}
