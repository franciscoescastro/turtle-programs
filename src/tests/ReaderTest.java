package tests;

import edu.sdsu.parse.Reader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReaderTest {
    @Test
    public void testGetText() {
        String expectedText = "penDown $k = 2 repeat $k repeat $k move 15 turn 40 end $k = 3 end ";

        Reader reader = new Reader();
        reader.readFile("src/tests/input/input6");

        assertEquals(expectedText, reader.getText());
    }
}
