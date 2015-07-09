package msz.javabasics;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by SzatanskiM on 09/07/2015.
 */
public class AppIT {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void before(){
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void after(){
        System.setOut(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnInvalidInput() {
        App.main(null);
    }

}