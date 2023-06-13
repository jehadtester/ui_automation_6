package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project3Page {

    public Project3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "label[class='radio ml-0']")
    public WebElement oneWayRadioButton;

    @FindBy(css = "label[class='radio']")
    public WebElement roundTripRadioButton;

    @FindBy(css = "div.Projects_container__g8xeT > div:nth-child(2) > label")
    public WebElement cabinClassLabel;

    @FindBy(css = "div.Projects_container__g8xeT > div:nth-child(2) > div")
    public WebElement cabinClassDropdown;

    @FindBy(css = "div.Projects_container__g8xeT > div:nth-child(3) > label")
    public WebElement fromLabel;

    @FindBy(css = "div.Projects_container__g8xeT > div:nth-child(3) > div")
    public WebElement fromDropdown;

    @FindBy(css = "div.Projects_container__g8xeT > div:nth-child(4) > label")
    public WebElement toLabel;

    @FindBy(css = "div.Projects_container__g8xeT > div:nth-child(4) > div")
    public WebElement toDropdown;

    @FindBy(css = "div.Projects_container__g8xeT > div:nth-child(5) > label")
    public WebElement departLabel;

    @FindBy(css = "div:nth-child(5) > div > div > div > div")
    public WebElement departPickDate;

    @FindBy(css = "div.Projects_container__g8xeT > div:nth-child(6) > label")
    public WebElement returnLabel;

    @FindBy(css = "div:nth-child(6) > div > div > div > div")
    public WebElement returnPickDate;

    @FindBy(css = "div:nth-child(7) > label")
    public WebElement numberOfPassengersLabel;

    @FindBy(css = "div:nth-child(7) > div")
    public WebElement numberOfPassengersDropdown;

    @FindBy(css = "div:nth-child(8) > label")
    public WebElement passenger1Label;

    @FindBy(css = "div:nth-child(8) > div")
    public WebElement passenger1Dropdown;

    @FindBy(css = "button[class='Button_c_button__w4+7K null']")
    public WebElement bookButton;

    @FindBy(className = "ml-3")
    public WebElement departMessage;

    @FindBy(css = "div:nth-child(9) > div > select")
    public WebElement passenger2DDropdown;
}
