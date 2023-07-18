import java.util.*;

public class BFSGraphs {

    private static final Map<String, List<String>> graph = new HashMap<>();

    static {
        graph.put("you", List.of("alice", "bob", "claire"));
        graph.put("bob", List.of("anuj", "peggy"));
        graph.put("alice", List.of("peggy"));
        graph.put("claire", List.of("thom", "jonny"));
        graph.put("anuj", List.of());
        graph.put("peggy", List.of());
        graph.put("thom", List.of());
        graph.put("jonny", List.of());
    }

    private static boolean personIsSeller(String name) {
        return name.endsWith("m");
    }

    public static String search(String name) {
        var queue = new LinkedList<>(graph.get(name));
        var searched = new ArrayList<String>();
        while (!queue.isEmpty()) {
            var person = queue.pop();
            if (searched.contains(person)) {
                continue;
            }
            if (personIsSeller(person)) {
                return person + " is a mango seller!";
            } else {
                searched.add(person);
                queue.addAll(graph.get(person));
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(search("you"));
    }
}
