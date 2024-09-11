import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] rotate = new int[5]; // 0은 회전 x, 1은 시계, 2는 반시계
    static int[][] wheels = new int[5][8];
    static Node[] nodes = new Node[5];
    static int k;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        for (int i = 1; i <= 4; i++) {
            String s = scan.next();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = s.charAt(j) - '0';
            }

            // 맞닿는 부분 정리
            if (i == 1) {
                nodes[i] = new Node(null, 2);
            } else if (i == 4) {
                nodes[i] = new Node(6, null);
            } else {
                nodes[i] = new Node(6, 2);
            }
        }
        k = scan.nextInt();
    }

    static void pro() {
        while (k-- > 0) {
            for (int i = 1; i <= 4; i++) {
                rotate[i] = 0;
            }
            int wheel = scan.nextInt();
            int dir = scan.nextInt();
            rotate[wheel] = dir;
            int tmp = wheel;
            if (dir == -1) {
                // 반시계
                while (tmp < 4) {
                    Integer next = nodes[tmp].next;
                    Integer before = nodes[tmp + 1].before;
                    if (before == null || next == null) {
                        rotate[tmp + 1] = 0;
                        break;
                    }
                    if (wheels[tmp][next] != wheels[tmp + 1][before]) {
                        if (rotate[tmp] == 1) {
                            rotate[tmp + 1] = -1;
                        } else if (rotate[tmp] == -1) {
                            rotate[tmp + 1] = 1;
                        }
                    } else {
                        rotate[tmp + 1] = 0;
                        break;
                    }
                    tmp++;
                }
                tmp = wheel;
                while (tmp > 1) {
                    Integer before = nodes[tmp].before;
                    Integer next = nodes[tmp - 1].next;
                    if (before == null || next == null) {
                        rotate[tmp - 1] = 0;
                        break;
                    }
                    if (wheels[tmp][before] != wheels[tmp - 1][next]) {
                        if (rotate[tmp] == 1) {
                            rotate[tmp - 1] = -1;
                        } else if (rotate[tmp] == -1) {
                            rotate[tmp - 1] = 1;
                        }
                    } else {
                        rotate[tmp - 1] = 0;
                        break;
                    }
                    tmp--;
                }
            } else {
                // 시계
                while (tmp < 4) {
                    Integer next = nodes[tmp].next;
                    Integer before = nodes[tmp + 1].before;
                    if (before == null || next == null) {
                        rotate[tmp + 1] = 0;
                        break;
                    }
                    if (wheels[tmp][next] != wheels[tmp + 1][before]) {
                        if (rotate[tmp] == 1) {
                            rotate[tmp + 1] = -1;
                        } else if (rotate[tmp] == -1) {
                            rotate[tmp + 1] = 1;
                        }
                    } else {
                        rotate[tmp + 1] = 0;
                        break;
                    }
                    tmp++;
                }
                tmp = wheel;
                while (tmp > 1) {
                    Integer before = nodes[tmp].before;
                    Integer next = nodes[tmp - 1].next;
                    if (before == null || next == null) {
                        rotate[tmp - 1] = 0;
                        break;
                    }
                    if (wheels[tmp][before] != wheels[tmp - 1][next]) {
                        if (rotate[tmp] == 1) {
                            rotate[tmp - 1] = -1;
                        } else if (rotate[tmp] == -1) {
                            rotate[tmp - 1] = 1;
                        }
                    } else {
                        rotate[tmp - 1] = 0;
                        break;
                    }
                    tmp--;
                }
            }
            for (int i = 1; i <= 4; i++) {
                rotation(rotate[i], i);
            }
        }

        // 점수 계산
        int sum = 0;
        int idx;
        for (int i = 1; i <= 4; i++) {
            if (nodes[i].before == null) {
                idx = nodes[i].next - 2;
            } else {
                idx = nodes[i].before - 6;
            }
            if (idx < 0) {
                idx += 8;
            }
            if (wheels[i][idx] == 1) {
                if (i == 1) {
                    sum += 1;
                } else if (i == 2) {
                    sum += 2;
                } else if (i == 3) {
                    sum += 4;
                } else {
                    sum += 8;
                }
            }
        }
        System.out.println(sum);
    }

    static void rotation(int dir, int idx) {
        if (dir == 0) {
            return;
        }
        if (dir == 1) {
            if (nodes[idx].before != null) {
                nodes[idx].before -= 1;
                if (nodes[idx].before < 0) {
                    nodes[idx].before = 7;
                }
            }
            if (nodes[idx].next != null) {
                nodes[idx].next -= 1;
                if (nodes[idx].next < 0) {
                    nodes[idx].next = 7;
                }
            }
        }
        if (dir == -1) {
            if (nodes[idx].before != null) {
                nodes[idx].before += 1;
                if (nodes[idx].before > 7) {
                    nodes[idx].before = 0;
                }
            }
            if (nodes[idx].next != null) {
                nodes[idx].next += 1;
                if (nodes[idx].next > 7) {
                    nodes[idx].next = 0;
                }
            }
        }
    }

    static class Node {
        Integer before;
        Integer next;

        public Node(Integer before, Integer next) {
            this.before = before;
            this.next = next;
        }
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
