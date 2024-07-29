import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] a;
	static StringBuilder sb = new StringBuilder();
	static FastScanner scan = new FastScanner();

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		n = scan.nextInt();
		m = scan.nextInt();
		a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = scan.nextInt();
		}
	}

	static void pro() {
		Arrays.sort(a);
		int R = 1, ans = Integer.MAX_VALUE;
		for (int L = 1; L <= n; L++) {
			while (R + 1 <= n && Math.abs(a[R] - a[L]) < m) {
				R++;
			}
			int value = Math.abs(a[R] - a[L]);
			if (value >= m) {
				ans = Math.min(value, ans);
			}
		}
		if (ans == Integer.MAX_VALUE) {
			ans = 0;
		}
		System.out.println(ans);
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
