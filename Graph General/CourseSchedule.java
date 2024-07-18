import java.util.*;

class CouseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph and calculate in-degrees
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        // Step 2: Perform topological sorting using BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Step 3: Check if all courses can be completed
        return count == numCourses;
    }
}


//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 
//1. You are given an array prerequisites where prerequisites[i] = [ai, bi] 
//indicates that you must take course bi first if you want to take course ai.

//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.