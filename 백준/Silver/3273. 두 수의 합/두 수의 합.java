import java.util.*;
import java.io.*;

public class Main {
	static int N, X, ans;
	static int[] A;
	static FastScanner scan = new FastScanner();
	static StringBuilder sb = new StringBuilder();

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
		X = scan.nextInt();
	}

	static boolean bin_search(int[] A, int L, int R, int X) {
		while (L <= R) {
			int mid = (L + R) / 2;
			if (A[mid] == X) {
				return true;
			}

			if (A[mid] < X) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return false;
	}

	static void pro() {
		Arrays.sort(A, 1, N + 1);
		int ans = 0;
		for (int i = 1; i <= N - 1; i++) {
			if (bin_search(A, i+1, N, X - A[i])) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			try {
				while (st == null || !st.hasMoreElements()) {
					st = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return st.nextToken();
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
