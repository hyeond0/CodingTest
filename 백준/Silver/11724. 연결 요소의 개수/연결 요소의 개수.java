import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	static FastScanner scan = new FastScanner();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		input();
		pro();
	}

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
	}

	static void pro() {
		visit = new boolean[N + 1];
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int x) {
		visit[x] = true;

		for (int y : adj[x]) {
			if (visit[y])
				continue;
			dfs(y);
		}
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
