package Graphs;
import java.util.*;
public class firstClass {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

//        graph[0].add(new Edge(0, 1, 0));
//        graph[0].add(new Edge(0, 2));
//
//        graph[1].add(new Edge(1, 0));
//        graph[1].add(new Edge(1, 3));
//
//        graph[2].add(new Edge(2, 0));
//        graph[2].add(new Edge(2, 4));
//
//        graph[3].add(new Edge(3, 1));
//        graph[3].add(new Edge(3, 4));
//        graph[3].add(new Edge(3, 5));
//
//        graph[4].add(new Edge(4, 2));
//        graph[4].add(new Edge(4, 3));
//        graph[4].add(new Edge(4, 5));
//
//        graph[5].add(new Edge(5, 3));
//        graph[5].add(new Edge(5, 4));
//        graph[5].add(new Edge(5, 6));
//
//        graph[6].add(new Edge(6, 5));

//        graph[0].add(new Edge(0, 1));
//        graph[0].add(new Edge(0, 2));
//
//        graph[1].add(new Edge(1, 0));
//        graph[1].add(new Edge(1, 3));
//
//        graph[2].add(new Edge(2, 0));
//        graph[2].add(new Edge(2, 4));
//
//        graph[3].add(new Edge(3, 1));
//        graph[3].add(new Edge(3, 4));
//
//        graph[4].add(new Edge(4, 2));
//        graph[4].add(new Edge(4, 3));

        //directed

//        graph[0].add(new Edge(0, 2));
//        graph[0].add(new Edge(0, 1));
//        graph[1].add(new Edge(1, 3));
//        graph[2].add(new Edge(2, 3));

        //top sort
        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 1, 0));
        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));
        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i])
                bfsUtil(graph, vis, i);
        }
    }
    private static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);


    }

    public static void dfs(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i]) dfsUtil(graph, vis, i);
        }
    }
    private static void dfsUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
                dfsUtil(graph, vis, e.dest);
        }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] vis, int src, int dest) {
        if(src == dest) return true;
        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, vis, e.dest, dest)) return true;
        }
        return false;
    }


    public static boolean isCycleUndirected(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                if(isCycleUndirectedUtil(graph, vis, i, 0)) return true;
            }
        }
        return false;
    }

    private static boolean isCycleUndirectedUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                if(isCycleUndirectedUtil(graph, vis, e.dest, curr));
            }
            if(vis[e.dest] && e.dest != par) return true;
        }
        return false;
    }

    public static boolean isCycleDirected(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] stack = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!vis[i])
                if(isCycleDirectedUtil(graph, vis, stack, i)) return true;
        }
        return false;
    }

    private static boolean isCycleDirectedUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i< graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest])
                return true;
            else if(!vis[e.dest]) {
                if(isCycleDirectedUtil(graph, vis, stack, e.dest)) return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        Arrays.fill(col, -1);
        for(int i=0; i< graph.length; i++) {
            if(col[i] == -1) {
                col[i] = 0;
                if(isBipartiteUtil(graph, col, i))
                    return true;
            }
        }
        return false;
    }

    private static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int[] col, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int j=0; j<graph[curr].size(); j++) {
                int nextCol = col[curr] == 1 ? 0 : 1;
                Edge e = graph[curr].get(j);
                if(col[e.dest] == -1) {
                    col[e.dest] = nextCol;
                    q.add(e.dest);
                }
                else if(col[e.dest] == col[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void topSortDfs(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                topSortDfsUtil(graph, vis, s, i);
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    private static void topSortDfsUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortDfsUtil(graph, vis, s, e.dest);
            }
        }
        s.push(curr);
    }
    private static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSortBfs(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(indeg[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if(indeg[e.dest] == 0) q.add(e.dest);
            }
        }
    }

    public static void dijkastra() {

    }

    public static void bellmanFord() {

    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        boolean[] vis = new boolean[V];
        createGraph(graph);

//        System.out.print("bfs is : -> ");
//        bfs(graph);
//        System.out.println();
//        System.out.print("dfs is : -> ");
//        dfs(graph);

//        System.out.println("isBipartite -> " + isBipartite(graph));
//        System.out.println(hasPath(graph, vis, 0, 6));
//        System.out.println(isCycleDirected(graph));
//        topSortDfs(graph);
        topSortBfs(graph);
    }


}
