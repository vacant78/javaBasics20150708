package msz.javabasics;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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

    @Test
    public void shouldPrintResultsToSystemOut() {
        App.main(new String[]{"Apple,Orange"});
        assertThat(outContent.toString(), equalTo("£0.85"));
    }

}