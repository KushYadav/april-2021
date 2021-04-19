package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.tools.Tool;

import graph.Prim.Edge;
import graph.Prim.Pair;

public class TopologicalSort {

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

		graph.get(1).add(new Edge(1, 2, 10));

		graph.get(2).add(new Edge(2, 3, 10));

		graph.get(4).add(new Edge(4, 3, 2));
		graph.get(4).add(new Edge(4, 5, 3));
		graph.get(4).add(new Edge(4, 6, 8));

		graph.get(5).add(new Edge(5, 6, 3));

		display(graph);

		boolean[] visited = new boolean[vces];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < vces; i++) {
			if (!visited[i]) {
				topologicalSort(graph, i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
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

	public static void topologicalSort(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited,
			Stack<Integer> stack) {

		visited[src] = true;
		for (Edge e : graph.get(src)) {
			if (!visited[e.nbr]) {
				topologicalSort(graph, e.nbr, visited, stack);
			}
		}
		stack.push(src);

	}
}
