import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRandomSet {

    @Test
    public void testAdd(){
        RandomSet rs = new RandomSet();
        rs.insert(1);
        rs.insert(2);
        rs.insert(3);
        rs.remove(1);
        rs.remove(2);
        assertEquals(3,rs.getRandom());
    }
}
