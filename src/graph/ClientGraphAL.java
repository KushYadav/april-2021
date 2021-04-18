package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ClientGraphAL {

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

		boolean[] visited = new boolean[vces];
//		System.out.println(hasPath(graph, 0, 6, visited));
//		printAllPaths(graph, 0, 6, visited, "0");

//		int criteria = 40;
//		int k = 3;
//		differentPaths(graph, 0, 6, visited, criteria, k, "0", 0);
//		System.out.println("Smallest Path: " + sPath + "@" + sPathWt);
//		System.out.println("Largest Path: " + lPath + "@" + lPathWt);
//		System.out.println("Just Larger Path than: " + cPath + "@" + cPathWt);
//		System.out.println("Just Smaller Path than: " + fPath + "@" + fPathWt);
//		System.out.println(k + "th Larger path: " + pq.peek().psf + "@" + pq.peek().wsf);

//		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
//		for (int i = 0; i < vces; i++) {
//			if (!visited[i]) {
//				ArrayList<Integer> comp = new ArrayList<Integer>();
//				traverse(graph, i, comp, visited);
//				comps.add(comp);
//			}
//		}
//		System.out.println(comps);
//		System.out.println("Graph is " + (comps.size() == 1 ? "Connected" : "Disconnected"));
//		bfs(graph, 2);

		for (int i = 0; i < graph.size(); i++) {
			if (!visited[i]) {
				boolean cycle = isCyclic(graph, i, visited);
				if (cycle) {
					System.out.println(true);
					return;
				}
			}
		}
		System.out.println(false);
	}

	// Has Path from A to B

	public static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited) {
		if (src == dest) {
			return true;
		}
		visited[src] = true;

		for (Edge edge : graph.get(src)) {
			if (!visited[edge.nbr]) {
				if (hasPath(graph, edge.nbr, dest, visited) == true) {
					return true;
				}
			}
		}
		return false;
	}

	// Find All Paths

	public static void printAllPaths(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited,
			String psf) {
		if (src == dest) {
			System.out.println(psf);
			return;
		}
		visited[src] = true;
		for (Edge edge : graph.get(src)) {
			if (!visited[edge.nbr]) {
				printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
			}
		}
		visited[src] = false;
	}

	// Different Paths

	public static class Pair implements Comparable<Pair> {
		int wsf;
		String psf;

		Pair(int wsf, String psf) {
			this.wsf = wsf;
			this.psf = psf;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

	static String sPath;
	static Integer sPathWt = Integer.MAX_VALUE;
	static String lPath;
	static Integer lPathWt = Integer.MIN_VALUE;
	static String cPath;
	static Integer cPathWt = Integer.MAX_VALUE;
	static String fPath;
	static Integer fPathWt = Integer.MIN_VALUE;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();

	public static void differentPaths(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited,
			int criteria, int k, String psf, int wsf) {

		if (src == dest) {
			if (wsf < sPathWt) {
				sPathWt = wsf;
				sPath = psf;
			}

			if (wsf > lPathWt) {
				lPathWt = wsf;
				lPath = psf;
			}

			if (wsf > criteria && wsf < cPathWt) {
				cPathWt = wsf;
				cPath = psf;
			}
			if (wsf < criteria && wsf > fPathWt) {
				fPathWt = wsf;
				cPath = psf;
			}
			if (pq.size() < k) {
				pq.add(new Pair(wsf, psf));
			} else {
				if (wsf > pq.peek().wsf) {
					pq.remove();
					pq.add(new Pair(wsf, psf));
				}
			}
		}

		visited[src] = true;
		for (Edge edge : graph.get(src)) {
			if (!visited[edge.nbr]) {
				differentPaths(graph, edge.nbr, dest, visited, criteria, k, psf + edge.nbr, wsf + edge.wt);
			}
		}
		visited[src] = false;
	}

	// Connected Components

	public static void traverse(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Integer> comp, boolean[] visited) {
		visited[src] = true;
		comp.add(src);
		for (Edge e : graph.get(src)) {
			if (!visited[e.nbr]) {
				traverse(graph, e.nbr, comp, visited);
			}
		}
	}

	// Breadth First Search(BFS)

	public static class PairBFS {
		int v;
		String psf;

		public PairBFS(int v, String psf) {
			this.v = v;
			this.psf = psf;
		}
	}

	public static void bfs(ArrayList<ArrayList<Edge>> graph, int src) {
		ArrayDeque<PairBFS> queue = new ArrayDeque<>();
		queue.addLast(new PairBFS(src, src + ""));
		boolean[] visited = new boolean[graph.size()];

		while (!queue.isEmpty()) {
			PairBFS removed = queue.removeFirst();
			if (visited[removed.v]) {
				continue;
			}
			System.out.println(removed.v + "@" + removed.psf);
			visited[removed.v] = true;

			for (Edge edge : graph.get(removed.v)) {
				if (visited[edge.nbr] == false) {
					queue.addLast(new PairBFS(edge.nbr, removed.psf + edge.nbr));
				}
			}
		}
	}

	// Has Cycle ?

	public static boolean isCyclic(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited) {
		ArrayDeque<PairBFS> queue = new ArrayDeque<>();
		queue.addLast(new PairBFS(src, src + " "));
		while (!queue.isEmpty()) {
			PairBFS removed = queue.removeFirst();
			if (visited[removed.v]) {
				return true;
			}
			visited[removed.v] = true;

			for (Edge edge : graph.get(removed.v)) {
				if (visited[edge.nbr] == false) {
					queue.addLast(new PairBFS(edge.nbr, removed.psf + edge.nbr));
				}
			}
		}
		return false;
	}

}
