package msz.javabasics;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class Apple implements Item{
    private static final int PRICE=60;

    @Override
    public int getPrice(){
        return PRICE;
    }
}
