package gla.joose.birdsim.boards;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A BirdSim board with where birds simultaneously fly and perch on moving
 * grains.
 */
public class MovingForageBoard extends Board {

	JPanel buttonPanel;
	JButton hatchEggButton;
	JButton feedBirdButton;
	JButton scareBirdsButton;
	JButton starveBirdsButton;

	JLabel noOfGrainsLabel;
	JLabel noOfBirdsLabel;

	Thread runningthread;

	public MovingForageBoard(int rows, int columns) {
		super(rows, columns);
	}

}
