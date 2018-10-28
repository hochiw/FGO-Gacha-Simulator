
public class Card {
	
	private int rarity;
	private Type type;
	public enum Type {
		Servant,
		CraftEsscense
	}
	
	public Card(int rarity,Type type) {
		this.rarity = rarity;
		this.type = type;
	}
	
	public int getRarity() {
		return rarity;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override 
	public String toString() {
		if (rarity >= 5 && type == Type.Servant) {
			return "<" + rarity + " " + type + ">";
		}
		return rarity + " " + type;
	  }
}
