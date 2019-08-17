import java.util.*;

public class FindItinery {
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
