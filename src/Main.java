import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Multiples();
		//new TeamScore();
		//new RunFileExercise();
		CsvReader csvReader = new CsvReader(System.getProperty("user.dir")+"/files/csvPractice01.csv");
		GradeCompare2 grades = new GradeCompare2(csvReader.getData());
		
		System.out.println("1.数学の最高得点");
		System.out.println(grades.findTopScoreInSubject("数学"));
		System.out.println("\n2.各科目の最高得点者の氏名と得点\n");
		topScorers(grades);
		System.out.println("\n3. 各科目の平均点（小数点第二位まで）\n");
		printSubjectAverages(grades);
		System.out.println("\n4. 人別の全科目合計点・全科目平均点・最高点だった教科と点数・最低点だった教科と点数\n");
		printScoreDetails(grades);
		System.out.println("\n5. 成績の合計点順のランキング\n");
		printRankings(grades); 
	}
	
	public static void topScorers(GradeCompare2 grades) {
		//findTopSubjectScorer
		for(String subject :grades.getSubjects()) {
			System.out.println(subject+"の最高得点者は、"+grades.findTopSubjectScorer(subject)+"、"+grades.findTopScoreInSubject(subject)+"点です。");//全部同じ人でした。。。。
		}
	}
	public static void printSubjectAverages(GradeCompare2 grades) {
		for (String subject:grades.getSubjects()) {
			System.out.println(subject+"の平均点数（小数点第二位まで）は"+grades.getAverageWithoutLowest(subject)+"点です。");
		}
	}
	public static void printScoreDetails(GradeCompare2 grades) {
		DecimalFormat df = new DecimalFormat("#.00");
		String toPrint = "";
		for(String name:grades.getNames()) {
			toPrint = name+"さんの全科目合計点は"+grades.totalScore(name)+
					"点、全科目平均点は"+df.format(grades.averageScore(name))+
					"点、最高点"+makeSubjectString(grades.getSubjectsFromScore(name,grades.studentHighScore(name)))+"で"+grades.studentHighScore(name)+
					"点、最低点は"+makeSubjectString(grades.getSubjectsFromScore(name,grades.studentLowScore(name)))+"で"+grades.studentLowScore(name)+
					"です。";
			System.out.println(toPrint);
		}
		
		//(name)さんの全科目合計点は(sum)点、全科目平均点は(average)点、最高点は    数学で(high)点、最低点は物******理と化学******で、(low)点です。
	}
	public static String makeSubjectString(ArrayList<String> array) {//配列を文字に変えて”と”を入れる - 佐藤さんのためにです。
		String result="";
		for(int i=0;i<array.size();i++) {
			result+= (i > 0) ? "と"+array.get(i)	  :   array.get(i);
		}
		return result;
	}
	public static void printRankings(GradeCompare2 grades) {
		ArrayList<Student> rankings = grades.getOrderedList();
		for(int i = 0; i<rankings.size();i++) {
			System.out.println((i+1)+"位： "+rankings.get(i).getName()+"さん "+rankings.get(i).totalMarks()+"点");
		}
	}

}
