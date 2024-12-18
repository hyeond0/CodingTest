import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int k, l;
    static Map<String, Integer> a;
    static String[] arr;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        k = scan.nextInt();
        l = scan.nextInt();
        a = new HashMap<>();
        arr = new String[l + 1];
        for (int i = 1; i <= l; i++) {
            String stNum = scan.next();
            a.put(stNum, i);
        }
        for (String key : a.keySet()) {
            arr[a.get(key)] = key;
        }

        int count = 0;
        for (int i = 1; i <= l; i++) {
            if (arr[i] == null) {
                continue;
            }
            sb.append(arr[i]).append('\n');
            count++;
            if (count == k) {
                break;
            }
        }
        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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
    }
}
