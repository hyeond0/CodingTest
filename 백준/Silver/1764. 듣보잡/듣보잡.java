import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static String[] A, B;
	static FastScanner scan = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		N = scan.nextInt();
		A = new String[N + 1];
		M = scan.nextInt();
		B = new String[M + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = scan.next();
		}
		for (int i = 1; i <= M; i++) {
			B[i] = scan.next();
		}
	}

	static boolean binary_search(String[] A, int L, int R, String X) {
		while (L <= R) {
			int mid = (L + R) / 2;
			if (A[mid].compareTo(X) == 0) {
				return true;
			}
			if (A[mid].compareTo(X) < 0) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return false;
	}

	static void pro() {
		int count = 0;
		Arrays.sort(A, 1, N + 1);
		Arrays.sort(B, 1, M + 1);
		if (N > M) {
			for (int i = 1; i <= M; i++) {
				if (binary_search(A, 1, N, B[i])) {
					count++;
					sb.append(B[i]).append('\n');
				}
			}
		} else {
			for (int i = 1; i <= N; i++) {
				if (binary_search(B, 1, M, A[i])) {
					count++;
					sb.append(A[i]).append('\n');
				}
			}
		}
		System.out.println(count);
		System.out.println(sb.toString());
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