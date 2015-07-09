package msz.javabasics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        till.addCart(new Cart().addApple(Apples.one()));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_APPLE));
    }
    @Test
    public void shouldChargeForOneOrange(){
        Till till = new Till();
        till.addCart(new Cart().addOrange(Oranges.one()));

        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_ORANGE));
    }

    @Test
    public void shouldChargeFor3Apples(){
        Till till = new Till();
        till.addCart(new Cart().addApples(Apples.many(3)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(3 * PRICE_APPLE));
    }

    @Test
    public void shouldChargeFor2Oranges(){
        Till till = new Till();
        till.addCart(new Cart().addOranges(Oranges.many(2)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(2 * PRICE_ORANGE));
    }

    @Test
    public void shouldChargeFor2OrangesAnd4Apples(){
        Till till = new Till();
        till.addCart(new Cart().addOranges(Oranges.many(2)).addApples(Apples.many(4)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(2 * PRICE_ORANGE + 4 * PRICE_APPLE));
    }



    private static class Apples {
        public static Apple one() {
            return new Apple();
        }
        public static Collection<Apple> many(int howMany) {
            List<Apple> list = new ArrayList<>(howMany);
            for(int i=0;i<howMany;i++) {
                list.add(new Apple());
            }
            return list;
        }
    }
    private static class Oranges {
        public static Orange one() {
            return new Orange();
        }
        public static Collection<Orange> many(int howMany) {
            List<Orange> list = new ArrayList<>(howMany);
            for(int i=0;i<howMany;i++) {
                list.add(new Orange());
            }
            return list;
        }
    }
}
