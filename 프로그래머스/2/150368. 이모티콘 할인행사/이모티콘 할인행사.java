class Solution {
    static int N, M;
    static int[] selected;
    static int plus, price;
    static StringBuilder sb = new StringBuilder();
    public int[] solution(int[][] users, int[] emoticons) {
        N = 4;
        M = emoticons.length;
        selected = new int[emoticons.length];
        plus = Integer.MIN_VALUE;
        price = Integer.MIN_VALUE;
        rec_func(0, users, emoticons);
        
        return new int[]{plus, price};
    }
    
    static void rec_func(int k, int[][] users, int[] emoticons) {
        if (k == M) {
            int[] result = cal_emoticon(users, emoticons);
            if (result[0] > plus) {
                plus = result[0];
                price = result[1];
            }
            else if (result[0] == plus) {
                if (result[1] > price) price = result[1];
            }
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand * 10;
                rec_func(k+1, users, emoticons);
                selected[k] = 0;
            }
        }
    }
    
    static int[] cal_emoticon(int[][] users, int[] emoticons) {
        int sum = 0;
        int register = 0;
        for (int[] user : users) {
            int rate = user[0];
            int max = user[1];
            int buy = 0;
            for (int i = 0; i < selected.length; i++) {
                if (selected[i] >= rate){                 
                    buy += emoticons[i] - (emoticons[i] / 100 * selected[i]);
                    if (buy >= max) {
                        register++;
                        buy = 0;
                        break;
                    }
                }
            }
            sum += buy;
        }
        return new int[]{register, sum};
    }
}