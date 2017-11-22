
public class RunFileExercise {

	public RunFileExercise() {
		try {
			FileData myData = new FileData(System.getProperty("user.dir")+"/files/filePractice01.txt");
			//myData.printData();
			myData.countCities();
			myData.printCities();
			myData.exportData();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}
