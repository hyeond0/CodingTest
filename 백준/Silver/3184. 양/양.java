import java.util.*;
import java.io.*;

public class Main {
	static int R, C, wolf_count, sheep_count, wolf, sheep;
	static String[] a;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	static StringBuilder sb = new StringBuilder();
	static FastScanner scan = new FastScanner();

	public static void main(String[] args) {
		input();
		pro();
		System.out.println(sb);
	}

	static void input() {
		R = scan.nextInt();
		C = scan.nextInt();
		a = new String[R];
		for (int i = 0; i < R; i++) {
			a[i] = scan.next();
		}
	}

	static void pro() {
		visit = new boolean[R][C];
		wolf = 0;
		sheep = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visit[i][j] && a[i].charAt(j) != '#') {
					dfs(i, j);
					if (sheep > wolf) {
						wolf = 0;
					} else {
						sheep = 0;
					}
					wolf_count += wolf;
					sheep_count += sheep;
					sheep = 0;
					wolf = 0;
				}
			}
		}
		sb.append(sheep_count).append(' ').append(wolf_count);
	}

	static void dfs(int x, int y) {
		if (a[x].charAt(y) == 'o')
			sheep++;
		if (a[x].charAt(y) == 'v')
			wolf++;
		visit[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			if (visit[nx][ny])
				continue;
			if (a[nx].charAt(ny) == '#')
				continue;
			dfs(nx, ny);
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
