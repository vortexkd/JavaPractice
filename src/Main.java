
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 1;
		int column = 2;
		String eachLine = "";
		while(row <= 9) {
			eachLine = ""+row;
			while(column <= 9) {
				eachLine =eachLine+"\t"+(row*column);
				column++;
			}
			System.out.println(eachLine);
			row++;
			column =2;
		}
	}

}
