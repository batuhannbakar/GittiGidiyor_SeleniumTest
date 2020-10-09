package GittiGidiyor.Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void startTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\testinium\\Downloads\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        this.driver.get("https://www.gittigidiyor.com/");
        //Thread.sleep(2000);


    }

    public void Thread(int time){
        try {
            Thread.sleep(time);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @After
    public void endTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickByText(String text){
        driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
    }

    public void clickByLintext(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void sendById(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void sendByXpath(String xpath, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public String homepage = "https://www.gittigidiyor.com/";
public String signuppage = "https://www.gittigidiyor.com/kayit-ol";
public String loginpage = "https://www.gittigidiyor.com/uye-girisi";

    public void CallHomePage() {
        driver.get("https://www.gittigidiyor.com");
    }
    public void CallSignUpPage() {
        driver.get("https://www.gittigidiyor.com/kayit-ol");
    }
    public void CallLoginPage() {
        driver.get("https://www.gittigidiyor.com/uye-girisi");
    }

    public void CallSettingsPage() {
        driver.get("https://www.gittigidiyor.com/uye-girisi?mod=again&aType=eAddress&url=/bana-ozel/adreslerim");
    }

    public void clickByClassName(String className) {
        driver.findElement(By.className(className));
    }




//    public void waitXpathClickable(String xpath) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//        element.click();
//    }
}