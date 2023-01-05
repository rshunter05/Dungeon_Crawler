package crawler;

public class Battles {
	
	private int numSpiderHits;  //the number of times the spider has been hit
	private Display display;  //the entire display object
	private Buttons buttons;  //the entire button object
	
	
	public Battles(Display display, Buttons buttons) {
		numSpiderHits = 0;
		this.display = display;
		this.buttons = buttons;
		
	}
	
	public void ogreBattle() {
		/*
		 * The logic for the Ogre battle
		 */

		
		
		if (!display.getPlayer().getHasSword()) { // if they don't have a sword

			// if they also don't have a shield
			if (!display.getPlayer().getHasShield()) {
				buttons.displayMessage("Death!", 
									   "Are you serious!\n" + 
											   "Look at tha club!!!!\n" + 
											   "You must've had a death wish", 
									   20);
				display.gameOver();
				return;
			}
		
			//if they only have a shield.  Attack failed and shield is broken.
			display.getPlayer().breakShield();
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
					"You just rammed that guy with your shield.<br /><br />" + 
					"But he smashed it with his club!<br /><br />" + 
					"You might want to run while you still can..." + 
					"</p></html>");
			
			//reset shield label so it can be picked up again
			display.getItem(12).togglePickedUp();
			display.getItem(12).getButton().setVisible(true);
			
			return;
			
			
			
		}

		//Ogre doesn't want to fight
		display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
				"So, it turns out that ogre is all show and no bite.<br /><br />" + 
				"You waved your sword and shield around and he just let you by.<br /><br />" + 
				"Maybe his boss isn’t paying him enough?" + 
				"</p></html>");
		display.getCharacter(0).setDead();
		
		
		
		
	}
	
	public void spiderBattle() {
		
		/*
		 * The logic for the spider battle
		 */
		
		
		if (!display.getPlayer().getHasSword()) {  //if they don't have a sword
			
			//if they also don't have a shield
			if (!display.getPlayer().getHasShield()) { 
				
				buttons.displayMessage("Death!", 
						 				"You really tried to fight that thing!\n" +
						 				"with your bare hands!\n" +
						 				"It's amazing you lived this long", 
						 				20);
				display.gameOver();
				return;
			}
			
			
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
					"You're never gunna beat that thing with just a shield.<br /><br />" +
					"Maybe there's something lying around somewhere." +
					"</p></html>");
			
			
			return;
		}
		
		numSpiderHits++;
		
		switch (numSpiderHits) {
		case 1:
			//get 1 hit image
			display.getCharacter(2).getButton().setIcon(AllImages.getCharacterImage(3));
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
					"Good Hit!<br /><br />" +
					"You got 2 of its legs!" +
					"</p></html>");
			
			break;
		case 2:
			//spider gets a hit in
			
			//check for shield
			if (display.getPlayer().getHasShield()) {
				display.getPlayer().addHealth(-8);
			}
			else {
				display.getPlayer().addHealth(-12);  //greater damage if there's no shield
			}
			
			if (!display.getPlayer().getIsAlive()) {  //check if they're dead
				buttons.displayMessage("Death!", 
									   "The spider got the best of you!\n" + 
											   "R.I.P.", 
									   20);
				display.gameOver();
				return;

			}
			
			break;
		case 3:
			//get 2 hit image
			display.getCharacter(2).getButton().setIcon(AllImages.getCharacterImage(4));
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
					"You've got it on the ropes!<br /><br />" +
					"Stay strong and finish it!" +
					"</p></html>");
			
			break;
		case 4:
			//get dead spider image
			display.getCharacter(2).getButton().setIcon(AllImages.getCharacterImage(5));
			display.getCharacter(2).setDead();
			
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
					"YES!!<br /><br />" +
					"That thing won't be messin with anyone ever again!!" +
					"</p></html>");
			
			break;
		case 5:
		case 6:
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
					"I think it's dead already.<br /><br />" +
					"But I don't blame you for making sure." +
					"</p></html>");
			break;
		case 7:
		case 8:
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
					"Ok...<br /><br />" +
					"This is officially overkill.<br /><br />" +
					"I think it's time to move on." +
					"</p></html>");
			break;
		default:
			display.getRoomText().setText("<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
					"You've got problems bro...<br /><br />" +
					"You might wanna see someone about that..." +
					"</p></html>");
			
				
		}
		
	}
	
}
