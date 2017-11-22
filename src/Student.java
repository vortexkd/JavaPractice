
public class Student implements Comparable<Student>{
	private String name;
	private Integer[] marks;
	
	public Student(String name, Integer[] marks) {
		this.name = name;
		this.marks = marks;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int totalMarks() {
		int total = 0;
		for(Integer mark:marks) {
			total += mark;
		}
		return total;
	}

	@Override
	public int compareTo(Student other) {
		// TODO Auto-generated method stub
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
	
	
}
