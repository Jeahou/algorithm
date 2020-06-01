package beakjoon;

import java.util.*;

public class B2178 {
	static int sx[] = {1, -1, 0, 0};
	static int sy[] = {0, 0, 1, -1};
	static void bfs(int[][] map, xy start, xy end, boolean[][] visited) {
		Queue<xy> queue = new LinkedList<xy>();
		queue.offer(start);
		visited[start.y][start.x] = true;
		while(!queue.isEmpty()) {
			xy s = queue.poll();
			for(int i=0; i<4; i++) {
				int nextX = s.x + sx[i];
				int nextY = s.y + sy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length ) {
					continue;
				}
				if(map[nextY][nextX] == 0 || visited[nextY][nextX] == true) {
					continue;
				}
				queue.offer(new xy(nextX, nextY));
				map[nextY][nextX] = map[s.y][s.x] + 1;
				visited[nextY][nextX] = true;
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		xy start = new xy(0,0);
		int n = sc.nextInt();
		int m = sc.nextInt();
		xy end = new xy(m-1,n-1);
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j+1));
			}
		}
		bfs(map, start, end, visited);
		System.out.println(map[n-1][m-1]);
		/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
		*/
	}

}

class xy{
	int x;
	int y;
	
	public xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
