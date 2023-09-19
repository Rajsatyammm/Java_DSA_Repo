package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import Graphs.firstClass.Edge;

public class Algo {
    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[2].add(new Edge(3, 0, 30));
        graph[2].add(new Edge(3, 1, 40));
        graph[2].add(new Edge(3, 2, 50));


    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        Pair(int v, int c) {
            this.v = v;
            cost = c;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }
    public static void prims(ArrayList<firstClass.Edge>[] graph) {
        int v = graph.length;
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int minCost = 0;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
//                minCost += curr.cost;
                System.out.print(curr.v + " ");

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println(minCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        prims(graph);
    }
}
