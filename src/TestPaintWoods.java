import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestPaintWoods {
    private PaintWoods pw = new PaintWoods();


    @Test
    public void testKEqualsOne(){
        assertEquals(15,pw.minTime(new int[]{3,5,7},1));
        assertEquals(5,pw.minTime(new int[]{5},1));
    }

    @Test
    public void testKEqualsWoodsLength() {
        assertEquals(7,pw.minTime(new int[]{3,5,7},6));
        assertEquals(5,pw.minTime(new int[]{5},9));
    }

    @Test
    public void testRandomK() {
        assertEquals(8, pw.minTime(new int[]{3,5,5,3},2));
        assertEquals(9, pw.minTime(new int[]{3,5,5,4},2));
        assertEquals(8, pw.minTime(new int[]{3,5,5,4},3));
    }



    @Test
    public void print() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append('A'+1).toString());
    }
}
