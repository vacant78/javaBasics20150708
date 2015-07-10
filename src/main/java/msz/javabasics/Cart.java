package msz.javabasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class Cart {
    private final List<Item> content = new ArrayList<>();


    public Cart() {
    }


    public Cart addItem(Item apple) {
        content.add(apple);
        return this;
    }

    public Cart addItems(Collection<? extends Item> items) {
        this.content.addAll(items);
        return  this;
    }

    public int getCartValue() {
        return content.stream().mapToInt(Item::getPrice).sum();
    }

    public int getDiscount(Collection<Discount> discounts) {
        int totalDiscount = 0;
        for(Discount discount : discounts) {
            totalDiscount += discount.applyPromotionDiscount(content);
        }
        return  totalDiscount;
    }

    public static Cart parse(String serializedCart) {
        Cart cart = new Cart();

        for(String item: serializedCart.split(",")){
                    if(Item.ORANGE.equalsIgnoreCase(item)) {
                        cart.addItem(new Orange());
                    } else if(Item.APPLE.equalsIgnoreCase(item)) {
                        cart.addItem(new Apple());
                    } else throw new IllegalArgumentException("Cannot parse item: "+item);
        }
        return cart;
    }
}
