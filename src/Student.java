import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Student implements Comparable<Student>{
	private String name;
	private ArrayList<Integer> marks; //Collections.max などを使うためにこうしました・
	private static ArrayList<String> subjects;
	
	public Student(String name, Integer[] marks) {
		this.name = name;
		this.marks = new ArrayList<>(Arrays.asList(marks));
	}
	
	public String getName() {
		return this.name;
	}
	
	public int totalMarks() {//合計点数を計算する
		int total = 0;
		for(Integer mark:marks) {
			total += mark;
		}
		return total;
	}
	@Override
	public int compareTo(Student other) {//ランキングのために使われる
		if(this.totalMarks()<other.totalMarks()) {
			return 1;
		}
		else if(this.totalMarks()>other.totalMarks()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public Integer getSubjectScore(String subject) {//ある科目のこの生徒の点数を表す
		int index = Student.getSubjects().indexOf(subject);
		if(index >= 0) {
			return this.marks.get(index);
		}
		else {
			System.out.println(this.name+"は"+subject+"をとっておりません");
			return -1;
		}
	}
	
	public int highestScore() 			{//三番に使われる、個人の生徒の高い点数を見つける
		return Collections.max(this.marks);
	}
	public int lowestScore() {			//三番に使われる、個人の生徒の低い点数を見つける
		return Collections.min(this.marks);
	}
	
	public double averageScore() {//平均点数を見つける
		double total = 0d;
		for(Integer score:this.marks) {
			total +=score;
		}
		return (total / ((double) this.marks.size()));
	}
	
	public ArrayList<String> getSubjectsFromScore(int score) {//四番に使われる、何科目でscoreという点数をもらった？
		ArrayList<String> subjects = new ArrayList<>();
		for(int i = 0; i < this.marks.size();i++) {
			if(this.marks.get(i)==score) {
				subjects.add(Student.getSubjects().get(i));
			}
		}
		if(subjects.size()>0) {
			return subjects; //もしほかのところに使う場合にはnullチェックができるために
		}
		return null; //その点数で科目がなかった
	}
	
	
	//科目リストについて：
	public static void setSubjects(ArrayList<String> subjects) {
		Student.subjects = subjects;
	}
	public static ArrayList<String> getSubjects() {
		return Student.subjects;
	
	}
	@Override
	public String toString() {//テストのためにありました
		String result = "";
		result += this.getName();
		for(int i = 0;i<this.marks.size();i++){
			result += Student.getSubjects().get(i)+" - "+this.marks.get(i)+"\n";
		}
		return result;
	}
	
	
}
