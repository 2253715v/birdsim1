package behaviours;

import gla.joose.birdsim.boards.FlockBoard;
import gla.joose.birdsim.boards.MovingForageBoard;
import gla.joose.birdsim.boards.StaticForageBoard;

public interface InitBehaviour {
	public void doInitBoard(FlockBoard b);
	public void doInitBoard(StaticForageBoard b);
	public void doInitBoard(MovingForageBoard b);

}
