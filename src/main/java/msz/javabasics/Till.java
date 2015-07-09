package msz.javabasics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class Till {

    private Cart cart;
    private final Collection<Discount> discounts = new ArrayList<>();

    public void addCart(Cart cart) {
        this.cart = cart;
    }

    public int getTotalInCentisimal() {
        return calculateCartValue();

    }

    private int calculateCartValue() {
        int cartValueNoDiscount = cart.getCartValue();
        int discount = cart.getDiscount(discounts);
        return cartValueNoDiscount - discount;
    }

    public String getTotal() {
        int cents=calculateCartValue();
        return String.format("£%2.02f", cents / 100d);
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);

    }
}
