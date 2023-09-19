
 package Graphs;
import java.util.*;

public class Classroom {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        // ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // // 0 ->
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // // 1 ->
        // graph[1].add(new Edge(1, 0, 1));
        // // graph[1].add(new Edge(1, 3, 1));

        // // 2 ->
        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // // 3 ->
        // graph[3].add(new Edge(3, 1, 1));
        // // graph[3].add(new Edge(3, 4, 1));
        // // graph[3].add(new Edge(3, 5, 1));

        // // 4 ->
        // graph[4].add(new Edge(4, 2, 1));
        // // graph[4].add(new Edge(4, 3, 1));
        // graph[4].add(new Edge(4, 5, 1));

        // // 5 ->
        // // graph[4].add(new Edge(5, 3, 1));
        // graph[4].add(new Edge(5, 4, 1));
        // graph[4].add(new Edge(5, 6, 1));

        // // 6 ->
        // graph[6].add(new Edge(6, 5, 1));

        // graph[0].add(new Edge(0, 1, 1));
        // // graph[0].add(new Edge(0, 2, 1));
        // graph[0].add(new Edge(0, 3, 1));

        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 2, 1));

        // // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 1, 1));

        // graph[3].add(new Edge(3, 0, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // graph[4].add(new Edge(4, 3, 1));

        // graph[0].add(new Edge(0, 1, 0));
        // graph[0].add(new Edge(0, 2, 0));

        // graph[1].add(new Edge(1, 0, 0));
        // graph[1].add(new Edge(1, 3, 0));

        // graph[2].add(new Edge(2, 0, 0));
        // graph[2].add(new Edge(2, 4, 0));

        // graph[3].add(new Edge(3, 1, 0));
        // graph[3].add(new Edge(3, 4, 0));

        // graph[4].add(new Edge(4, 2, 0));
        // graph[4].add(new Edge(4, 3, 0));

        // graph[0].add(new Edge(0, 1, 0));

        // graph[0].add(new Edge(0, 2, 0));

        // graph[1].add(new Edge(1, 0, 0));

        // graph[2].add(new Edge(2, 3, 0));

        // graph[3].add(new Edge(3, 0, 0));

        // graph[0].add(new Edge(0, 3, 0));

        // graph[2].add(new Edge(2, 3, 0));

        // graph[3].add(new Edge(3, 1, 0));

        // graph[4].add(new Edge(4, 0, 0));
        // graph[4].add(new Edge(4, 1, 0));

        // graph[5].add(new Edge(5, 0, 0));
        // graph[5].add(new Edge(5, 2, 0));

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

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

    // Modified bfs
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i])
                bfsUtil(graph, vis);
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis) { // T(n) = O(V+E)
        Queue<Integer> q = new ArrayDeque<>();

        q.add(0);
        while (!q.isEmpty()) {

            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " "); // visit
                vis[curr] = true; // mark visited
                // print neighbour
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Modified dfs
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i])
                dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) { // T(n) = O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) { // T(n) = O(V+E)
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    // for undirecred graph
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }

            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
        }
        return false;
    }

    // isBipartite method without util method
    // public static boolean isBipartite(ArrayList<Edge>[] graph) {
    // int[] col = new int[graph.length];
    // Queue<Integer> q = new LinkedList<>();
    // Arrays.fill(col, -1);
    // for (int i = 0; i < graph.length; i++) {
    // if (col[i] == -1) {
    // q.add(i);
    // col[i] = 0;
    // while (!q.isEmpty()) {
    // int curr = q.remove();
    // for (int j = 0; j < graph[curr].size(); j++) {
    // Edge e = graph[curr].get(j);
    // if (col[e.dest] == -1) {
    // int nextClr = col[curr] == 0 ? 1 : 0;
    // col[e.dest] = nextClr;
    // q.add(e.dest);
    // } else if (col[e.dest] == col[curr]) {
    // return false;
    // }
    // }
    // }
    // }
    // }
    // return true;
    // }

    // isBipartite method with Util method
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        // for (int i = 0; i < col.length; i++) {
        // col[i] = -1;
        // }
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                if (isBipartiteUtil(graph, q, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // -1 : no color
    // 0 : yellow , 1 : blue
    @SuppressWarnings("uncheaked")
    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, Queue<Integer> q, int[] col, int clr) {
        // q.add(curr);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                // q.add(e.dest);
                if (col[e.dest] == -1) {
                    int newClr = (col[curr] == 0) ? 1 : 0;
                    col[e.dest] = newClr;
                    q.add(e.dest);
                } else if (col[e.dest] == col[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    // for directed graph
    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                hasCycleUtil(graph, vis, stack, i);
            }
        }
        return false;
    }

    public static boolean hasCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) {
                return true;
            }

            if (!vis[e.dest] && hasCycleUtil(graph, vis, stack, e.dest)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<Edge>[] graph) { // Using DFS
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, vis, s, i);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr) { // Using DFS
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, vis, s, e.dest);
            }
        }
        s.push(curr);
    }

    public static void calcIndegree(ArrayList<Edge>[] graph, int[] indeg) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSortBFS(ArrayList<Edge>[] graph) { // Using BFS (Khan's Algo)
        int[] indeg = new int[graph.length];
        calcIndegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void pathSrcToDest(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            pathSrcToDest(graph, e.dest, dest, path + src);
        }
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int dis;

        Pair(int n, int dest) {
            this.n = n;
            this.dis = dis;
        }

        @Override
        public int compareTo(Pair p) {
            return this.dis - p.dis;
        }

    }

    public static void dijkastra(ArrayList<Edge>[] graph, int src) {
        int[] dest = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dest[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            for(int i=0; i<graph[curr.n].size(); i++) {
                Edge e = graph[curr.n].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dest[u] + wt < dest[v]) {
                    dest[v] = dest[u] + wt;
                }
                pq.add(new Pair(v, dest[v]));
            }
        }
        for(int i : dest) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("uncheaked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // System.out.println("neighbour of 2 are : ");
        // for(int i=0; i< graph[2].size(); i++) {
        // Edge e = graph[2].get(i);
        // System.out.print(e.dest + " ");
        // }

        // bfs(graph);
        // dfs(graph, 0, new boolean[graph.length]);
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));
        // bfs(graph);
        // System.out.println(detectCycle(graph));
        // System.out.println(isBipartite(graph));
        // System.out.println(hasCycle(graph));
        // topSort(graph);
        // topSortBFS(graph);
        // pathSrcToDest(graph, 5, 1, "");
        int src = 2;
        dijkastra(graph, src);
    }
}
