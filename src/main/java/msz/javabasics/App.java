package msz.javabasics;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class App {

    public static void main(String[] args){
        if(args == null || args.length > 1) {
            throw new IllegalArgumentException();
        }

        Till till = new Till();
        till.addCart(Cart.parse(args[0]));
        System.out.print(till.getTotal());

    }
}
