
public class Iity {
	private int count;
	private String name;
	public Iity(String name) {
		this.count = 1;
		this.name = name;
	}
	
	public void increment() {
		this.count += 1;
	}
	public String getName() {
		return this.name;
	}
	public int getCount() {
		return this.count;
	}
	
}
