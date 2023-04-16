package PPT15;
/*
Given a directed Graph G(V, E) with V vertices and E edges, the task is to
check that for all vertices of the given graph, the incoming edges in a vertex
is equal to the vertex itself or not.
*/

import java.util.*;

class JavaProgram4{

    // A utility function to add an edge in an directed graph
    static void add_edge(Vector<Integer> adj[],
                         int x, int y)
    {
        adj[x].add(y);
    }

    // Function to check that given graph
// in-degree value equal to vertex value
    static boolean Indegree(Vector<Integer> adj[],
                            int v)
    {

        // Create array indeg
        // initialized to zero
        int indeg[] = new int[v];

        // Traversing across all
        // vertex to compute
        // in degree value
        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < adj[i].size(); j++)
            {
                indeg[adj[i].get(j)]++;
            }
        }

        // Check in degree value
        // equal to vertex value
        for(int i = 0; i < v; i++)
        {
            if (i == indeg[i])
                continue;
            else
                return false;
        }
        return true;
    }


    public static void main(String[] args)
    {

        int v = 4;

        // To store adjacency list of graph
        @SuppressWarnings("unchecked")
        Vector<Integer> []adj = new Vector[v];
        for(int i = 0; i < adj.length; i++)
            adj[i] = new Vector<Integer>();

        add_edge(adj, 0, 1);
        add_edge(adj, 1, 2);
        add_edge(adj, 0, 2);
        add_edge(adj, 0, 3);
        add_edge(adj, 1, 3);
        add_edge(adj, 2, 3);

        if (Indegree(adj, v))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}

