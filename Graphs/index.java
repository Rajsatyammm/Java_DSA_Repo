
 package Graphs;
import java.util.*;

public class index {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

    }

    // old bfs
    public static void oldBfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int val = q.remove();
            if (!vis[val]) {
                System.out.print(val + " ");
                vis[val] = true;
                for (int i = 0; i < graph[val].size(); i++) {
                    Edge e = graph[val].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // old dfs
    public static void oldDfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        dfsHelper(graph, vis, 0);
    }

    public static void dfsHelper(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsHelper(graph, vis, e.dest);
            }
        }
    }

    // Modified BFS
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Modified DFS
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, vis, i);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, vis, e.dest);
            }
        }
    }

    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        // oldBfs(graph);
        // oldDfs(graph);
        // bfs(graph);
        dfs(graph);
    }
}
