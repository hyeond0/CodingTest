import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static int[] a;
	static StringBuilder sb = new StringBuilder();
	static FastScanner scan = new FastScanner();

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		n = scan.nextInt();
		k = scan.nextInt();
		a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = scan.nextInt();
		}
	}

	static void pro() {
		int R = 0, rion_count = 0, ans = Integer.MAX_VALUE;
		for (int L = 1; L <= n; L++) {
			if (a[L - 1] == 1)
				rion_count--;
			while (R + 1 <= n && rion_count < k) {
				if (a[++R] == 1)
					rion_count++;
			}

			if (rion_count >= k) {
				ans = Math.min(ans, R - L + 1);
			}
		}

		if (ans == Integer.MAX_VALUE)
			ans = -1;
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
