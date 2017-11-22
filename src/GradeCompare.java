import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GradeCompare {

	private ArrayList<Integer[]> data = new ArrayList<>(); // has scores
	//private ArrayList<String> subjects; // has subjects
	private ArrayList<String> names = new ArrayList<>(); //has names.
	
	private ArrayList<Student> students = new ArrayList<>();
	
	public GradeCompare(ArrayList<String[]> d) {
		for(int i=0;i<d.size();i++) {
			if(i==0) {
//				this.subjects = new ArrayList<>(
//						Arrays.asList(
//								Arrays.copyOfRange(d.get(i),1,d.get(i).length)//removes title of first column.
//								));//remove
				Student.setSubjects(new ArrayList<String>(
						Arrays.asList(
								Arrays.copyOfRange(d.get(i),1,d.get(i).length)//removes title of first column.
								)));
			}
			else {
				this.names.add(d.get(i)[0]);
				Integer[] temp = new Integer[4];
				for(int j = 1;j<d.get(i).length;j++) {
					temp[j-1] = Integer.parseInt(d.get(i)[j]);
				}
				this.data.add(temp);//remove
				students.add(new Student(d.get(i)[0],temp));
				
			}
		}
	}
	
	public ArrayList<String> getNames() {
		return this.names;
	}
	
	public ArrayList<String> getSubjects(){
		return Student.getSubjects();
	}
	public String findTopSubjectScorer(String subject) {//ある科目の最高点数の持ち主の名前を見つける
		int column = getSubectColumn(subject);
		int row = getHighestRowInColumn(column);
		return this.names.get(row);
		
	}
	public Integer findTopScoreInSubject(String subject) {//ある科目の最高点数を見つける
		int column = getSubectColumn(subject);
		int row = getHighestRowInColumn(column);
		Student student = getStudentFromName(subject);
		return this.data.get(row)[column];
	}
	
	public double getAverageWithoutLowest(String subject) {//科目の平均を計算する（少点数二位まで）
		int column = getSubectColumn(subject);
		double total = 0d;
		int min = 100;
		for(Integer[] row:this.data) {
			if(row[column]<min) {
				min = row[column];
			}
			total += row[column];
		}
		total -= min;
		return (total / ((double) this.names.size()-1));
	}
	
	public int totalScore(String name) {//ある人の合計点数を計算する
		int row =  getNameRow(name);
		int total = 0;
		for(Integer score:this.data.get(row)) {
			total += score;
		}
		return total;
	}
	public double averageScore(String name) {
		int row =  getNameRow(name);
		double average = 0d;
		for(Integer score:this.data.get(row)) {
			average += score;
		}
		return (average / ((double) Student.getSubjects().size()));
	}
	public int studentHighScore(String name) {
		int row =  getNameRow(name);
		int topScore = 0;
		for(Integer score:this.data.get(row)) {
			if(score > topScore) {
				topScore = score;
			}
		}
		return topScore;
	}
	
	public int studentLowScore(String name) {
		int row =  getNameRow(name);
		int lowScore = 100;
		for(Integer score:this.data.get(row)) {
			if(score < lowScore) {
				lowScore = score;
			}
		}
		return lowScore;
	}
	
	public ArrayList<String> getSubjectsFromScore(String name,int score) {
		int row =  getNameRow(name);
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0;i<Student.getSubjects().size();i++) {
			if(this.data.get(row)[i]==score) {
				result.add(Student.getSubjects().get(i));
			}
		}
		return result;
	}
	
	public ArrayList<Student> getOrderedList(){
		Collections.sort(this.students);
		return this.students;
	}
	private Student getStudentFromName(String name) {
		for(Student student:this.students) {
			if(student.getName()==name) {
				return student;
			}
		}
		return null;
	}
	private int getSubectColumn(String subject) {//科目の配列順番号を返す
		return Student.getSubjects().indexOf(subject);
	}
	private int getNameRow(String name) {
		return this.names.indexOf(name);
	}
	private int getHighestRowInColumn(int column) {//上下で比べたら、最高点数は？
		ArrayList<Integer> subjectScores = new ArrayList<>();
		for(Integer[] row:this.data) {
			subjectScores.add(row[column]);
		}
		return subjectScores.indexOf(Collections.max(subjectScores));
	}
	
	


	
} 
