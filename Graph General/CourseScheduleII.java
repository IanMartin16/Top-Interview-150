import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Create an array to keep track of in-degrees (number of incoming edges)
        int[] inDegree = new int[numCourses];
        
        // Populate the graph and in-degree array based on the prerequisites
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            graph.get(prereqCourse).add(course);
            inDegree[course]++;
        }

        // Use a queue to perform the topological sort
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all courses with 0 in-degree to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // List to store the order of courses
        List<Integer> order = new ArrayList<>();
        
        // Process nodes with 0 in-degree
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);
            
            // Reduce the in-degree of each neighboring node by 1
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If the order list doesn't contain all courses, return an empty array
        if (order.size() != numCourses) {
            return new int[0];
        }

        // Convert the order list to an array and return it
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = cs.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order)); // Output: [0, 1, 2, 3] or [0, 2, 1, 3]
    }
}


//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 
//1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first 
//if you want to take course ai.

//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. 
//If it is impossible to finish all courses, return an empty array.