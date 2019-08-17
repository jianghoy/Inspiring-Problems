import java.util.*;

public class FindItinery {
    /**
     * time complexity: O(V+E)
     * space complexity: O(V+E) heap
     *                   O(V) stack
     * @param tickets： a list of lists in such format:
     *                  {String:from,String:to}. e.g.
     *                  {JFK,DTW} means from JFK airport(New York,NY) to DTW airport
     *                  (Ann Arbor, MI)
     * @return a list of string represent the Eulerian Path in lex. order.
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // build graph
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket:tickets) {
            PriorityQueue<String> neighbors = graph.getOrDefault(ticket.get(0),new PriorityQueue<>());
            neighbors.offer(ticket.get(1));
            graph.put(ticket.get(0),neighbors);
        }
        List<String> path = new ArrayList<>();
        traverse("JFK",graph,path);
        Collections.reverse(path);
        return path;
    }

    private void traverse(String start, Map<String, PriorityQueue<String>> graph, List<String> path) {
        PriorityQueue<String> neighbors = graph.get(start);
        if (neighbors == null) {
            path.add(start);
            return;
        }
        while (!neighbors.isEmpty()) {
            String neighbor = neighbors.poll();
            traverse(neighbor,graph,path);
        }
        path.add(start);
    }

}
