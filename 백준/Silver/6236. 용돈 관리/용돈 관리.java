import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] A;

	static StringBuilder sb = new StringBuilder();
	static FastScanner scan = new FastScanner();

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = scan.nextInt();
		}
	}

	static void pro() {
		int L = 1, R = 1000000000, ans = 0;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (determination(mid)) {
				ans = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(ans);
	}

	static boolean determination(int money) {
		int current_money = money;
		int count = 1;
		for (int i = 1; i <= N; i++) {
			if (current_money - A[i] >= 0) {
				current_money -= A[i];
			} else {
				if (money - A[i] >= 0) {
					current_money = money - A[i];
					count++;
				} else {
					return false;
				}
			}
		}
		return count <= M;
	}

	static class FastScanner {
		StringTokenizer st;
		BufferedReader br;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}