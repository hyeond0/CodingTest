import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int t;
  static FastReader scan = new FastReader();

  public static void main(String[] args) {
    t = scan.nextInt();
    for (int j = 0; j < t; j++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      int r = 1;

      for (int i = 0; i < b; i++) {
        r = (r * a) % 10;
      }
      if (r == 0) {
        r = 10;
      }
      System.out.println(r);
    }
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
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
