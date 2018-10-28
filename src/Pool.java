import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pool {
	
	List<Card> pool;
	
	public Pool() {
		// Initiate the gacha pool
		this.pool = Collections.synchronizedList(initiate());
	}
	
	public ArrayList<Card> initiate() {
		// Create new arraylist
		ArrayList<Card> pool = new ArrayList<Card>(100);
		// Refill the pool
		refill(pool);
		return pool;
	}
	
	/**
	 * Function that adds cards according to the provided percentages
	 * @param pool
	 */
	public void refill(List<Card> pool) {
		for (int i = 0; i < 1; i++) {
			pool.add(new Card(5,Card.Type.Servant));
		}		
		for (int i = 0; i < 4; i++) {
			pool.add(new Card(5,Card.Type.CraftEsscense));
		}
		for (int i = 0; i < 3; i++) {
			pool.add(new Card(4,Card.Type.Servant));
		}
		for (int i = 0; i < 12; i++) {
			pool.add(new Card(4,Card.Type.CraftEsscense));
		}
		for (int i = 0; i < 40; i++) {
			pool.add(new Card(3,Card.Type.Servant));
		}
		for (int i = 0; i < 40; i++) {
			pool.add(new Card(3,Card.Type.CraftEsscense));
		}
		// Shuffle the cards
		Collections.shuffle(pool);
	}
	
	public List<Card> getPool() {return pool;}
	
	/**
	 * Function that handles the card pulling
	 * @return card
	 */
	public Card pull() {
		synchronized (pool) {
			// Refill if the pool is empty
			if (pool.isEmpty()) {
				refill(pool);
			}
			// Pull the first card
			return pool.remove(0);
			
		}	
	}
	
	/**
	 * Function to get a servant 
	 * @return servant card
	 */
	public Card getServant() {
		while (true) {
			for (Card i:pool) {
				if (i.getType() == Card.Type.Servant) {
					return i;
				}
			}
			refill(pool);
		}
	}
	
	/**
	 * Function to get any card with rarity of 4 or above
	 * @return card
	 */
	public Card getFour() {
		while (true) {
			for (Card i:pool) {
				if (i.getRarity() >= 4) {
					return i;
				}
			}
			refill(pool);
		}
	}

	public ArrayList<String> pull10() {
		ArrayList<String> result = new ArrayList<String>();
		synchronized (pool) {
			while (result.size() < 8) {
				if (pool.isEmpty()) {
					refill(pool);
				}
				result.add(pool.remove(0).toString());
			}
			
			// Guaranteed at least 1 servant and 1 SR
			result.add(getFour().toString());
			result.add(getServant().toString());
 			
		}
		return result;
	}
}
