package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {

	public static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static class Pair implements Comparable<Pair> {
		int v;
		int av;
		int wt;

		Pair(int v, int av, int wt) {
			this.v = v;
			this.av = av;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wt - o.wt;
		}
	}

	public static void main(String[] args) {
		int vces = 7;
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < vces; i++) {
			graph.add(new ArrayList<Edge>());
		}

		graph.get(0).add(new Edge(0, 1, 10));
		graph.get(0).add(new Edge(0, 3, 40));

		graph.get(1).add(new Edge(1, 0, 10));
		graph.get(1).add(new Edge(1, 2, 10));

		graph.get(2).add(new Edge(2, 1, 10));
		graph.get(2).add(new Edge(2, 3, 10));

		graph.get(3).add(new Edge(3, 0, 40));
		graph.get(3).add(new Edge(3, 2, 10));
		graph.get(3).add(new Edge(3, 4, 2));

		graph.get(4).add(new Edge(4, 3, 2));
		graph.get(4).add(new Edge(4, 5, 3));
		graph.get(4).add(new Edge(4, 6, 8));

		graph.get(5).add(new Edge(5, 4, 3));
		graph.get(5).add(new Edge(5, 6, 3));

		graph.get(6).add(new Edge(6, 4, 3));
		graph.get(6).add(new Edge(6, 5, 8));

		display(graph);

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[vces];
		pq.add(new Pair(0, -1, 0));
		while (!pq.isEmpty()) {
			Pair removed = pq.remove();
			if (visited[removed.v] == true) {
				continue;
			}
			visited[removed.v] = true;
			if (removed.av != -1) {
				System.out.println("[" + removed.v + "-" + removed.av + "@" + removed.wt + "]");
			}
			for (Edge e : graph.get(removed.v)) {
				if (!visited[e.nbr]) {
					pq.add(new Pair(e.nbr, removed.v, e.wt));
				}
			}
		}
	}

	public static void display(ArrayList<ArrayList<Edge>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			ArrayList<Edge> list = graph.get(i);
			System.out.print(i + " -> ");
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j).nbr + " ");
			}
			System.out.println();
		}
	}
}
