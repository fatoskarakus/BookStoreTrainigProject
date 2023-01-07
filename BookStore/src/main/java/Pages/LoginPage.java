package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    //driver initialing
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Object Repository
    @FindBy(how = How.CSS, using = "input[id=\"userName\"]")
    WebElement sUserNameElement;

    @FindBy(how = How.CSS, using = "input[id=\"password\"]")
    WebElement sPasswordElement;

    @FindBy(how = How.CSS, using = "button[id=\"login\"]")
    WebElement loginButton;

    @FindBy(how = How.CSS, using = "button[id='newUser']")
    WebElement newUserButton;



    //Methods
    public void clickTheNewUserButton(){
        newUserButton.click();
    }

    public void sendUserNameAndPassword(String username, String password) {
        sUserNameElement.sendKeys(username);
        sPasswordElement.sendKeys(password);
        loginButton.click();
    }
    public void logOutApp(){
        driver.close();
    }
}
