
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Multiples();
		//new TeamScore();
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
