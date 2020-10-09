package GittiGidiyor.Test;

import org.junit.Assert;
import org.junit.Test;


public class GittiGidiyorMainTest extends BaseTestKeyword {


    String URL;

    @Test
    public void SignUpPage() {
        CallSignUpPage();
        URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, signuppage);
        Thread(1500);
        SignUp("Batuhan", "Bakar", "batuhanbakar9696@gmail.com", "141414A", "5534950338");
    }

    @Test
    public void SearchAndAddBucket() {
        CallHomePage();
        URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, homepage);
        Search("Bilgisayar");
        Thread(2000);
        RandomClick();
        AddAndOpenBucket();
        Thread(1500);

    }

    @Test
    public void Login() {
        LoginMethod("batuhanbakar9696@gmail.com", "141414A");


    }

    @Test
    public void AddressChange() {

        Login();
        Thread(3500);

        AddressChange("141414A", "(ADRES DEĞİŞTaaİ )İZMİR PINARLAR SOKAK D.5 CÖMERTKENT SİTESİ");
        Thread(2500);
        Assert.assertTrue(driver.getPageSource().contains("Tebrikler. Adres güncelleme işleminiz başarıyla tamamlandı."));

    }

    @Test
    public void AddressAdd() {
        Login();
        AddressAdd("141414A","Adres2","Batuhan","Bakar","35","491","36901","35170","YENİ ADRES EKLENDİ BUCA İZMİR","5534950338","5054885167");
        Thread(2500);
        Assert.assertTrue(driver.getPageSource().contains("Tebrikler. Adres ekleme işleminiz başarıyla tamamlandı."));

    }
}