import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		// TODO Auto-generated method stub
		Pool pool = new Pool();
		ArrayList<Player> playerList = new ArrayList<Player>();
		CyclicBarrier gate = new CyclicBarrier(1500);
		
		// Wait until all players are created
		for (int i = 0; i < 1500;i++) {
			Player player = new Player(Integer.toString(i));
			new Thread() {
				@Override
				public void run() {
					try {
						gate.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					player.rollResults.add(pool.pull10());
				}
			}.start();
			playerList.add(player);
		}
		
		// Wait for the gacha to finish
		gate.await();
		
		for (Player k:playerList) {
			k.getResult();	
		}
	}

}
