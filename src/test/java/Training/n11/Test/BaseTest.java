package Training.n11.Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void startTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\testinium\\Downloads\\chromedriver");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.driver.get("https://n11.com");
        Thread.sleep(2000);
        //clickByText("Tamam");
        clickByXpath("//span[text()='Tamam']");
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

    public void callHomePage() {
        driver.get("https://www.n11.com/");
    }
    public void callSignuPage() {
        driver.get("https://www.n11.com/");
    }

    public void clickByClassName(String className) {
        driver.findElement(By.className(className));
    }
}