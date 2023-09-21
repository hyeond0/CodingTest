import java.util.*;
import java.io.*;

public class Main {

    static int N, M, R;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int d = 0;
    static int[][] map, temp;
    static StringBuilder sb = new StringBuilder();

    public static void input() {
    	Scanner scan = new Scanner(System.in);
    	N = scan.nextInt();
    	M = scan.nextInt();
    	R = scan.nextInt();
    	map = new int[N][M];
    	temp = new int[N][M];
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			map[i][j] = scan.nextInt();
    		}
    	}
    }
    
    public static void process() {
    	// 0행 0열부터 회전
    	// R번 회전
    		while(--R >= 0) {
    			int initX = 0, initY = 0;
        		int x = initX, y = initY;
        		while (initX < N/2+1 && initY < M/2+1) {
        			x = initX;
        			y = initY;
        			d = 0;
    	    		while (true) {
    	    			int nx = x + dir[d][0];
    	    			int ny = y + dir[d][1];
    	    			if (nx < 0 || ny < 0 || nx >= N || ny >= M || temp[nx][ny] != 0) {
    	    				d = (d+1) % 4;
    	    			} else {
    	        			temp[nx][ny] = map[x][y];
    	        			x = nx;
    	        			y = ny;
    	    			}
    	    			if (x == initX && y == initY) {
    	    				initX++;
    	    				initY++;
    	    				break;
    	    			}
    	    		}
        		}
        		for (int i = 0; i < N; i++) {
        			for (int j = 0; j < M; j++) {
        				map[i][j] = temp[i][j];
        				temp[i][j] = 0;
        			}
        		}
    		}
    		
    		for (int i = 0; i < N; i ++) {
    			for (int j = 0; j < M; j++) {
    				sb.append(map[i][j]).append(' ');
    			}
    			sb.append('\n');
    		}
    		System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        process();
    }
}