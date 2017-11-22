import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GradeCompare2 {
	private ArrayList<Student> students = new ArrayList<>();
	public GradeCompare2(ArrayList<String[]> d) {
		for(int i=0;i<d.size();i++) {
			if(i==0) {

				Student.setSubjects(new ArrayList<String>(
						Arrays.asList(
								Arrays.copyOfRange(d.get(i),1,d.get(i).length)//removes title of first column.
								)));
			}
			else {
				Integer[] temp = new Integer[4];
				for(int j = 1;j<d.get(i).length;j++) {
					temp[j-1] = Integer.parseInt(d.get(i)[j]);
				}
				this.students.add(new Student(d.get(i)[0],temp));
				
			}
		}
	}
	public ArrayList<String> getNames() {//生徒の名前を返す
		ArrayList<String> names = new ArrayList<>();
		for(Student student:this.students) {
			names.add(student.getName());
		}
		return names;
	}
	
	public int findTopScoreInSubject(String subject) {//ある科目の最高点数を見つける
		int topScore = 0;
		for(Student student : this.students) {
			if(student.getSubjectScore(subject)>topScore) {
				topScore = student.getSubjectScore(subject);
			}
		}
		return topScore;
	}
	
	public String findTopSubjectScorer(String subject) {//ある科目の最高点数の持ち主の名前を見つける
		Student topScorer = this.students.get(0);
		for(Student student : this.students) {
			if(student.getSubjectScore(subject)>topScorer.getSubjectScore(subject)) {
				topScorer = student;
			}
		}
		return topScorer.getName();
	}
	
	public double getAverageWithoutLowest(String subject) {//科目の平均を計算する（少点数二位まで）
		if(Student.getSubjects().indexOf(subject)<0) {
			System.out.println("生徒たちはその科目を取ってません");
			return 0;
		}
		double total = 0d;
		int min = 100;
		for(Student student:this.students) {
			int score = student.getSubjectScore(subject);
			if(score<min) {
				min = score;
			}
			total += score;
		}
		total -= min;
		
		return (total / ((double) this.students.size()-1));
	}
	
	public int totalScore(String name) {//ある人の合計点数を計算する
		Student student = getStudentFromName(name);
		return student.totalMarks();
	}
	
	public int studentHighScore(String name) {//三番に使われる、個人の生徒の高い点数を見つける
		Student student = getStudentFromName(name);
		return student.highestScore();
	}
	
	public int studentLowScore(String name) {
		Student student = getStudentFromName(name);
		return student.lowestScore();
	}
	public double averageScore(String name) {
		Student student = getStudentFromName(name);
		return student.averageScore();
	}
	
	public ArrayList<String> getSubjectsFromScore(String name,int score) {
		Student student = getStudentFromName(name);
		return student.getSubjectsFromScore(score);
	}
	
	public ArrayList<Student> getOrderedList(){
		Collections.sort(this.students);
		return this.students;
	}
	
	public ArrayList<String> getSubjects(){
		return Student.getSubjects();
	}
	
	private Student getStudentFromName(String name) {
		for(Student student:this.students) {
			if(student.getName()==name) {
				return student;
			}
		}
		return null;
	}
	

}
