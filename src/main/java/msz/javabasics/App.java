package msz.javabasics;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class App {

    public static void main(String[] args){
        if(args == null || args.length == 0 || args.length > 2) {
            throw new IllegalArgumentException();
        }

        Till till = new Till();
        till.addCart(Cart.parse(args[0]));

        if(args.length == 2) {
            addDiscount(till, args[1]);
        }

        System.out.print(till.getTotal());

    }

    private static void addDiscount(Till till, String serializedDiscounts) {
        Discount.parse(serializedDiscounts).forEach(discount -> till.addDiscount(discount));
    }
}
