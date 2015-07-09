package msz.javabasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class TestUtils {


    public static class Apples {
        public static Apple one() {
            return new Apple();
        }
        public static Collection<Apple> many(int howMany) {
            List<Apple> list = new ArrayList<>(howMany);
            for(int i=0;i<howMany;i++) {
                list.add(new Apple());
            }
            return list;
        }
    }
    public static class Oranges {
        public static Orange one() {
            return new Orange();
        }
        public static Collection<Orange> many(int howMany) {
            List<Orange> list = new ArrayList<>(howMany);
            for(int i=0;i<howMany;i++) {
                list.add(new Orange());
            }
            return list;
        }
    }
}
