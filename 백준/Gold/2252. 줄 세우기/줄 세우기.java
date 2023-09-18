import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;

    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	adj = new ArrayList[N+1];
    	indeg = new int[N+1];
    	for (int i = 1; i <= N; i++) {
    		adj[i] = new ArrayList<>();
    	}
    	for (int i = 0; i < M; i++) {
    		int x = scan.nextInt(), y = scan.nextInt();
    		adj[x].add(y);
    		indeg[y]++;
    	}
    }

    static void pro() {
        Deque<Integer> Q = new LinkedList<>();
        for (int i = 1 ; i <=N;i++) {
        	if (indeg[i] == 0) Q.add(i);
        }
        while (!Q.isEmpty()) {
        	int x = Q.poll();
        	sb.append(x).append(' ');
        	for (int y : adj[x]) {
        		indeg[y]--;
        		if (indeg[y] == 0) Q.add(y);
        	}
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}