package gla.joose.birdsim.boards;

import behaviours.UpdateStockBehaviour;

public class ForageUpdate implements UpdateStockBehaviour{
	public void doUpdateStock(final StaticForageBoard b){
		b.updateStock();
		b.noOfBirdsLabel.setText("#birds: "+b.noofbirds);
		b.noOfGrainsLabel.setText("#grains: "+b.noofgrains);
	}
	
	public void doUpdateStock(final MovingForageBoard b){
		b.updateStock();
		b.noOfBirdsLabel.setText("#birds: "+b.noofbirds);
		b.noOfGrainsLabel.setText("#grains: "+b.noofgrains);
	}

	public void doUpdateStock(FlockBoard b) {
		// TODO Auto-generated method stub
		
	}
}
