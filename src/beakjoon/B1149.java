package beakjoon;
import java.util.Scanner;

public class B1149 {
	
	static int cal(int map[][]) {
		int dp[][] = new int[3][map[0].length];
		for(int i=0; i<map[0].length; i++) {
			if(i==0) {
				dp[0][0] = map[0][0];
				dp[1][0] = map[1][0];
				dp[2][0] = map[2][0];
			}else {
				for(int j=0; j<3; j++) {
					dp[j][i] = map[j][i] + ver(j, dp, i-1);
				}
			}
		}
		return res(dp[0][map[0].length-1], dp[1][map[0].length-1], dp[2][map[0].length-1]);
		
	}
	static int ver(int n, int map[][], int i) {
		int result = 0;
		if(n==0) {
			if(map[1][i] > map[2][i]) {
				result = map[2][i];
			}else {
				result = map[1][i];
			}
		}else if(n==1) {
			if(map[0][i] > map[2][i]) {
				result = map[2][i];
			}else {
				result = map[0][i];
			}
		}else {
			if(map[0][i] > map[1][i]) {
				result = map[1][i];
			}else {
				result = map[0][i];
			}
		}
		return result;
	}
	static int res(int n1, int n2, int n3) {
		int result = 0;
		if(n1>n2) {
			result = n2;
			if(n2>n3) result = n3;
		}else {
			result = n1;
			if(n1>n3) result = n3;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][] = new int[3][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++){
				map[j][i] = sc.nextInt();
			}
		}
		System.out.println(cal(map));
	}

}
