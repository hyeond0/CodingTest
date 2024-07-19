import java.util.*;
import java.io.*;

public class Main {
	static int N, max;
	static int[] selected, a;

	static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		selected = new int[N];
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = scan.nextInt();
		}
		max = Integer.MIN_VALUE;
	}

	static int calc_max() {
		int result = 0;
		for (int i = 0; i < N-1; i++) {
			result += Math.abs(a[selected[i]] - a[selected[i+1]]);
		}
		return result;
	}
	
	static void rec_func(int k) {
		if (k == N) {
			for (int i = 0; i < N; i++) {
				max = Math.max(max, calc_max());
			}
		} else {
			for (int cand = 0; cand < N; cand++) {
				boolean isUsed = false;
				for (int i = 0; i < k; i++) {
					if (selected[i] == cand) {
						isUsed = true;
					}
				}
				if (!isUsed) {
					selected[k] = cand;
					rec_func(k + 1);
					selected[k] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(0);
		System.out.println(max);
	}
}
