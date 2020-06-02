package beakjoon;
import java.util.*;
public class B14502 {
	static int answer = 0;
	static int sx[] = {1, -1, 0, 0};
	static int sy[] = {0, 0, 1, -1};
	// 벽새우기
	static void makeWall(int[][] map, int cnt) {
		if(cnt == 3) {
			int[][] tempMap = new int[map.length][map[0].length];
			for(int i =0; i<map.length; i++) {
				for(int j=0; j<map[0].length; j++) {
					tempMap[i][j] = map[i][j]; 
				}
			}
			bfs(tempMap);
			return;
		}
		for(int i =0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(map, cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	// 바이러스 퍼트리기
	static void bfs(int[][] map) {
		Queue<xy> queue = new LinkedList<xy>();
		for(int i =0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 2) {
					xy point = new xy(j,i);
					queue.offer(point);
				}
			}
		}
		while(!queue.isEmpty()) {
			xy fir = queue.poll();
			for(int i=0; i<4; i++) {
				int nextX = fir.x + sx[i];
				int nextY = fir.y + sy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length ) {
					continue;
				}
				if(map[nextY][nextX] == 1 || map[nextY][nextX] == 2) {
					continue;
				}
				queue.offer(new xy(nextX, nextY));
				map[nextY][nextX] = 2;
			}
		}
		int result = 0;
		for(int i =0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 0) result +=1;
			}
		}
		answer = Math.max(result, answer);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		
		for(int i =0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		makeWall(map, 0);
		System.out.println(answer);
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

