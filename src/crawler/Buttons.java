package crawler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Buttons implements ActionListener{
	
	private JButton[] directionButtons;  //for direction arrows
	private JLayeredPane layers;  //the layers from the display class
	private Display display;  //the entire display class
	private Battles battles;
	private JButton[] buttonGold;  //all the gold buttons
	private JButton[] buttonPotion;  //all the potion buttons
	private JButton buttonSword;  //sword button
	private JButton buttonShield;  //shield button
	private JButton buttonBackpack;  //bag button
	private JButton buttonKey;  //key button
	private JButton buttonShoes;  //shoes button
	private JButton[] inventoryButtons;  //all the inventory buttons
	private JButton[] characters;  //the 3 characters you can interact with
	private JButton[] yesNoButtons;  //the yes and no buttons for the Game Over screen. 0 = yes, 1 = no
	
	
	public Buttons(JLayeredPane layers, Display display) {
		this.directionButtons = new JButton[4];
		this.display = display;
		this.layers = layers;
		this.battles = new Battles(display, this);
		this.buttonGold = new JButton[7];
		this.buttonPotion = new JButton[4];
		this.buttonSword = new JButton();
		this.buttonShield = new JButton();
		this.buttonBackpack = new JButton();
		this.buttonKey = new JButton();
		this.inventoryButtons = new JButton[5];
		this.characters = new JButton[3];
		buildYesNoButtons();
	}
	
	
	public JButton[] buildDirectionButtons(JLayeredPane layers, Display display) {
		
		
		/*
		 * buttons[0] = left
		 * buttons[1] = up
		 * buttons[2] = right
		 * buttons[3] = down
		 */
		
		for (int i = 0; i < 4; i++) {
			directionButtons[i] = new JButton();
			directionButtons[i].addActionListener(this); //Makes this class the listener (See actionPerformed below)
			directionButtons[i].setBackground(new Color(0, 0, 0, 0));  //make background clear
			directionButtons[i].setBorderPainted(false);  //erase border
			layers.add(directionButtons[i], Integer.valueOf(100));
		}
		
		directionButtons[0].setIcon(AllImages.getItemImage(14));
		directionButtons[1].setIcon(AllImages.getItemImage(15));
		directionButtons[2].setIcon(AllImages.getItemImage(16));
		directionButtons[3].setIcon(AllImages.getItemImage(17));
		
		directionButtons[0].setBounds(50, display.ROOM_HEIGHT / 2 - 25, 50, 50);
		directionButtons[1].setBounds(display.ROOM_WIDTH / 2 - 25, 50, 50, 50);
		directionButtons[2].setBounds(display.ROOM_WIDTH - 100, display.ROOM_HEIGHT / 2 - 25, 50, 50);
		directionButtons[3].setBounds(display.ROOM_WIDTH / 2 - 25, display.ROOM_HEIGHT - 100, 50, 50);
		
		return directionButtons;
	}
	
	
	public void setDirectionButtonVisibility(Room[] rooms, int roomNumber) {
		/*
		 * If the room directions has "left" the 
		 * left arrow button will be visible
		 * otherwise it won't
		 * 
		 * Same for the other 3 buttons
		 */
		directionButtons[0].setVisible(rooms[roomNumber].hasDirection("left"));
		directionButtons[1].setVisible(rooms[roomNumber].hasDirection("up"));
		directionButtons[2].setVisible(rooms[roomNumber].hasDirection("right"));
		directionButtons[3].setVisible(rooms[roomNumber].hasDirection("down"));
	}

	
	public JButton buildInventoryButton(final JFrame frame, final Item item, final int itemType) {
		/* Item Type key:  It corresponds with it's image number
		 * 4 = sword
		 * 6 = shield
		 * 8 = backpack
		 * 10 = key
		 * 12 = shoes
		 */
		
		//get correct button index
		int index = 0;
		if (inventoryButtons[0] == null) { index = 0; }
		else if (inventoryButtons[1] == null) { index = 1; } 
		else if (inventoryButtons[2] == null) { index = 2; }
		else if (inventoryButtons[3] == null) { index = 3; }
		else { index = 4;}
		
		inventoryButtons[index] = new JButton();
		ItemInformation.setItemButtonBounds(inventoryButtons[index], index + 16, display);
		//inventoryButtons[index].setVisible(false);
		layers.add(inventoryButtons[index], Integer.valueOf(80));
		
		//get correct button image
		inventoryButtons[index].setIcon(AllImages.getItemImage(itemType));
		inventoryButtons[index].setVisible(true);
		
		//add action event
		final String message;
		if (itemType == 4) {
			//sword
			message  = "This sword's a bit rusty,\n" +
					   "but it'll get the job done!";
		} 
		else if (itemType == 6) {
			//shield
			message  = "A simple wooden shield.\n" +
					   "It's better than nothing.";
		}
		else if (itemType == 8) {
			//backpack
			message  = "They stole your life!\n" +
					   "Now you can make off\n" + 
					   "with their gold!";
		}
		else if (itemType == 10) {
			//key
			message  = "A simple guard's key.";
		}
		else {
			//shoes
			message  = "A bit worn, but they should\n"+
					   "help you sneak about.";
		}
		inventoryButtons[index].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, 
											  message, 
											  item.getName() + " Details",
											  JOptionPane.PLAIN_MESSAGE,
											  AllImages.getItemImage(itemType));
			}
		});
		
		
		return inventoryButtons[index];
		
	}
	
	
	public JButton buildItemButon(int itemNumber) {
		
		switch (itemNumber) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			//the gold
			buttonGold[itemNumber] = new JButton();
			buttonGold[itemNumber].addActionListener(this);
			buttonGold[itemNumber].setIcon(AllImages.getItemImage(1));
			ItemInformation.setItemButtonBounds(buttonGold[itemNumber], itemNumber, display);
			buttonGold[itemNumber].setVisible(false);
			buttonGold[itemNumber].setBackground(new Color(0,0,0,0)); //transparent background
			buttonGold[itemNumber].setBorderPainted(false);  //erase border
			layers.add(buttonGold[itemNumber], Integer.valueOf(80));
			return buttonGold[itemNumber];
		case 7:
		case 8:
		case 9:
		case 10:
			//the potion
			buttonPotion[itemNumber - 7] = new JButton();
			buttonPotion[itemNumber - 7].addActionListener(this);
			buttonPotion[itemNumber - 7].setIcon(AllImages.getItemImage(3));
			ItemInformation.setItemButtonBounds(buttonPotion[itemNumber - 7], itemNumber, display);
			buttonPotion[itemNumber - 7].setVisible(false);
			buttonPotion[itemNumber - 7].setBackground(new Color(0,0,0,0)); //transparent background
			buttonPotion[itemNumber - 7].setBorderPainted(false);  //erase border
			layers.add(buttonPotion[itemNumber - 7], Integer.valueOf(80));
			return buttonPotion[itemNumber - 7];
		case 11:
			//the sword
			buttonSword = new JButton();
			buttonSword.addActionListener(this);
			buttonSword.setIcon(AllImages.getItemImage(5));
			ItemInformation.setItemButtonBounds(buttonSword, itemNumber, display);
			buttonSword.setVisible(false);
			buttonSword.setBackground(new Color(0,0,0,0)); //transparent background
			buttonSword.setBorderPainted(false);  //erase border
			layers.add(buttonSword, Integer.valueOf(80));
			return buttonSword;
		case 12:
			//the shield
			buttonShield = new JButton();
			buttonShield.addActionListener(this);
			buttonShield.setIcon(AllImages.getItemImage(7));
			ItemInformation.setItemButtonBounds(buttonShield, itemNumber, display);
			buttonShield.setVisible(false);
			buttonShield.setBackground(new Color(0,0,0,0)); //transparent background
			buttonShield.setBorderPainted(false);  //erase border
			layers.add(buttonShield, Integer.valueOf(80));
			return buttonShield;
		case 13:
			//the backpack
			buttonBackpack = new JButton();
			buttonBackpack.addActionListener(this);
			buttonBackpack.setIcon(AllImages.getItemImage(9));
			ItemInformation.setItemButtonBounds(buttonBackpack, itemNumber, display);
			buttonBackpack.setVisible(false);
			buttonBackpack.setBackground(new Color(0,0,0,0)); //transparent background
			buttonBackpack.setBorderPainted(false);  //erase border
			layers.add(buttonBackpack, Integer.valueOf(80));
			return buttonBackpack;
		case 14:
			//the key
			buttonKey = new JButton();
			buttonKey.addActionListener(this);
			buttonKey.setIcon(AllImages.getItemImage(11));
			ItemInformation.setItemButtonBounds(buttonKey, itemNumber, display);
			buttonKey.setVisible(false);
			buttonKey.setBackground(new Color(0,0,0,0)); //transparent background
			buttonKey.setBorderPainted(false);  //erase border
			layers.add(buttonKey, Integer.valueOf(80));
			return buttonKey;
		case 15:
			//the shoes
			buttonShoes = new JButton();
			buttonShoes.addActionListener(this);
			buttonShoes.setIcon(AllImages.getItemImage(13));
			ItemInformation.setItemButtonBounds(buttonShoes, itemNumber, display);
			buttonShoes.setVisible(false);
			buttonShoes.setBackground(new Color(0,0,0,0)); //transparent background
			buttonShoes.setBorderPainted(false);  //erase border
			layers.add(buttonShoes, Integer.valueOf(80));
			return buttonShoes;
		default:
			//for if you sent a number not in the list
			return null;
			
		}
	}
	
	
	public JButton buildCharacters(int characterNumber) {
		characters[characterNumber] = new JButton();
		characters[characterNumber].addActionListener(this);
		characters[characterNumber].setIcon(AllImages.getCharacterImage(characterNumber));
		ItemInformation.setItemButtonBounds(characters[characterNumber], characterNumber + 21, display);
		characters[characterNumber].setVisible(false);
		characters[characterNumber].setBackground(new Color(0,0,0,0)); //transparent background
		characters[characterNumber].setBorderPainted(false);  //erase border
		if (characterNumber == 1) {
			layers.add(characters[characterNumber], Integer.valueOf(70));  //dragon is on different layer
		}
		else {
			layers.add(characters[characterNumber], Integer.valueOf(90));  //others on this layers
		}
		return characters[characterNumber];
	}
	
	
	public void buildYesNoButtons() {
		//build the array
		yesNoButtons = new JButton[2];
		
		//build each button
		for (int i = 0; i < 2; i++) {
			yesNoButtons[i] = new JButton();
			yesNoButtons[i].setIcon(AllImages.getItemImage(i + 18));
			yesNoButtons[i].addActionListener(this);
			yesNoButtons[i].setBackground(new Color(0,0,0,0)); //transparent background
			yesNoButtons[i].setBorderPainted(false);  //erase border
			yesNoButtons[i].setVisible(true);
			yesNoButtons[i].setBounds(739 + i * 173, 512, 127, 44); //the second one moves over 173px
		}
		
		
	}
	
	
	public JButton[] getYesNoButtons() {
		return yesNoButtons;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * Check for the source of the event
		 * Which button variable was pressed?
		 */
		
		if (e.getSource() == directionButtons[0]) {
			//button left
			display.switchRooms(0);
		}
		else if (e.getSource() == directionButtons[1]) {
			//button up
			display.switchRooms(1);
		}
		else if (e.getSource() == directionButtons[2]) {
			//button right
			display.switchRooms(2);
		}
		else if (e.getSource() == directionButtons[3]) {
			//button down
			display.switchRooms(3);
		}
		else if (e.getSource() == buttonGold[0]) {
			//button gold 0
			aquiredGoldMessage(0);
			if (display.getPlayer().getHasBackpack()) {
				display.goldButtonPressed(display.getItem(0));
				((JButton) e.getSource()).setVisible(false);
			}
		} else if (e.getSource() == buttonGold[1]) {
			// button gold 1
			aquiredGoldMessage(1);
			if (display.getPlayer().getHasBackpack()) {
				display.goldButtonPressed(display.getItem(1));
				((JButton) e.getSource()).setVisible(false);
			}
		} else if (e.getSource() == buttonGold[2]) {
			// button gold 2
			aquiredGoldMessage(2);
			if (display.getPlayer().getHasBackpack()) {
				display.goldButtonPressed(display.getItem(2));
				((JButton) e.getSource()).setVisible(false);
			}
		} else if (e.getSource() == buttonGold[3]) {
			// button gold 3
			aquiredGoldMessage(3);
			if (display.getPlayer().getHasBackpack()) {
				display.goldButtonPressed(display.getItem(3));
				((JButton) e.getSource()).setVisible(false);
			}
		} else if (e.getSource() == buttonGold[4]) {
			// button gold 4
			aquiredGoldMessage(4);
			if (display.getPlayer().getHasBackpack()) {
				display.goldButtonPressed(display.getItem(4));
				((JButton) e.getSource()).setVisible(false);
			}
		} else if (e.getSource() == buttonGold[5]) {
			// button gold 5
			aquiredGoldMessage(5);
			if (display.getPlayer().getHasBackpack()) {
				display.goldButtonPressed(display.getItem(5));
				((JButton) e.getSource()).setVisible(false);
			}
		} else if (e.getSource() == buttonGold[6]) {
			// button gold 6
			aquiredGoldMessage(6);
			if (display.getPlayer().getHasBackpack()) {
				display.goldButtonPressed(display.getItem(6));
				((JButton) e.getSource()).setVisible(false);
			}
		}
		else if (e.getSource() == buttonPotion[0]) {
			//button potion 0
			aquiredPotionMessage(display.getItem(7).getPower());
			display.potionButtonPressed(display.getItem(7));
			((JButton) e.getSource()).setVisible(false);
		}
		else if (e.getSource() == buttonPotion[1]) {
			//button potion 1
			aquiredPotionMessage(display.getItem(8).getPower());
			display.potionButtonPressed(display.getItem(8));
			((JButton) e.getSource()).setVisible(false);
		}
		else if (e.getSource() == buttonPotion[2]) {
			//button potion 2
			aquiredPotionMessage(display.getItem(9).getPower());
			display.potionButtonPressed(display.getItem(9));
			((JButton) e.getSource()).setVisible(false);
		}
		else if (e.getSource() == buttonPotion[3]) {
			//button potion 3
			aquiredPotionMessage(display.getItem(10).getPower());
			display.potionButtonPressed(display.getItem(10));
			((JButton) e.getSource()).setVisible(false);
		}
		else if (e.getSource() == buttonSword) {
			//button sword
			aquiredItemMessage(11, 4);
			display.getPlayer().aquireSword();  		//set has Sword to true
			display.pickupItem(display.getItem(11), 4);
			((JButton) e.getSource()).setVisible(false);
		}
		else if (e.getSource() == buttonShield) {
			//button shield
			aquiredItemMessage(12, 6);
			display.getPlayer().aquireShield();  		//set has Shield to true
			display.pickupItem(display.getItem(12), 6);
			((JButton) e.getSource()).setVisible(false);
		}
		else if (e.getSource() == buttonBackpack) {
			//button backpack
			aquiredItemMessage(13, 8);
			display.getPlayer().aquireBackpack();  		//set has backpack to true
			display.pickupItem(display.getItem(13), 8);
			((JButton) e.getSource()).setVisible(false);
		}
		else if (e.getSource() == buttonKey) {
			//button key
			aquiredItemMessage(14, 10);
			display.getPlayer().aquireKey();  		//set has key to true
			display.pickupItem(display.getItem(14), 10);
			((JButton) e.getSource()).setVisible(false);
		}
		else if (e.getSource() == buttonShoes) {
			//button shoes
			aquiredItemMessage(15, 12);
			display.getPlayer().aquireShoes();  		//set has key to true
			display.pickupItem(display.getItem(15), 12);
			((JButton) e.getSource()).setVisible(false);
		} 
		else if (e.getSource() == characters[0]) {
			//ogre
			battles.ogreBattle();
		} 
		else if (e.getSource() == characters[1]) {
			//dragon
			displayMessage("Death!", 
						   "You've awoken the sleeping dragon!", 
						   20);
			display.gameOver();
		} 
		else if (e.getSource() == characters[2]) {
			//spider
			battles.spiderBattle();
		}
		else if (e.getSource() == yesNoButtons[0]) {
			//game over yes button
			display.resetGame();
		}
		else if (e.getSource() == yesNoButtons[1]) {
			//game over no button
			//say goodbye
			displayMessage("Exit", "Better luck next time!", -1);
			
			//close the program
			display.getFrame().dispose();
			display.getFrame().setVisible(false);
			System.exit(0);
		}
	}

	
	private void aquiredGoldMessage(int itemNumber) {
		//make sure they have a backpack
		if (display.getPlayer().getHasBackpack()) {
			//display message
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
										  "You've collected " + display.getItem(itemNumber).getPower() + " gold!" + 
										  "</p></html>");
		}
		else {
			//display message 
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
										  "You have nothing to carry this gold with.<br /><br />What a shame!" + 
										  "</p></html>");
		}
		
		
		
	}

	
	private void aquiredPotionMessage(final int ammount) {
		//display message 
		display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
									  "You have increased your health by " +
									  ammount + "<br /><br />" +
									  "Odds are you'll need it to escape." + 
									  "</p></html>");
	}
	
	
	private void aquiredItemMessage(int itemNumber, int imageNumber) {
		// create message
		String message = "You have found a " + ItemInformation.getName(itemNumber) + "!";
		String paneTitle = "Aquired " + ItemInformation.getName(itemNumber) + "!";

		// display message
		displayMessage(paneTitle, message, imageNumber);
	}
	
	
	/*
	 * Display's a pop-up message with whatever title and message is sent
	 * 
	 * if imageNumber == -1, there is no image displayed on the pop-up
	 */
	public void displayMessage(String title, String message, int imageNumber) {
		if (imageNumber == -1) {  //no image needed
			JOptionPane.showMessageDialog(display.getFrame(), 
				  				 	  	  message, 
				  				 	 	  title,
				  				 	 	  JOptionPane.PLAIN_MESSAGE);
		}
		else {  //prints with image
			JOptionPane.showMessageDialog(display.getFrame(), 
										  message, 
										  title,
										  JOptionPane.PLAIN_MESSAGE,
										  AllImages.getItemImage(imageNumber));
		}
	}
	
}
