package Graphs;

import java.util.*;

public class BellmanFord {
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

        // Bellman Ford
        graph[0].add(new Edge(0, 1, 6));
        graph[0].add(new Edge(0, 4, 7));

        graph[1].add(new Edge(1, 2, 5));
        graph[1].add(new Edge(1, 4, 8));
        graph[1].add(new Edge(1, 3, -4));

        graph[2].add(new Edge(2, 1, -2));

        graph[3].add(new Edge(3, 2, 7));
        graph[3].add(new Edge(3, 0, 2));

        graph[4].add(new Edge(4, 2, -3));
        graph[4].add(new Edge(4, 3, 9));

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p) {
            return this.path - p.path;
        }
    }


    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    if (dist[e.src] != Integer.MAX_VALUE && (dist[e.src] + e.wt < dist[e.dest])) {
                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }
            }
        }
        for (int i : dist) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("uncheaked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        bellmanFord(graph, src);

    }

}