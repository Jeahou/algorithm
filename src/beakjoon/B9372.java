package beakjoon;

import java.util.Scanner;

public class B9372 {
	// 최소 신장 트리 문제이기에 나라 개수 -1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int i=0; i<test_case; i++) {
			int countryN = sc.nextInt();
			int planeN = sc.nextInt();
			for(int j=0; j<planeN; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
			}
			System.out.println(countryN-1);
		}
	}

}
