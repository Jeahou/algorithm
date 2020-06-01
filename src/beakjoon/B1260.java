package beakjoon;
import java.util.*;

public class B1260 {
	static void bfs(ArrayList<Integer>[] graph, int start, boolean[] visited) {
		if(visited[start] == false) {
			visited[start] = true;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		System.out.print(start + " ");
		while(!queue.isEmpty()) {
			int fir = queue.poll();
			for(int i=0; i<graph[fir].size(); i++) {
				int next = graph[fir].get(i);
				if(visited[next] == false) {
					visited[next] = true;
					queue.offer(next);
					System.out.print(next + " ");
				}
			}
		}
	}
	static void dfs(ArrayList<Integer>[] graph, int start, boolean[] visited) {
		if(visited[start] == false) {
			visited[start] = true;
			System.out.print(start +  " ");
			for(int i=0; i<graph[start].size(); i++) {
				dfs(graph, graph[start].get(i), visited);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		boolean[] visited = new boolean[n+1];
 		for(int i=0; i<n+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
			Collections.sort(graph[a]);
			Collections.sort(graph[b]);
		}
		dfs(graph, start, visited);
		System.out.println("");
		visited = new boolean[n+1];
		bfs(graph, start, visited);
	}

}
