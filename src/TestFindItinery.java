import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFindItinery {

    /**
     * this test case is all nodes have the same in-degree and out-degree
     */
    @Test
    public void testCaseOne(){
        FindItinery fi = new FindItinery();
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket = new ArrayList<>();
        ticket.add("JFK");
        ticket.add("DTW");
        tickets.add(ticket);
        ticket = new ArrayList<>();
        ticket.add("DTW");
        ticket.add("ATL");
        tickets.add(ticket);
        ticket = new ArrayList<>();
        ticket.add("ATL");
        ticket.add("JFK");
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("JFK");
        expectedResult.add("DTW");
        expectedResult.add("ATL");
        assertEquals(expectedResult,fi.findItinery(tickets));
    }
    /**
     * this test case is all nodes BUT TWO have the same in-degree and out-degree:
     * STARTER: one node's in-degree minus out-degree is 1;
     * ENDER: one node's in-degree minus out-degree is -1.
     */
    @Test
    public void testCaseTwo() {
        FindItinery fi = new FindItinery();
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket = new ArrayList<>();
        ticket.add("JFK");
        ticket.add("DTW");
        tickets.add(ticket);
        ticket = new ArrayList<>();
        ticket.add("DTW");
        ticket.add("ATL");
        tickets.add(ticket);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("JFK");
        expectedResult.add("DTW");
        expectedResult.add("ATL");
        assertEquals(expectedResult,fi.findItinery(tickets));


    }
}
