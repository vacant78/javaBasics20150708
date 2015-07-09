package msz.javabasics;

import msz.javabasics.TestUtils.Oranges;
import org.junit.Test;

import static msz.javabasics.TestUtils.*;
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
        till.addCart(new Cart().addItem(Apples.one()));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_APPLE));
    }
    @Test
    public void shouldChargeForOneOrange(){
        Till till = new Till();
        till.addCart(new Cart().addItem(Oranges.one()));

        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_ORANGE));
    }

    @Test
    public void shouldChargeFor3Apples(){
        Till till = new Till();
        till.addCart(new Cart().addItems(Apples.many(3)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(3 * PRICE_APPLE));
    }

    @Test
    public void shouldChargeFor2Oranges(){
        Till till = new Till();
        till.addCart(new Cart().addItems(Oranges.many(2)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(2 * PRICE_ORANGE));
    }

    @Test
    public void shouldChargeFor2OrangesAnd4Apples(){
        Till till = new Till();
        till.addCart(new Cart().addItems(Oranges.many(2)).addItems(Apples.many(4)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(2 * PRICE_ORANGE + 4 * PRICE_APPLE));
    }

    @Test
    public void shouldChargeFor2OrangesAnd1AppleParsed(){
        Till till = new Till();
        till.addCart(Cart.parse("orange,apple,orange"));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(2 * PRICE_ORANGE + PRICE_APPLE));
    }
}
