package beakjoon;
import java.util.Scanner;

public class B9251 {
	
	static int Lcs(String f, String s) {
		String[] a = f.split("");
		String[] b = s.split("");
		int[][] dp = new int[a.length+1][b.length+1];
		for(int i=0; i<=a.length; i++) {
			dp[i][0] = 0;
		}
		
		for(int i=1; i<=b.length; i++) {
			for(int j=1; j<=a.length; j++) {
				if(a[j-1].equals(b[i-1])) {
					dp[j][i] = dp[j-1][i-1] +1;
				}else {
					dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
				}
				
			}
		}
		for(int i=0; i<=b.length; i++) {
			for(int j=0; j<=a.length; j++) {
				System.out.print(dp[j][i]);
			}
			System.out.println();
		}
		
		return dp[a.length][b.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String first = sc.next();
		String second = sc.next();
		System.out.println(Lcs(first, second));
	}

}
