package beakjoon;
import java.util.Scanner;

public class B11726 {
	static int square(int a) {
		// 1 - 1
		// 2 - 2
		// 3 - 3
		// 4 - 5
		int[] n = new int[a+1];
		n[0] = 1;
		n[1] = 1;
		for(int i =2; i<=a; i++) {
			n[i] = n[i-1] + n[i-2];
			n[i] %= 10007;
		}
		return n[a];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(square(n));
	}

}
