package gla.joose.birdsim.boards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import behaviours.InitBehaviour;
import gla.joose.birdsim.pieces.Grain;

public class ForageInit implements InitBehaviour {

	public void doInitBoard(FlockBoard b) {
		// TODO Auto-generated method stub
		
	}

	public void doInitBoard(final StaticForageBoard b) {
		b.feedBirdButton = new JButton("feed birds");
		b.buttonPanel.add(b.feedBirdButton);
		b.feedBirdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.starveBirdspressed = false;

				Grain grain = new Grain();
				int randRow = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
				int randCol = b.rand.nextInt((b.getColumns() - 3) + 1) + 0;
				b.place(grain, randRow, randCol);
				grain.setDraggable(false);

				b.updateStockDisplay();
			}
		});

		b.starveBirdsButton = new JButton("starve birds");
		b.buttonPanel.add(b.starveBirdsButton);
		b.starveBirdsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.starveBirdspressed = true;

			}
		});

		b.scareBirdsButton = new JButton("scare birds");
		b.buttonPanel.add(b.scareBirdsButton);
		b.scareBirdsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.scareBirds = true;

			}
		});
		b.noOfBirdsLabel = new JLabel();
		b.noOfBirdsLabel.setText("#birds: " + 0);
		b.buttonPanel.add(b.noOfBirdsLabel);

		b.noOfGrainsLabel = new JLabel();
		b.noOfGrainsLabel.setText("#grains: " + 0);
		b.buttonPanel.add(b.noOfGrainsLabel);
	}

	public void doInitBoard(final MovingForageBoard b) {
		 b.feedBirdButton = new JButton("feed birds");
		 b.buttonPanel.add(b.feedBirdButton);
		 b.feedBirdButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	b.starveBirds = false;

	            	Grain grain = new Grain();
	            	int randRow = b.rand.nextInt((b.getRows() - 3) + 1) + 0;
	            	int randCol = b.rand.nextInt((b.getColumns() - 3) + 1) + 0;
	            	b.place(grain,randRow, randCol);
	        		grain.setDraggable(false);
	        		
	        		b.updateStockDisplay();
	        }}); 

		 b.starveBirdsButton = new JButton("starve birds");
		 b.buttonPanel.add(b.starveBirdsButton);
		 b.starveBirdsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	b.starveBirds = true;

	        }}); 
	        
		 b.scareBirdsButton = new JButton("scare birds");
		 b.buttonPanel.add(b.scareBirdsButton);
		 b.scareBirdsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	b.scareBirds = true;

	        }}); 
		 b.noOfBirdsLabel = new JLabel();
		 b.noOfBirdsLabel.setText("#birds: "+0);
		 b.buttonPanel.add(b.noOfBirdsLabel);

		 b.noOfGrainsLabel = new JLabel();
		 b.noOfGrainsLabel.setText("#grains: "+0);
		 b.buttonPanel.add(b.noOfGrainsLabel);
	}

}
