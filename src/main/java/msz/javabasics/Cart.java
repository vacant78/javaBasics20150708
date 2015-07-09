package msz.javabasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class Cart {
    private static final String APPLE = "APPLE";
    private static final String ORANGE = "ORANGE";
    private final List<Apple> apples = new ArrayList<>();
    private final List<Orange> oranges = new ArrayList<>();


    public Cart() {
    }


    public Cart addOranges(Collection<Orange> orange) {
        oranges.addAll(orange);
        return this;
    }

    public Cart addApples(Collection<Apple> apples) {

        this.apples.addAll(apples);
        return  this;

    }

    public int getCartValue() {
        return apples.stream().mapToInt(Apple::getPrice).sum()
                + oranges.stream().mapToInt(Orange::getPrice).sum();
    }

    public Cart addApple(Apple apple) {
        apples.add(apple);
        return this;
    }

    public Cart addOrange(Orange orange) {
        oranges.add(orange);
        return this;
    }

    public static Cart parse(String serializedCart) {
        Cart cart = new Cart();

        for(String item: serializedCart.split(",")){
                    if(ORANGE.equalsIgnoreCase(item)) {
                        cart.addOrange(new Orange());
                    } else if(APPLE.equalsIgnoreCase(item)) {
                        cart.addApple(new Apple());
                    } else throw new IllegalArgumentException("Cannot parse item: "+item);
        }
        return cart;
    }
}
