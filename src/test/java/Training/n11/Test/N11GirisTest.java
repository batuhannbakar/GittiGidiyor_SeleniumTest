package Training.n11.Test;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class N11GirisTest extends BaseTestKeyword{


    @Test
    public void girisYap(){
        girisYap("melih.sakarya@gmail.com", "123456");
        urunAra("Samsung");
        urunAra("iphone");
        girisYap("ahmet.dursun@gmail.com", "12312312");

    }





}