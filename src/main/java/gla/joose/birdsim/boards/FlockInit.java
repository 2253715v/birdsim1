package gla.joose.birdsim.boards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import behaviours.InitBehaviour;

public class FlockInit implements InitBehaviour {
	public void doInitBoard(final FlockBoard b) {
		b.hatchEggButton = new JButton("hatch egg");
		b.buttonPanel.add(b.hatchEggButton);
		b.hatchEggButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				b.scareBirds = false;
				b.runningthread = new Thread(new Runnable() {
					public void run() {
						b.performFly();
					}
				});
				b.runningthread.start();
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

	}

	public void doInitBoard(StaticForageBoard b) {
		//
	}

	public void doInitBoard(MovingForageBoard b) {
		//
	}
}
