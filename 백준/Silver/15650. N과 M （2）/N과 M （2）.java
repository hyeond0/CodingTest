import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception {
		input();
		rec_func(1);
		System.out.println(sb.toString());
	}
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M+1];
	}
	
	static void rec_func(int k) {
		if (k == M+1) {
			for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
			sb.append('\n');
		} else {
			for (int cand = selected[k-1] + 1; cand <= N; cand++) {
				selected[k] = cand;
				rec_func(k+1);
				selected[k] = 0;
			}
		}
	}
}