package crawler;

import javax.swing.JButton;

public class Character {

	private String name;
	private JButton button;
	private boolean isAlive;  //true if they're alive or if dragon is asleep
	
	public Character(int characterNumber, JButton button) {
		
		name = ItemInformation.getCharacterName(characterNumber);
		this.button = button;
		isAlive = true; //
		
	}
	
	//sets the character to dead (for the dragon it would be awake)
	public void setDead() {
		isAlive = false;
	}
	
	
	public boolean getIsAlive() {
		return isAlive;
	}
	public JButton getButton() {
		return button;
	}
	public String getName() {
		return name;
	}
	
	
	
	
}
