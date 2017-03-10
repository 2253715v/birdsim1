package gla.joose.birdsim.boards;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import behaviours.InitBehaviour;

public class FlockInit implements InitBehaviour {
	public void doInitBoard(final JFrame frame, final Board b) {
		if (b.getClass() == FlockBoard.class) {
			
			final FlockBoard fb = (FlockBoard) b;
			
			JPanel display = fb.getJPanel();
			frame.getContentPane().add(display, BorderLayout.CENTER);

			// Install button panel
			fb.buttonPanel = new JPanel();
			frame.getContentPane().add(fb.buttonPanel, BorderLayout.SOUTH);
			
			

			fb.hatchEggButton = new JButton("hatch egg");
			fb.buttonPanel.add(fb.hatchEggButton);
			fb.hatchEggButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					fb.scareBirds = false;
					fb.runningthread = new Thread(new Runnable() {
						public void run() {
							fb.performFly();
						}
					});
					fb.runningthread.start();
				}
			});
			fb.scareBirdsButton = new JButton("scare birds");
			fb.buttonPanel.add(fb.scareBirdsButton);
			fb.scareBirdsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fb.scareBirds = true;
				}
			});

			fb.noOfBirdsLabel = new JLabel();
			fb.noOfBirdsLabel.setText("#birds: " + 0);
			fb.buttonPanel.add(fb.noOfBirdsLabel);

			// Implement window close box
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// used to invoke birds removal from the board
					fb.scareBirds = true;
					if (fb.runningthread != null) {
						fb.clear();
						try {
							fb.runningthread.join();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					frame.dispose();
					System.exit(0);
				}
			});
			frame.pack();
			frame.setSize(650, 650);
			frame.setVisible(true);

		}
	}

}
