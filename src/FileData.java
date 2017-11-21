
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.BufferedReader;
import java.util.ArrayList;

public class FileData {

	//private int numberOfLines;
	private String path;
	private ArrayList<String> data = new ArrayList<>();
	private ArrayList<Iity> cities = new ArrayList<>();
	
	public FileData(String path) throws IOException{
		this.path = path;
		FileReader file = new FileReader(this.path);
		BufferedReader text = new BufferedReader(file);
		String line;
		while((line=text.readLine())!=null) {
			this.data.add(line);
		}
		text.close();
		file.close();
	}
	public void printData() {
		for(String name : this.data) {
			System.out.println(name);
		}
	}
	public void countCities() {
		boolean matched = false;
		for(String name: this.data) {
			for(Iity city :cities) {
				if(name.equals(city.getName())){
					//System.out.println(name+" = " + city.getName());
					city.increment();
					matched =true;
				}
			}
			if(!matched) {
				addCity(new Iity(name));
			}
			matched = false;
		}
	}
	
	private void addCity(Iity newCity) {
		this.cities.add(newCity);
	}
	public void printCities() {
		for(Iity city :this.cities) {
			System.out.println(city.getName()+"は、　"+city.getCount()+"　件です");
		}
	}
	private String exportCities() {
		String toExport = "";
		for(Iity city :this.cities) {
			toExport += city.getName()+"は、　"+city.getCount()+"　件です"+System.getProperty("line.separator");
		}
		return toExport;
	}
	
	public void exportData() {
		Path path = Paths.get(System.getProperty("user.dir")+"/files/export.txt");
		try {
			Files.write(path,exportCities().getBytes(),StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
