class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(course).add(prereq);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

       
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, visited, path, i)) {
                    return false; 
                }
            }
        }

        return true; 
    }

    public boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] path, int course) {
        visited[course] = true;
        path[course] = true;

        for (int neighbor : graph.get(course)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, visited, path, neighbor)) return true;
            } else if (path[neighbor]) {
                return true; 
            }
        }

        path[course] = false;
        return false;
    }
}
