package msz.javabasics;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class Till {

    private Cart cart;

    public void addCart(Cart cart) {
        this.cart = cart;
    }

    public int getTotalInCentisimal() {
        return calculateCartValue();

    }

    private int calculateCartValue() {
        return cart.getCartValue();
    }

    public String getTotal() {
        int cents=calculateCartValue();
        return String.format("£%2.02f",cents / 100d);
    }
}
