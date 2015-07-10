package msz.javabasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public abstract class Discount {
    private final Class<?> discountedItem;
    private final int discountValue;

    public Discount(Class<?> discountedItem, int discountValue) {
        this.discountedItem = discountedItem;
        this.discountValue = discountValue;
    }

    public static Discount buyOneGetOneFree(Class<? extends Item> promotedItem, int discountValue) {
        return new BuyOneGetOneFree(promotedItem, discountValue);
    }

    public static Discount get3ForPriceOf2(Class<? extends Item> promotedItem, int discountValue) {
        return new Get3ForPriceOf2(promotedItem, discountValue);
    }

    public abstract int applyPromotionDiscount(Collection<Item> items);

    public static Collection<Discount> parse(String serializedDiscounts) {
        List<Discount> discounts = new ArrayList<>();
        for (String discount : serializedDiscounts.split(",")) {
            discounts.add(parseDiscount(discount));
        }
        return discounts;
    }

    private static Discount parseDiscount(String discount) {
        String[] typeAndItem = discount.split(":");
        if (typeAndItem.length != 2) {
            throw new IllegalArgumentException("cannot parse discount: " + discount);
        }
        String discountName = typeAndItem[0];
        String itemName = typeAndItem[1];
        Class<? extends Item> discItem;

        if (Item.APPLE.equalsIgnoreCase(itemName)) {
            discItem = Apple.class;
        } else if (Item.ORANGE.equalsIgnoreCase(itemName)) {
            discItem = Orange.class;
        } else throw new IllegalArgumentException("cannot parse discount item " + itemName);
        try {
        if ("buy1get1free".equalsIgnoreCase(discountName)) {
                return buyOneGetOneFree(discItem, discItem.newInstance().getPrice());
        } else if("get3for2".equalsIgnoreCase(discountName)){
            return get3ForPriceOf2(discItem, discItem.newInstance().getPrice());
        } else {
            throw new IllegalArgumentException("Cannot parse discount type");
        }
        } catch (InstantiationException |IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public static class BuyOneGetOneFree extends Discount {

        public BuyOneGetOneFree(Class<? extends Item> clazz, int discountValue) {
            super(clazz, discountValue);
        }

        @Override
        public int applyPromotionDiscount(Collection<Item> items) {

            int discountCount = (int) items.stream().filter((i) -> i.getClass().equals(super.discountedItem)).count() / 2;
            return discountCount * super.discountValue;
        }
    }

    public static class Get3ForPriceOf2 extends Discount{

        public Get3ForPriceOf2(Class<? extends Item> promotedItem, int discountValue) {
            super(promotedItem, discountValue);
        }

        @Override
        public int applyPromotionDiscount(Collection<Item> items) {
            int discountCount = (int) items.stream().filter((i) -> i.getClass().isInstance(super.discountedItem)).count() / 3;
            return discountCount * super.discountValue;
        }
    }
}
