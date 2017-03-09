package gla.joose.birdsim.boards;

public class FlockUpdate {
	public void doUpdateStock(FlockBoard b) {
		b.updateStock();
		b.noOfBirdsLabel.setText("#birds: " + b.noofbirds);
	}
}
