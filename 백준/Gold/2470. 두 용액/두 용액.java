import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] a;
	static StringBuilder sb = new StringBuilder();
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
	}

	static void pro() {
		Arrays.sort(a, 1, n + 1);

		int best_sum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0, L = 1, R = n;

		while (L < R) {
			int sum = a[L] + a[R];
			if (best_sum > Math.abs(sum)) {
				v1 = a[L];
				v2 = a[R];
				best_sum = Math.abs(sum);
			}
			if (sum == 0) {
				break;
			}
			if (sum > 0) {
				R--;
			} else {
				L++;
			}
		}

		sb.append(v1).append(' ').append(v2);
		System.out.println(sb);
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
