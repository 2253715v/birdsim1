package gla.joose.birdsim.boards;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A BirdSim board with generic bird flying behaviour.
 */
public class FlockBoard extends Board {

	JPanel buttonPanel;
	JButton hatchEggButton;
	JButton scareBirdsButton;
	JLabel noOfBirdsLabel;

	Thread runningthread;

	public FlockBoard(int rows, int columns) {
		super(rows, columns);
	}

}
