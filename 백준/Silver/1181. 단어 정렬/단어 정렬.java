import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static Elem[] words;
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {
        public int len;
        public String alphabet;

        @Override
        public int compareTo(Elem other) {
            if (len != other.len) return len - other.len;
            return alphabet.compareTo(other.alphabet);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        words = new Elem[N];
        for (int i = 0; i < N; i++) {
            words[i] = new Elem();
            words[i].alphabet = sc.next();
            words[i].len = words[i].alphabet.length();
        }
    }

    private static void pro() {
        Arrays.sort(words);
        String temp = "";
        for (Elem word : words) {
            if (!word.alphabet.equals(temp)) sb.append(word.alphabet).append('\n');
            temp = word.alphabet;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb.toString());
    }
}

