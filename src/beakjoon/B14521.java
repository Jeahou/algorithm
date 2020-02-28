package beakjoon;
import java.util.Arrays;
import java.util.Scanner;

public class B14521 {
	
	static int out(int[][] n) {
		int[] dp = new int[n.length+2];
		for(int i=n.length; i>0; i--) {
			for(int j=0; j<=n.length; j++) {
				if(i>=j) {
					if(i+n[i-1][0] > n.length+1) { 
						dp[i] = dp[i+1];
					}else {
						dp[i] = Math.max(n[i-1][1] + dp[i+n[i-1][0]], dp[i+1]);
						break;
					}
				}
			}
		}
		Arrays.sort(dp);
		return dp[dp.length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[][] n = new int[k][2];
		for(int i=0; i<k; i++) {
			n[i][0] = sc.nextInt();
			n[i][1] = sc.nextInt();
		}
		System.out.println(out(n));
	}

}
