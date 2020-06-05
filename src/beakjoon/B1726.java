package beakjoon;
import java.util.*;

public class B1726 {
	// µ¿ ¼­ ³² ºÏ
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static class Point{
		int x;
		int y;
		int dir;
		int weight;
		
		public Point(int y, int x, int dir, int weight){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.weight = weight;
		}
	}
	
	static void bfs(int[][] map, Point start, Point end, boolean[][][] visited) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			Point nextP = queue.poll();
			//System.out.println(nextP.x + " " + nextP.y + " " + nextP.dir);
			int nextX = nextP.x;
			int nextY = nextP.y;
			int nextD = nextP.dir;
			if(nextX == end.x && nextY == end.y && nextD == end.dir) {
				System.out.println(nextP.weight);
			}
			visited[nextD][nextY][nextX] = true;
			for(int i=1; i<=3; i++) {
				int nX = nextX + dx[nextD-1]*i;
				int nY = nextY + dy[nextD-1]*i;
				if(nX < 0 || nY < 0 || nX >= map[0].length || nY >= map.length) {
					break;
				}else {
					if(map[nY][nX] == 0) {
						if(visited[nextD][nY][nX] == false) {
							visited[nextD][nY][nX] = true;
							queue.offer(new Point(nY, nX, nextD, nextP.weight+1));
						}
					}else {
						break;
					}
				}
			}
			for(int i=1; i<=4; i++) {
				if(!visited[i][nextY][nextX]&& nextD != i) {
					visited[i][nextY][nextX] = true;
					if((nextD == 1 && i == 2) || (nextD == 2 && i == 1) || (nextD == 3 && i == 4) || (nextD == 4 && i == 3)) {
						queue.offer(new Point(nextY, nextX, i, nextP.weight+2));
					}else {
						queue.offer(new Point(nextY, nextX, i, nextP.weight+1));
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		boolean[][][] visited =  new boolean[5][n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Point start = new Point(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), 0);
		Point end = new Point(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), 0);
		bfs(map, start, end, visited);
	}

}
