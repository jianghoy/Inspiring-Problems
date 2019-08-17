import org.junit.Test;

import static org.junit.Assert.*;

public class TestTreeCheck {

    @Test
    public void testRightCase() {
        TreeCheck tc = new TreeCheck();
        int[][] relationOne = new int[][]{{0,1}};
        assertEquals("(0(1))",tc.treeCheck(relationOne,2));
        tc.treeCheck(null,1);
        int[][] relationTwo = new int[][]{{0,1},{0,2}};
        assertEquals("(0(1)(2))",tc.treeCheck(relationTwo,3));
        int[][] relationThree = new int[][]{{0,1},{1,2}};
        assertEquals("(0(1(2)))",tc.treeCheck(relationThree,3));
        int[][] relationFour = new int[][]{{0,1},{1,2},{0,3}};
        assertEquals("(0(1(2))(3))",tc.treeCheck(relationFour,4));
    }
    @Test
    public void testCycle() {
        TreeCheck tc = new TreeCheck();
        int[][] relation = new int[][]{{0,1},{1,2},{2,0}};
        assertEquals("E3",tc.treeCheck(relation,3));

    }

    @Test
    public void testSelfCycling() {
        TreeCheck tc = new TreeCheck();
        int[][] relation = new int[][]{{0,0}};
        assertEquals("E5",tc.treeCheck(relation,1));
        relation = new int[][]{{0,0},{1,1},{2,2}};
        assertEquals("E5",tc.treeCheck(relation,3));
    }

    @Test
    public void testForest() {
        TreeCheck tc = new TreeCheck();
        int[][] relation = new int[][]{{0,1},{2,3}};
        assertEquals("E4",tc.treeCheck(relation,4));
    }

    @Test
    public void testMultiChildren() {
        TreeCheck tc = new TreeCheck();
        int[][] relation = new int[][]{{0,1},{0,2},{0,3}};
        assertEquals("E1",tc.treeCheck(relation,4));
    }

    @Test
    public void testMultiParent() {
        TreeCheck tc = new TreeCheck();
        int[][] relation = new int[][]{{0,1},{2,1}};
        assertEquals("E3",tc.treeCheck(relation,3));
    }
}
