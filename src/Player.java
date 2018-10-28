import java.util.ArrayList;

public class Player {
	public String name;
	public ArrayList<ArrayList<String>> rollResults;
	
	public Player(String name) {
		this.name = name;
		this.rollResults = new ArrayList<ArrayList<String>>();
	}
	
	public void getResult() {
		System.out.println("Player " + this.name + ":");
		for (ArrayList<String> i:rollResults) {
			for (String j: i) {
				System.out.println(j);
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}
}
