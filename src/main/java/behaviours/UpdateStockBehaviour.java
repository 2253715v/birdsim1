package behaviours;

import gla.joose.birdsim.boards.FlockBoard;
import gla.joose.birdsim.boards.MovingForageBoard;
import gla.joose.birdsim.boards.StaticForageBoard;

public interface UpdateStockBehaviour {
	public void doUpdateStock(FlockBoard b);
	public void doUpdateStock(StaticForageBoard b);
	public void doUpdateStock(MovingForageBoard b);
}
