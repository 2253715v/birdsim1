package gla.joose.birdsim.boards;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A BirdSim board with where birds simultaneously fly and perch on static
 * grains.
 */
public class StaticForageBoard extends Board {

	JPanel buttonPanel;
	JButton hatchEggButton;
	JButton feedBirdButton;
	JButton scareBirdsButton;
	boolean scareBirds;
	JButton starveBirdsButton;
	boolean starveBirdspressed;

	JLabel noOfGrainsLabel;
	JLabel noOfBirdsLabel;

	Thread runningthread;

	public StaticForageBoard(int rows, int columns) {
		super(rows, columns);
	}

}
