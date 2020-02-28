package beakjoon;
import java.util.Scanner;

public class B2293 {
	
	static int flip(int k, int[] N) {
		int result = 0;
		int[][] dp = new int[N.length][k+1];
		for(int t=0; t<N.length; t++) {
			dp[t][0] = 0;
		}
		for(int j=0; j<N.length; j++) {
			for(int i=1; i<=k; i++) {
				if(i-N[j] < 0) {
					dp[j][i] = 0;
				}else if(i-N[j] == 0) {
					dp[j][i] = 1;
				}else {
					for(int jj =0; jj<=j; jj++) {
						dp[j][i] += dp[jj][i-N[j]];
					}
				}
			}
		}
		for(int i=0; i<N.length; i++) {
			result += dp[i][k];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] N = new int[sc.nextInt()];
		int k = sc.nextInt();
		for(int i=0; i<N.length; i++) {
			N[i] = sc.nextInt();
		}
		
		System.out.println(flip(k, N));
		
	}

}
