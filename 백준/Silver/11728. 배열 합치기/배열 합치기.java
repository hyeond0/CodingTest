import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static List<Integer> a = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static FastScanner scan = new FastScanner();

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		n = scan.nextInt();
		m = scan.nextInt();
		for (int i = 1; i <= n + m; i++) {
			a.add(scan.nextInt());
		}
	}

	static void pro() {
		Collections.sort(a);
		for (int num : a) {
			sb.append(num).append(' ');
		}
		System.out.println(sb.toString());
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
