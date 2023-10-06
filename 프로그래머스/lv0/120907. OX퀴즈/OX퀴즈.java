class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int index = 0;
        for (String question : quiz) {
            String[] cal = question.split(" = ")[0].split(" ");
            int ans = Integer.parseInt(question.split(" = ")[1]);
            int left = Integer.parseInt(cal[0]);
            int right = Integer.parseInt(cal[2]);
            if (cal[1].equals("-")) {
                if (left - right == ans) {
                    answer[index++] = "O";
                } else {
                    answer[index++] = "X";
                }
            } else {
                if (left + right == ans) {
                    answer[index++] = "O";
                } else {
                    answer[index++] = "X";
                }
            }
        }
        return answer;
    }
}