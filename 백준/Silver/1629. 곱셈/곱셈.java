import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long answer = func(a,b,m);
        System.out.println(answer);
    }

    public static long func(long a, long b, long m) {
       if (b == 1) return a % m;
       long value = func(a, b/2, m);
       value = value * value % m;
       if (b % 2 ==0) return value; // b가 짝수일 때
       return value * a % m; // b가 홀수일 때
    }
}