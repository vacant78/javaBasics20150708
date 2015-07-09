package msz.javabasics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class TillTest {


    public static final int PRICE_APPLE = 60;
    private static final int PRICE_ORANGE = 25;

    @Test
    public void shouldChargeZeroOnEmptyCart(){
        Till till = new Till();
        till.addCart(new Cart());
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(0));
    }

    @Test
    public void shouldChargeForOneApple(){
        Till till = new Till();
        till.addCart(new Cart(Apples.one()));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_APPLE));
    }
    @Test
    public void shouldChargeForOneOrange(){
        Till till = new Till();
        till.addCart(new Cart(Oranges.one()));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_ORANGE));
    }

    private static class Apples {
        public static Apple one() {
            return new Apple();
        }
    }
    private static class Oranges {
        public static Orange one() {
            return new Orange();
        }
    }
}
