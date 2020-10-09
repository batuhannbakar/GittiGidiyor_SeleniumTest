package Training.n11.Test;

import org.junit.Test;

public class N11KayitTest extends BaseTestKeyword {


    @Test
    public void KayitOl() {

        sendById("firstName", "Batuhan");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}