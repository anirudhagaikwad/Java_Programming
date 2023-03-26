package PPT15;
/*
Given an array arr[][] consisting of N pairs such that each pair {L, R} represents that ith house can be painted in L number of days before the Rth day, the task is to find the maximum number of house that can be painted continuously.

Examples:
Input: N = 4, paint[ ][ ] = [[1, 19], [2, 2], [4, 17], [1, 1]]
Output: 3
Explanation: Maximum of three houses can be painted and order is {4, 3, 1}
*/
import java.util.*;

public class JavaProgram1 {

    // Pair class
    static class Pair {
        int x, y;

        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    // Comparator to sort by second element
    static class SortBySecond implements Comparator<Pair> {
        public int compare(Pair a, Pair b)
        {
            return a.y - b.y;
        }
    }

    public static void main(String[] args)
    {

        // Given Input
        int n = 4;
        int[][] paint
                = { { 1, 19 }, { 2, 2 }, { 4, 17 }, { 1, 1 } };

        // Vector to store the pairs
        ArrayList<Pair> V = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {

            // If house can be painted
            if (paint[i][0] <= paint[i][1]) {
                V.add(new Pair(paint[i][0], paint[i][1]));
            }
        }

        // Sort the vector
        V.sort(new SortBySecond());

        // If vector is empty
        if (V.size() == 0) {
            System.out.println(0);
            return;
        }

        // Initialize t
        int t = V.get(0).x;

        // Initialize priority queue
        PriorityQueue<Pair> pq
                = new PriorityQueue<>(new SortBySecond());
        pq.add(V.get(0));

        // Traversing the vector
        for (int i = 1; i < V.size(); i++) {
            t += V.get(i).x;

            // Pushing in Vectors
            pq.add(V.get(i));
            if (t <= V.get(i).y) {
                continue;
            }
            else {

                // Pop the top element
                Pair temp = pq.poll();
                t = t - temp.x;
            }
        }

        // Print the ans
        System.out.println(pq.size());
    }
}

