import java.util.Arrays;
import java.util.Scanner;

public class P1983 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			Student[] students = new Student[N];
			for(int i = 0; i < N; i++) {
				int mid = sc.nextInt();
				int fin = sc.nextInt();
				int hm = sc.nextInt();
				double score = mid * 35 + fin * 45 + hm * 20;
				students[i] = new Student(i, score);
			}
			Arrays.sort(students, (s1, s2) -> Double.compare(s2.scores, s1.scores));
			int gradeIndex = 0;
			for(int i = 0; i < N; i++) {
				gradeIndex = (i / (N / 10));
				students[i].grade = grades[gradeIndex];
				if(students[i].index == K - 1) {
					System.out.println("#" + tc + " " + students[i].grade);
					break;
				}
			}
		}
		sc.close();
	}
}

class Student{
	int index;
	double scores;
	String grade;
	
	Student(int index, double scores){
		this.index = index;
		this.scores = scores;
	}
}
