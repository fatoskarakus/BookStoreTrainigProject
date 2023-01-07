package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;


    //driver and elemnets initialing
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Object Repository
    @FindBy(how = How.CSS, using = "input[id='firstname']")
    WebElement sFirstNameElement;
    @FindBy(how = How.CSS, using = "input[id='lastname']")
    WebElement sLastNameElement;
    @FindBy(how = How.CSS, using = "input[id='userName']")
    WebElement sUserNameElement;
    @FindBy(how = How.CSS, using = "input[id='password']")
    WebElement sPasswordElement;
    @FindBy(how = How.CSS, using = "button[id='register']")
    WebElement sRegisterButtonElement;

    @FindBy(how = How.CSS, using = "p[id='name']")
    WebElement sValidateText;

    //Methods
    public void GiveTheFirstName(String firtname) {
        sFirstNameElement.sendKeys(firtname);
    }

    public void GiveTheLastName(String lastname) {
        sLastNameElement.sendKeys(lastname);
    }

    public void GiveTheUserName(String username) {
        sUserNameElement.sendKeys(username);
    }

    public void GiveThePassword(String password) throws InterruptedException {
        sPasswordElement.sendKeys(password);
        Thread.sleep(50);
    }

    public void ClickTheRegisterButton() {
        sRegisterButtonElement.click();
    }

    public void ValidateTheRegistiration(String firtname, String lastname, String username, String password) {
        sFirstNameElement.sendKeys(firtname);
        sLastNameElement.sendKeys(lastname);
        sUserNameElement.sendKeys(username);
        sPasswordElement.sendKeys(password);
        sRegisterButtonElement.click();
        Assert.assertEquals(sValidateText.getText(), "Please verify reCaptcha to register!");
    }

}

