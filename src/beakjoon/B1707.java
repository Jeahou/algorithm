package beakjoon;
import java.util.*;

public class B1707 {
	 public static void dfs(ArrayList<ArrayList<Integer>> v_set, int[] color, int x, int c) {
	        color[x] = c;
	        for (int y : v_set.get(x)) {
	            if (color[y] == 0) {
	                dfs(v_set, color, y, 3-c);
	            }
	        }
	    }
	   public static void main(String[] args) {
	      Scanner scan = new Scanner(System.in);
	      int test_case = scan.nextInt();
	      for (int i = 0; i < test_case; i++) {
	         ArrayList<ArrayList<Integer>> v_set = new ArrayList<ArrayList<Integer>>();
	         int val1 = scan.nextInt(), val2 = scan.nextInt();
	         for (int j = 0; j <= val1; j++) {
	            v_set.add(new ArrayList<Integer>());
	         }
	         for (int j = 0; j < val2; j++) {
	            int input1 = scan.nextInt(), input2 = scan.nextInt();
	            v_set.get(input1).add(input2);
	            v_set.get(input2).add(input1);
	         }
	         int[] color = new int[val1+1];
	            boolean result = true;
	            for (int j=1; j<=val1; j++) {
	                if (color[j] == 0) {
	                    dfs(v_set, color, j, 1);
	                }
	            }
	            for (int j=1; j<=val1; j++) {
	                for (int k : v_set.get(j)) {
	                    if (color[j] == color[k]) {
	                       result = false;
	                    }
	                }
	            }
	            if (result) {
	                System.out.println("YES");
	            } else {
	                System.out.println("NO");
	            }
	      }
	   }

}
