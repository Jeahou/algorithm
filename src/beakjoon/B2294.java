package beakjoon;
import java.util.Scanner;

public class B2294 {
	static int chkCoin(int k, int[] map) {
		int[] dp =  new int[k+1];
		dp[0] = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=1; j<=k; j++) {
				if(i==0) {
					if(j-map[i] < 0) {
						dp[j] = 0; 
					}else if(j-map[i]==0) {
						dp[j] = 1;
					}else {
						if(dp[j-map[i]] == 0) {
							dp[j] = 0;
						}else {
							dp[j] = 1 + dp[j-map[i]]; 
						}
					}
				}else {
					if(j-map[i]==0) {
						dp[j] = 1;
					}else if(j-map[i] > 0) {
						if(dp[j-map[i]] != 0) {
							if(dp[j] != 0) {
								dp[j] = Math.min(dp[j], 1+dp[j-map[i]]);
							}else {
								dp[j] = 1+dp[j-map[i]];
							}
						}
					}
				}
			}
		}
		return dp[k];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k =sc.nextInt();
		int[] map = new int[n];
		for(int i=0; i<n; i++) {
			map[i] = sc.nextInt();
		}
		System.out.println(chkCoin(k, map));
	}

}
