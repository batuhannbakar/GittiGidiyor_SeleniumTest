package GittiGidiyor.Test;

import GittiGidiyor.Test.BaseTest;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static com.sun.xml.internal.fastinfoset.stax.events.Util.isEmptyString;

public class BaseTestKeyword extends BaseTest {

    JavascriptExecutor scroll = (JavascriptExecutor) driver;
    String URL;

    public void SignUp(String name, String surname, String email, String password, String phone) {

        sendByXpath("//*[@name='name']", name);
        Thread(1600);
        sendByXpath("//*[@name='surname']", surname);
        Thread(1600);
        sendByXpath("//*[@name='email']", email);
        Thread(1600);
        sendByXpath("//*[@name='passwd']", password);
        Thread(1600);
        sendByXpath("//*[@name='gsmData']", phone);
        Thread(1600);
        clickByXpath("//*[@class='checkmark']");
        Thread(1600);

        Assert.assertFalse(driver.getPageSource().contains("Lütfen adınızı girin."));
        Assert.assertFalse(driver.getPageSource().contains("Lütfen soyadınızı girin."));
        Assert.assertFalse(driver.getPageSource().contains("E-posta adresinizi yazmayı unuttunuz."));
        Assert.assertFalse(driver.getPageSource().contains("E-posta adresi kullanılmaktadır."));
        Assert.assertFalse(driver.getPageSource().contains("Cep telefonunuzu yazmayı unuttunuz."));
        Assert.assertFalse(driver.getPageSource().contains("Cep telefonunuzu yazmayı unuttunuz."));
        Assert.assertFalse(driver.getPageSource().contains("Geçerli bir operatör numarası girmelisiniz."));

        clickByXpath("//*[@id='SubmitForm']");

    }

    public void Search(String word) {

        sendByXpath("//*[@data-cy='header-search-input']", word);
        clickByXpath("//*[@data-cy='search-find-button']");

    }

    public void RandomClick() {
        Thread(2000);
        List<WebElement> products = driver.findElements(By.cssSelector("a.product-link"));
        Random rand = new Random();
        WebElement randomProduct = products.get(rand.nextInt(products.size()));
        randomProduct.click();
    }

    public void AddAndOpenBucket() {
        Thread(2000);

        clickByClassName("action-text");
        Thread(7600);
        clickByClassName("header-cart-hidden-link");
        Thread(7600);

    }

    public void LoginMethod(String username, String password) {
        CallLoginPage();
        URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, loginpage);
        sendById("L-UserNameField", username);
        sendById("L-PasswordField", password);
        clickById("gg-login-enter");


    }

    public void AddressChange(String password, String address) {

        CallSettingsPage();
        sendById("L-PasswordField", password);
        clickById("gg-login-enter");
        clickByText("Düzenle");
        driver.findElement(By.name("address")).clear();
        Thread(5000);
        sendByXpath("//*[@name='address']", address);
        clickById("AddressSave");
    }

    public void AddressAdd(String password,String addressHeader, String name, String surname,String city,String county,String neighborhoodId,String zipCode,String address,String phone,String phone2) {
        CallSettingsPage();
        sendById("L-PasswordField", password);
        clickById("gg-login-enter");
        clickById("AddAddress");
        sendByXpath("//*[@name='title']", addressHeader);
        sendByXpath("//*[@name='name']", name);
        sendByXpath("//*[@name='surname']", surname);
        new Select(driver.findElement(By.id("cities"))).selectByValue(city);
        new Select(driver.findElement(By.id("counties"))).selectByValue(county);
        new Select(driver.findElement(By.id("neighborhoods"))).selectByValue(neighborhoodId);
        sendByXpath("//*[@name='zipCode']", zipCode);
        sendByXpath("//*[@name='address']", address);
        sendByXpath("//*[@name='address']", address);
        sendByXpath("//*[@name='phone']", phone);
        sendByXpath("//*[@name='gsm']", phone2);
        clickById("AddressSave");

    }
}


