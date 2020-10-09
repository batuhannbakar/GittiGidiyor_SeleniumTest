package Training.n11.Test;


import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N11SampleTest extends BaseTest{


    @Test
    public void anasayfaTest(){
        assertEquals("n11.com - Hayat Sana Gelir", getTitle());

    }

    @Test
    public void girisYap(){
        clickByLintext("Giriş Yap");
        sendById("email", "melih.sakarya@gmail.com");
        sendById("password", "123456");
        clickById("loginButton");

        callHomePage();

        sendById("searchData", "Samsung");
        clickByClassName("iconSearch");
    }




}

