package StepDefinitions;

import Pages.LoginPage;
import Pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class StepDefs {

    WebDriver driver;
    LoginPage login;
    RegisterPage resgister;
    String sUrl = "https://demoqa.com/login";

    @Given("Open the Homepage")
    public void open_the_homepage() throws InterruptedException {
        System.out.println("Sayfa Açılıyor.");
        System.setProperty("webdriver.chrome.driver", "C:/Users/FATMA/Selenium/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(sUrl);
        driver.manage().window().maximize();
        Thread.sleep(50);
    }

    @When("Send the UsernameAndPassword {string} and {string}")
    public void send_the_username_and_password_and(String _username, String _password) {
        login=new LoginPage(driver); //nesne yaratıldı henüz inişilayz edilmedi PageFaktory ile nesneye ait elementler initşilayz edilir.
        PageFactory.initElements(driver,login); //page sayfalarındaki element ve metodları inişilayz eder. kullanılmas ise element is null uyarısı atar.
        login.sendUserNameAndPassword(_username,_password);
    }

    @Then("LogoutOfApp")
    public void logout_of_app() {
        login.logOutApp();
    }

    @Then("Click the NewUser Button")
    public void clickTheNewUserButton() {
        login =new LoginPage(driver);
        login.clickTheNewUserButton();
    }

    @Then("Give the Firstname {string}")
    public void giveTheFirstname(String username) {
        resgister=new RegisterPage(driver);
        resgister.GiveTheFirstName(username);
    }

    @Then("Give the LastName {string}")
    public void giveTheLastName(String lastname) {
        resgister.GiveTheLastName(lastname);
    }

    @Then("Give the UserName {string}")
    public void giveTheUserName(String username) {
        resgister.GiveTheUserName(username);
    }

    @Then("Give the Password {string}")
    public void giveThePassword(String password) throws InterruptedException {
        resgister.GiveThePassword(password);
    }

    @When("Click the Register Button")
    public void clickTheRegisterButton() {
        resgister.ClickTheRegisterButton();
    }

    @Then("Validate the Registration {string},{string},{string},{string}")
    public void validateTheRegistration(String fistname, String lastname, String username, String password) {
        resgister.ValidateTheRegistiration(fistname,lastname,username,password);
    }


//    @Then("Validate the Registration")
//    public void validateTheRegistration() {
//        resgister.ValidateTheRegistiration();
//        Yazılacak.
//    }

}
