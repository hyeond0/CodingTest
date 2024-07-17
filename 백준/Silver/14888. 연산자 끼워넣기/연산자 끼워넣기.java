import java.util.*;
import java.io.*;

public class Main {
	static int N, max, min, result;
	static int[] nums, selected, cals;
	
	public static void main(String[] args) {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		input();
		rec_func(1);
		System.out.println(max);
		System.out.println(min);		
	}
	
	static void rec_func(int k) {
		if (k == N) {
			result = calc_nums();
			if (result > max) max = result;
			if (result < min) min = result;
		} else {
			for (int cand = 1; cand < N; cand++) {
				boolean isUsed = false;
				for (int i = 1; i < k; i++) {
					if (selected[i] == cand) isUsed = true;
				}
				if (!isUsed) {
					selected[k] = cand;
					rec_func(k+1);
					selected[k] = 0;
				}
			}
		}
	}
	
	
	
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		int count = 0;
		cals = new int[N];
		int index = 1;
		for (int i = 1; i <= 4; i++) {
			count = sc.nextInt();
			while (count > 0) {
				cals[index++] = i;
				count--;
			}
		}
		selected = new int[N];
	}
	
	static int calc_nums() {
		int num = nums[1];
		for (int i = 1; i < N; i++) {
			if (cals[selected[i]] == 1) {
				num += nums[i+1];
			} else if (cals[selected[i]] == 2) {
				num -= nums[i+1];
			} else if (cals[selected[i]] == 3) {
				num *= nums[i+1];
			} else {
				num /= nums[i+1];
			}
		}
		return num;
	}
}