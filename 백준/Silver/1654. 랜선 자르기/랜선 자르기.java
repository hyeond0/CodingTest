import java.util.*;
import java.io.*;

public class Main {
	static int K, N;
	static int[] A;

	static StringBuilder sb = new StringBuilder();
	static FastScanner scan = new FastScanner();

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		K = scan.nextInt();
		N = scan.nextInt();
		A = new int[K + 1];
		for (int i = 1; i <= K; i++)
			A[i] = scan.nextInt();
	}

	static void pro() {
		Arrays.sort(A, 1, K + 1);
		long R = 1;
		for (int i = 0; i < 32; i++) {
			R *= 2;
		}
		R -= 1;
		long L = 0, ans = 0;
		while (L <= R) {
			long mid = (L + R) / 2;
			if (determination(mid)) {
				ans = Math.max(ans, mid);
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}

		System.out.println(ans);
	}

	static boolean determination(long H) {
		long res = 0;
		for (int i = 1; i <= K; i++) {
			res += A[i] / H;
		}
		return res >= N;
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