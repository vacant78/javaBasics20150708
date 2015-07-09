package msz.javabasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class Cart {
    private final List<Apple> apples = new ArrayList<>();
    private final List<Orange> oranges = new ArrayList<>();
    ;

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
}
