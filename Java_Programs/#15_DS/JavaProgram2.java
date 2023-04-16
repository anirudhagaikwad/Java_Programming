package PPT15;

/*
Given a tree with N nodes. The task is to color the tree with the minimum number of colors(K) such that the colors of the edges incident to a vertex are different. Print K in first-line and then in next line print N – 1 space-separated integer represents the colors of the edges. Examples:

Input: N = 3, edges[][] = {{0, 1}, {1, 2}}
                   0
                  /
                 1
                /
               2
Output:
2
1 2
                   0
                  / (1)
                 1
                / (2)
               2

*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class JavaProgram2 {

    // Add an edge between the vertexes
    public static void addEdge(List<List<Integer>> gr, int x, int y, List<int[]> edges) {
        gr.get(x).add(y);
        gr.get(y).add(x);
        edges.add(new int[] { x, y });
    }

    // Function to color the tree with minimum
    // number of colors such that the colors of
    // the edges incident to a vertex are different
    public static void colorTree(int n, List<List<Integer>> gr, List<int[]> edges) {
        // To store the minimum colors
        int K = 0;

        // To store color of the edges
        Map<int[], Integer> color = new TreeMap<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        // Color of edge between its parent
        int[] cs = new int[n];

        // To check if the vertex is
        // visited or not
        boolean[] used = new boolean[n];

        Queue<Integer> que = new LinkedList<>();
        used[0] = true;
        que.offer(0);

        while (!que.isEmpty()) {
            // Take first element of the queue
            int v = que.poll();

            // Take the possible value of K
            if (K < gr.get(v).size()) {
                K = gr.get(v).size();
            }

            // Current color
            int cur = 1;

            for (int u : gr.get(v)) {
                // If vertex is already visited
                if (used[u]) {
                    continue;
                }

                // If the color is similar
                // to it's parent
                if (cur == cs[v]) {
                    cur++;
                }

                // Assign the color
                cs[u] = color.put(new int[] { u, v }, cur) == null ? cur : color.get(new int[] { u, v });
                color.put(new int[] { v, u }, cs[u]);
                cur++;

                // Mark it visited
                used[u] = true;

                // Push into the queue
                que.offer(u);
            }
        }

        // Print the minimum required colors
        System.out.println(K);

        // Print the edge colors
        for (int[] p : edges) {
            System.out.print(color.get(p) + " ");
        }
    }


    public static void main(String[] args) {
        int n = 8;

        List<List<Integer>> gr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }
        List<int[]> edges = new ArrayList<>();

        // Add edges
        addEdge(gr, 0, 1, edges);
        addEdge(gr, 1, 2, edges);
        addEdge(gr, 1, 3, edges);
        addEdge(gr, 1, 4, edges);
        addEdge(gr, 3, 6, edges);
        addEdge(gr, 4, 5, edges);
        addEdge(gr, 5, 7, edges);

        // Function call
        colorTree(n, gr, edges);
    }
}


