import java.util.*;
import java.util.stream.Collectors;

public class Approximation {
    private static Set<String> statesNeeded = new HashSet<>() {
        {
            addAll(List.of("mt", "wa", "or", "id", "nv", "ut"));
        }
    };
    private static final Map<String, Set<String>> stations = Map.of(
            "kone", Set.of("id", "nv", "ut"),
            "ktwo", Set.of("wa", "id", "mt"),
            "kthree", Set.of("or", "nv", "ca"),
            "kfour", Set.of("nv", "ut"),
            "kfive", Set.of("ca", "az")
    );

    private final static Set<String> finalStations = new HashSet<>();

    public static void main(String[] args) {
        while(!statesNeeded.isEmpty()) {
            Set<String> statesCovered = Set.of();
            String bestStation = "";
            for (var entry: stations.entrySet()) {
                var covered = statesNeeded.stream()
                        .filter(needed -> entry.getValue().contains(needed)).collect(Collectors.toSet());
                if(covered.size()>statesCovered.size()) {
                    bestStation = entry.getKey();
                    statesCovered = covered;
                }
            }
            finalStations.add(bestStation);
            Set<String> finalStatesCovered = statesCovered;
            statesNeeded = statesNeeded.stream()
                    .filter(needed -> !finalStatesCovered.contains(needed))
                    .collect(Collectors.toSet());
        }
        System.out.println(finalStations);
    }
}
