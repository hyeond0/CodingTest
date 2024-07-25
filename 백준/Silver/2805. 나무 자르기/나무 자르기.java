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
		long L = 0, R = 2000000000, ans = 0;
		while (L <= R) {
			int mid = (int) (L + R) / 2;
			if (determination(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean determination(int H) {
		long res = 0;
		for (int i = 1; i <= N; i++) {
			if (A[i] > H) {
				res += A[i] - H;
			}
		}
		return res >= M;
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
