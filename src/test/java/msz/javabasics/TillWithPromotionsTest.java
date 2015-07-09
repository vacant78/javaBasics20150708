package msz.javabasics;

import msz.javabasics.TestUtils.Oranges;
import org.junit.Test;

import static msz.javabasics.TestUtils.Apples;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class TillWithPromotionsTest {


    public static final int PRICE_APPLE = 60;
    private static final int PRICE_ORANGE = 25;

    @Test
    public void shouldChargeZeroOnEmptyCart(){
        Till till = getTillWithPromotions();
        till.addCart(new Cart());
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(0));
    }

    @Test
    public void shouldChargeForOneApple(){
        Till till = getTillWithPromotions();
        till.addCart(new Cart().addItem(Apples.one()));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_APPLE));
    }
    @Test
    public void shouldChargeForOneOrange(){
        Till till = getTillWithPromotions();
        till.addCart(new Cart().addItem(Oranges.one()));

        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_ORANGE));
    }

    @Test
    public void shouldApplyPromoOn2Apples(){
        Till till = getTillWithPromotions();
        till.addCart(new Cart().addItems(Apples.many(2)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(PRICE_APPLE));
    }

    @Test
    public void shouldApplyPromoOn4Oranges(){
        Till till = getTillWithPromotions();
        till.addCart(new Cart().addItems(Oranges.many(3)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(3 * PRICE_ORANGE));
    }

    @Test
    public void shouldApplyPromoOn3OrangesAnd3Apples(){
        Till till = getTillWithPromotions();
        till.addCart(new Cart().addItems(Oranges.many(2)).addItems(Apples.many(4)));
        int total = till.getTotalInCentisimal();
        assertThat(total, equalTo(2 * PRICE_ORANGE + 2 * PRICE_APPLE));
    }

    private Till getTillWithPromotions(){
        Till till = new Till();
        till.addDiscount(Discount.buyOneGetOneFree(Apple.class, new Apple().getPrice()));
        till.addDiscount(Discount.get3ForPriceOf2(Orange.class, new Orange().getPrice()));
        return till;
    }

}
