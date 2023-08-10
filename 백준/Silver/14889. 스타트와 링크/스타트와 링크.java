import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, min;
    static int[][] S;
    static int[] selected;
    static boolean[] numUsed;



    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N + 1][N + 1];
        selected = new int[N + 1];
        numUsed = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void rec_func(int k) {
        if (k == N / 2 + 1) {
            int index = N / 2 + 1;
            for (int i = 1; i <= N; i++) {
                if (!numUsed[i]) {
                    selected[index] = i;
                    index++;
                }
            }
            calcStatus();
        } else {
            int start = selected[k-1]; // 이전에 쓰였던 숫자보다 크거나 같아야 함.
            for (int cand = start + 1; cand <= N; cand++) {
                // 중복 체크
                selected[k] = cand;
                numUsed[cand] = true;
                rec_func(k+1);
                selected[k] = 0;
                numUsed[cand] = false;
            }
        }
    }

    private static void calcStatus() {
        // start와 link 로 나누기
        int[] start = new int[N / 2 + 1];
        int[] link = new int[N / 2 + 1];
        for (int i = 1; i <= N / 2; i++) {
            start[i] = selected[i];
            link[i] = selected[N / 2 + i];
        }
        // start와 link 계산하기
        int startSum = calcSum(start);
        int linkSum = calcSum(link);
        // 최솟값 확인하기
        min = Math.min(min, Math.abs(startSum - linkSum));
    }

    private static int calcSum(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) { // 두 사람을 선택해 능력치를 계산
            for (int j = i + 1; j < arr.length; j++) { // 조합이므로 앞선 사람의 다음 사람부터 탐색
                sum = sum + S[arr[i]][arr[j]] + S[arr[j]][arr[i]]; // 두 경우를 모두 더해준다.'
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        input();
        min = Integer.MAX_VALUE;
        rec_func(1);
        System.out.println(min);
    }
}