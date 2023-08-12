
import java.util.*;
import java.io.*;

public class Main {
    static int N;

    static long[] card;
    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        card = new long[N+1];
        for (int i = 1; i <= N; i++) {
            card[i] = scan.nextLong();
        }
    }

    private static void pro() {
        // Sort 정렬하기
        Arrays.sort(card, 1, N+1);
        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = card[1];
        int modeCnt = 1, curCnt = 1;


        // TODO
        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지, 새로운 숫자가 나왔는 지를 판단하여
        // curCnt를 갱신해주고, 최빈값을 갱신하는 작업.
        for (int i = 2; i <= N; i++) {
            if (card[i] == card[i-1]) {
                curCnt++;
                if (curCnt > modeCnt) {
                    mode = card[i];
                    modeCnt = curCnt;
                }
            } else {
                curCnt = 1;
            }
        }
        // 정답 출력하기
        System.out.println(mode);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}
