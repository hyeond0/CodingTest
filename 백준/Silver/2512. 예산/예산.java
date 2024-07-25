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
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = scan.nextInt();
		}
		M = scan.nextInt();
	}

	static void pro() {
		Arrays.sort(A, 1, N + 1);
		int max_budget = possible_budget();
		if (max_budget > -1) {
			System.out.println(max_budget);
			return;
		}
		int L = 0, R = 1000000000, ans = 0;
		while (L <= R) {
			int mid = (L + R) / 2;
			if (determination(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static int possible_budget() {
		int sum = 0, max = 0;
		for (int i = 1; i <= N; i++) {
			sum += A[i];
			if (A[i] > max) {
				max = A[i];
			}
		}
		if (sum <= M) {
			return max;
		} else {
			return -1;
		}
	}

	static boolean determination(int budget) {
		int res = 0;
		for (int i = 1; i <= N; i++) {
			if (A[i] > budget) {
				res += budget;
			} else {
				res += A[i];
			}
		}
		return res <= M;
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

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