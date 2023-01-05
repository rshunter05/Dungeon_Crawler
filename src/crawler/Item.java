package crawler;

import javax.swing.JButton;

public class Item {
	
	private String name;
	private int power;
	private JButton button;
	private boolean isPickedUp;
	
	
	//constructor
	public Item(int itemNumber, JButton button){
		//get this item's info from the info classes
		name = ItemInformation.getName(itemNumber);
		power = ItemInformation.getPower(itemNumber);
		this.button = button;
		isPickedUp = false; //I'm assuming it starts off NOT broken
		
	}
	
	/*
	 * MUTATOR METHODS 
	 * These would edit (mutate) the private variables above
	 */
	//this will toggle the isBroken between true and false 
	public void togglePickedUp() {
		isPickedUp = !isPickedUp;
	}
	
	
	/*
	 * getter methods
	 */
	public String getName() {
		return name;
	}
	public boolean getIsPickedUp() {
		return isPickedUp;
	}
	public JButton getButton() {
		return button;
	}
	public int getPower() {
		return power;
	}
	
	
}
