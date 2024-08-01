import java.util.*;
import java.io.*;

public class Main {
	static int w, h, count;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

	static StringBuilder sb = new StringBuilder();
	static FastScanner scan = new FastScanner();

	public static void main(String[] args) {

		while (true) {
			w = scan.nextInt();
			h = scan.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			input();
			pro();
		}
		System.out.println(sb);
	}

	static void input() {
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = scan.nextInt();
			}
		}
	}

	static void pro() {
		count = 0;
		visit = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					count++;
					bfs(i, j);
				}
			}
		}
		sb.append(count).append('\n');
	}

	static void bfs(int x, int y) {
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		que.add(y);
		visit[x][y] = true;

		while (!que.isEmpty()) {
			x = que.poll();
			y = que.poll();
			for (int k = 0; k < 8; k++) {

				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w)
					continue;
				if (visit[nx][ny])
					continue;
				if (map[nx][ny] == 0)
					continue;
				que.add(nx);
				que.add(ny);
				visit[nx][ny] = true;
			}
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