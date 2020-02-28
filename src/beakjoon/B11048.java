package beakjoon;
import java.util.Scanner;

public class B11048 {
	
	static int makeCandy(int[][] map) {
		int[][] dp = new int[map.length][map[0].length];
		dp[0][0] = map[0][0];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(!(i == 0 && j ==0)){
					if(i == 0) {
						dp[i][j] = map[i][j] + dp[i][j-1];
 					}else if(j==0) {
 						dp[i][j] = map[i][j] + dp[i-1][j];
					}else {
						dp[i][j] = maxThree(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + map[i][j];
					}
				}	
			}
		}
		/*
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		*/
		return dp[map.length-1][map[0].length-1];
	}
	
	static int maxThree(int i, int j, int k) {
		int result;
		if(i<j) {
			result = j;
		}else{
			result = i;
		}
		if(result < k) result = k;
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(makeCandy(map));
	}

}
