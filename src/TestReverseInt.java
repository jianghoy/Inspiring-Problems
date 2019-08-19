import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestReverseInt {

    @Test
    public void testReverseAll() {
        ReverseInteger ri = new ReverseInteger();
        assertEquals(1,ri.reverseAllInt(2,2));
        assertEquals(1,ri.reverseAllInt(4,3));
        assertEquals(2,ri.reverseAllInt(2,3));

        assertEquals(1,ri.reverseAllInt(8,4));
    }
}
