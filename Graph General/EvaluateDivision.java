import java.util.*;

class EvaluateDivision {
    private Map<String, Map<String, Double>> graph = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph
        buildGraph(equations, values);
        
        // Step 2: Process each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(start, end, 1, visited);
            }
        }
        return results;
    }
    
    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String A = equation.get(0);
            String B = equation.get(1);
            double value = values[i];
            
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, value);
            graph.get(B).put(A, 1 / value);
        }
    }
    
    private double dfs(String current, String target, double value, Set<String> visited) {
        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);
        
        if (neighbors.containsKey(target)) {
            return value * neighbors.get(target);
        }
        
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), target, value * neighbor.getValue(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        
        return -1.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );
        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results)); // Output: [6.0, 0.5, -1.0, 1.0, -1.0]
    }
}


//You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] 
//represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

//You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

//Return the answers to all queries. If a single answer cannot be determined, return -1.0.

//Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero 
//and that there is no contradiction.

//Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.