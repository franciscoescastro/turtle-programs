package tests;

import edu.sdsu.program.Context;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContextTest {
    private static final String DISTANCE = "$distance";
    private static final String LENGTH = "$length";
    private Context context;

    @Before
    public void setUp() {
        context = new Context();
        context.put(DISTANCE, 10);
        context.put(LENGTH, 20);
    }

    @Test
    public void testGet() {
        assertEquals(10, context.get(DISTANCE).intValue());
        assertEquals(20, context.get(LENGTH).intValue());
    }

    @Test
    public void testSize() {
        assertEquals(2, context.size());
    }
}
