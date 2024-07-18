import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.insert(0, "/" + dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String path1 = "/home/";
        String path2 = "/../";
        String path3 = "/home//foo/";
        String path4 = "/a/./b/../../c/";
        String path5 = "/a/../../b/../c//.//";

        System.out.println(solution.simplifyPath(path1)); // Output: "/home"
        System.out.println(solution.simplifyPath(path2)); // Output: "/"
        System.out.println(solution.simplifyPath(path3)); // Output: "/home/foo"
        System.out.println(solution.simplifyPath(path4)); // Output: "/c"
        System.out.println(solution.simplifyPath(path5)); // Output: "/c"
    }
}


//Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.

//In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." 
//denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, 
//treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.

//The simplified canonical path should adhere to the following rules:

//It must start with a single slash '/'.
//Directories within the path should be separated by only one slash '/'.
//It should not end with a slash '/', unless it's the root directory.
//It should exclude any single or double periods used to denote current or parent directories.
//Return the new path.