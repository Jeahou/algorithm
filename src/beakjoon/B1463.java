package beakjoon;
import java.util.Scanner;

public class B1463 {
	static int onlyOne(int n) {
		int[] dp = new int[n+1];
		dp[1] = 0;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2] +1);
			if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3] +1);
		}
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(onlyOne(n));
	}

}
