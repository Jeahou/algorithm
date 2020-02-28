package beakjoon;
import java.util.Scanner;

public class B9095 {
	
	static int plus(int a) {
		// 1 - 1
		// 2 - 2
		// 3 - 4
		// 4 - 7
		// 5 - 13
		int[] t = new int[10];
		t[0] = 1;
		t[1] = 2;
		t[2] = 4;
		for(int i=3; i<t.length; i++) {
			t[i] = t[i-1]+t[i-2]+t[i-3];
		}
		return t[a-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nt = new int[n];
		for(int i=0; i<n; i++) {
			nt[i] = sc.nextInt();
		}
		for(int k : nt) {
			System.out.println(plus(k));
		}
	}

}
