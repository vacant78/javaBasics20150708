package msz.javabasics;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class Orange implements Item{
    private static final int PRICE=25;

    @Override
    public int getPrice(){
        return PRICE;
    }
}
