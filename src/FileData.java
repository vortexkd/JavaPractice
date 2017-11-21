
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class FileData {

	//private int numberOfLines;
	private String path;
	private ArrayList<String> data = new ArrayList<>();
	private ArrayList<City> cities = new ArrayList<>();
	
	public FileData(String path) throws IOException{
		this.path = path;
		FileReader file = new FileReader(this.path);
		BufferedReader text = new BufferedReader(file);
		String line;
		while((line=text.readLine())!=null) {
			this.data.add(line);
		}
		text.close();
	}
	public void printData() {
		for(String name : this.data) {
			System.out.println(name);
		}
	}
	public void countCities() {
		boolean matched = false;
		for(String name: this.data) {
			for(City city:cities) {
				if(name.equals(city.getName())){
					//System.out.println(name+" = " + city.getName());
					city.increment();
					matched =true;
				}
			}
			if(!matched) {
				addCity(new City(name));
			}
			matched = false;
		}
	}
	
	private void addCity(City newCity) {
		this.cities.add(newCity);
	}
	public void printCities() {
		for(City city :this.cities) {
			System.out.println(city.getName()+"は、　"+city.getCount()+"　件です");
		}
	}
}
