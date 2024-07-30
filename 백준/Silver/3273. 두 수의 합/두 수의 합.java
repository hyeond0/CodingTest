import java.util.*;
import java.io.*;

public class Main {
	static int n, x;
	static int[] a;
	static FastScanner scan = new FastScanner();

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		n = scan.nextInt();
		a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = scan.nextInt();
		}
		x = scan.nextInt();
	}

	static void pro() {
		Arrays.sort(a, 1, n + 1);
		int L = 1, R = n, ans = 0;
		while (L < R) {
			int sum = a[L] + a[R];
			if (sum == x) {
				ans++;
				R--;
			}
			if (sum > x) {
				R--;
			} else {
				L++;
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
