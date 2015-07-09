package msz.javabasics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class CartTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnInvalidInput() {
        Cart.parse("banana");
    }

    @Test
    public void shouldParse() throws Exception {
        Cart cart = Cart.parse("apple,orange");
        assertThat(cart.getCartValue(), is(not(equalTo(0))));
    }
}