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

	static boolean determination(int minute) {
		int current_minute = minute;
		int blueray = 1;
		for (int i = 1; i <= N; i++) {
			if (current_minute - A[i] >= 0) {
				current_minute -= A[i];
			} else if (minute >= A[i]) {
				current_minute = minute - A[i];
				blueray++;
			} else {
				return false;
			}
		}

		return blueray <= M;
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