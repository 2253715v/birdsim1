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
import gla.joose.birdsim.pieces.Grain;
import gla.joose.birdsim.pieces.PaintGrain;

public class ForageInit implements InitBehaviour {

	public void doInitBoard(final JFrame frame, final Board b) {
		if (b.getClass() == StaticForageBoard.class) {
			final StaticForageBoard sb = (StaticForageBoard) b;

			JPanel display = sb.getJPanel();
			frame.getContentPane().add(display, BorderLayout.CENTER);

			// Install button panel
			sb.buttonPanel = new JPanel();
			frame.getContentPane().add(sb.buttonPanel, BorderLayout.SOUTH);

			sb.hatchEggButton = new JButton("hatch egg");
			sb.buttonPanel.add(sb.hatchEggButton);
			sb.hatchEggButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sb.scareBirds = false;
					sb.runningthread = new Thread(new Runnable() {
						public void run() {
							sb.performFly();
						}
					});
					sb.runningthread.start();
				}
			});

			sb.feedBirdButton = new JButton("feed birds");
			sb.buttonPanel.add(sb.feedBirdButton);
			sb.feedBirdButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sb.starveBirdspressed = false;

					Grain grain = new Grain();
					grain.setPaintBehaviour(new PaintGrain());
					int randRow = sb.rand.nextInt((sb.getRows() - 3) + 1) + 0;
					int randCol = sb.rand.nextInt((sb.getColumns() - 3) + 1) + 0;
					sb.place(grain, randRow, randCol);
					grain.setDraggable(false);

					sb.doUpdateStock((StaticForageBoard) sb);
				}
			});

			sb.starveBirdsButton = new JButton("starve birds");
			sb.buttonPanel.add(sb.starveBirdsButton);
			sb.starveBirdsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sb.starveBirdspressed = true;

				}
			});

			sb.scareBirdsButton = new JButton("scare birds");
			sb.buttonPanel.add(sb.scareBirdsButton);
			sb.scareBirdsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sb.scareBirds = true;

				}
			});
			sb.noOfBirdsLabel = new JLabel();
			sb.noOfBirdsLabel.setText("#birds: " + 0);
			sb.buttonPanel.add(sb.noOfBirdsLabel);

			sb.noOfGrainsLabel = new JLabel();
			sb.noOfGrainsLabel.setText("#grains: " + 0);
			sb.buttonPanel.add(sb.noOfGrainsLabel);

			// Implement window close box
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					sb.scareBirds = true;
					if (sb.runningthread != null) {
						sb.clear();
						try {
							sb.runningthread.join();
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

		} else if (b.getClass() == MovingForageBoard.class) {
			final MovingForageBoard mb = (MovingForageBoard) b;

			JPanel display = mb.getJPanel();
			frame.getContentPane().add(display, BorderLayout.CENTER);

			// Install button panel
			mb.buttonPanel = new JPanel();
			frame.getContentPane().add(mb.buttonPanel, BorderLayout.SOUTH);

			mb.hatchEggButton = new JButton("hatch egg");
			mb.buttonPanel.add(mb.hatchEggButton);
			mb.hatchEggButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mb.scareBirds = false;
					mb.runningthread = new Thread(new Runnable() {
						public void run() {
							mb.performFly();
						}
					});
					mb.runningthread.start();
				}
			});

			mb.feedBirdButton = new JButton("feed birds");
			mb.buttonPanel.add(mb.feedBirdButton);
			mb.feedBirdButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mb.starveBirds = false;

					Grain grain = new Grain();
					grain.setPaintBehaviour(new PaintGrain());
					int randRow = mb.rand.nextInt((mb.getRows() - 3) + 1) + 0;
					int randCol = mb.rand.nextInt((mb.getColumns() - 3) + 1) + 0;
					mb.place(grain, randRow, randCol);
					grain.setDraggable(false);

					mb.doUpdateStock((MovingForageBoard) mb);
				}
			});

			mb.starveBirdsButton = new JButton("starve birds");
			mb.buttonPanel.add(mb.starveBirdsButton);
			mb.starveBirdsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mb.starveBirds = true;

				}
			});

			mb.scareBirdsButton = new JButton("scare birds");
			mb.buttonPanel.add(mb.scareBirdsButton);
			mb.scareBirdsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mb.scareBirds = true;

				}
			});
			mb.noOfBirdsLabel = new JLabel();
			mb.noOfBirdsLabel.setText("#birds: " + 0);
			mb.buttonPanel.add(mb.noOfBirdsLabel);

			mb.noOfGrainsLabel = new JLabel();
			mb.noOfGrainsLabel.setText("#grains: " + 0);
			mb.buttonPanel.add(mb.noOfGrainsLabel);

			// Implement window close box
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					mb.scareBirds = true;
					if (mb.runningthread != null) {
						mb.clear();
						try {
							mb.runningthread.join();
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
