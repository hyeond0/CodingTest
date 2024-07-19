import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] a;

	static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = scan.nextInt();
		}
	}

	static void pro() {
		int ans = 0;
		int last = 0;
		Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			last += a[i];
			ans += last;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		input();
		pro();
	}
}
