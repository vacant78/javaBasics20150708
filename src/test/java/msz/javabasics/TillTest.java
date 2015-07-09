package msz.javabasics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class TillTest {


    @Test
    public void shouldChargeZeroOnEmptyCart(){
        Till till = new Till();
        till.addCart(new Cart());
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(0));
    }
}
