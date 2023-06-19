import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> gradeList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            gradeList.add(sc.nextInt());
        }
        int M = Collections.max(gradeList);
        ArrayList<Double> newGradeList = new ArrayList<Double>();
        for (int i=0; i< gradeList.size();i++)
        {
            int a = gradeList.get(i);
            double b = (double)a / M;
            double newGrade = b * 100;
            newGradeList.add(newGrade);
        }
        double sum = 0;
        for (int i=0; i< newGradeList.size();i++)  {
            sum += newGradeList.get(i);
        }

        System.out.println(sum / newGradeList.size());
    }
}