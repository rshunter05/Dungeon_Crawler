package crawler;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Display {

	/*
	 * Constants used to help with the placement of items
	 * Anything declared as "final" CAN NOT be changed elsewhere
	 */
	public final int MENU_BAR_HEIGHT = 27;
	public final int WIDTH = 1400; //width of frame
	public final int HEIGHT = WIDTH * 9 / 16 + MENU_BAR_HEIGHT; //height of frame based on width to keep widescreen 16:9 aspect ratio
	public final int ROOM_HEIGHT = HEIGHT - MENU_BAR_HEIGHT; //height of the room image
	public final int ROOM_WIDTH = ROOM_HEIGHT * 4 / 3; //width of the room image based on standard aspect ratio 4:3
	public final int DATA_IMAGE_WIDTH = WIDTH - ROOM_WIDTH;  //width of the data image. remainder of window to the right
	public final String ROOM_TEXT_COLOR = "\"color:rgb(168, 252, 255);\"";
	public final String STATS_TEXT_COLOR = "color = 'yellow'";
	
	
	private Player player;
	
	private JFrame frame;  //the main frame
	private JLayeredPane layers;  //keeps track of layers
	
	private Item[] items; //stores all the items
	private Room[] rooms; //stores all the room objects
	private Character[] characters;
	private int roomNumber; //keeps track of the room number
	private Buttons buttonHandler;  //object that handles all the buttons
	
	//image labels
	private JLabel roomBackgroundLabel;
	private JLabel dataBackgroundLabel;
	
	
	//text labels
	private JLabel roomText;
	private JLabel healthText;
	private JLabel goldText;
	
	//labels available for use whenever needed
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	//buttons for items and characters
	private JButton[] itemButtons;
	private JButton characterButton;
	
	/*
	 * constructor
	 */
	public Display() {
		
		/*
		 * JFrame
		 * This is the base frame that everything is on
		 * It's got the 3 little buttons on the corner and everything else
		 */
		frame = new JFrame("Dungeon Crawler");  //feel free to change the name
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setBackground(new Color(96, 56, 19)); //change background color (RGB)
		
		//build EVERYTHING that's goes on the frame
		buildFrameItems();
		
		//set the frame's layout to null (no preset layout)
		frame.setLayout(null);
		//set the frame to visible
		frame.setVisible(true);
		
	}
	
	/*
	 * Builds everything in the main frame
	 * 
	 * This is called at the beginning of the game
	 * 
	 * It's also called to rebuild the game if the 
	 * player died and wants to try again
	 */
	public void buildFrameItems() {
		
		//create the player
		this.player = new Player();
		
		
		/*
		 * Layered Pane allows us to change what layer a specific item is on
		 * basically its z-value
		 * 
		 * This will be helpful if you need to move something in front/behind
		 * something else later
		 */
		layers = new JLayeredPane();
		layers.setBounds(0,0, WIDTH, HEIGHT);
		
		
		
		/*
		 * METHODS FOR BUILDING INDIVIDUAL DISPLAY PIECES
		 * 
		 */
		//build the buttons
		this.rooms = buildRooms();  //creates all the rooms
		
		buttonHandler = new Buttons(layers, this); //this refers to this entire class.  This way the method has access to all public variables and methods
		buttonHandler.buildDirectionButtons(layers, this);  //this refers to this entire class.  This way the method has access to all public variables
		buttonHandler.setDirectionButtonVisibility(rooms, roomNumber);  //set the correct buttons to visible
		
		buildBackgroundImages(); //sets the initial background images
		
		buildFred();
		
		buildLabels(); //builds all labels that are visible for each room
		
		buildAvailableLabels();  //builds the labels that will be there for some of the rooms
		
		buildItemButtons();  //creates the buttons that will be used at different times during the game 
		
		this.items = buildItems();  //creates all the items
		
		this.characters = buildCharacters();  //creates all the characters
		
		//add layers to the frame (see buildGUI for what layers is)
		frame.add(layers);
	}
	
	
	
	private void buildBackgroundImages() {
		/*
		 * Adding images
		 * - get the image
		 * - resize the image
		 * - put them in labels (new JLabel)
		 * - place the label (setBounds)
		 * - add label to layers
		 */
		
		//get images from res folder
		ImageIcon roomImage = rooms[roomNumber].getRoomBackgroundImage(); //gets it from room array
		ImageIcon dataImage = new ImageIcon("res/rooms/Menu.png"); //gets it directly from file
		/*
		 * Resize image to your specified dimensions
		 * Note: The program will run faster if images 
		 * were already the desired size (no resizing needed).
		 */
		//roomImage = new ImageIcon(roomImage.getImage().getScaledInstance(ROOM_WIDTH, ROOM_HEIGHT, java.awt.Image.SCALE_SMOOTH));
		dataImage = new ImageIcon(dataImage.getImage().getScaledInstance(DATA_IMAGE_WIDTH, ROOM_HEIGHT, java.awt.Image.SCALE_SMOOTH));
		//put images in labels
		roomBackgroundLabel = new JLabel(roomImage);
		dataBackgroundLabel = new JLabel(dataImage);
		//place the label
		roomBackgroundLabel.setBounds(0, 0, ROOM_WIDTH, ROOM_HEIGHT); //x, y, width, height
		dataBackgroundLabel.setBounds(ROOM_WIDTH, 35, DATA_IMAGE_WIDTH, ROOM_HEIGHT); //x, y, width, height
		//place label on the frame
		layers.add(roomBackgroundLabel, Integer.valueOf(2)); //item to add, z-value
		layers.add(dataBackgroundLabel, Integer.valueOf(2)); //item to add, z-value
		
	}
	
	private void buildFred() {
		layers.add(player.getFred(), Integer.valueOf(100));
		player.moveFred(200, 300);
	}
	
	/*
	 * This builds all the labels that will be used for each room
	 */
	private void buildLabels(){
		
		/*
		 * Adding new Labels with text from the array of rooms
		 * - get the text
		 * - create the label
		 * - change it's attributes (font, size, whatever...)
		 * - give it bounds
		 * - attach it to layers
		 */
		//for the main title
		String text = rooms[roomNumber].getRoomText(); //get the title from the rooms array
		roomText = new JLabel("<html><p style=" + ROOM_TEXT_COLOR + ">" + text + "</p></html>");  //create label
		
		//for the health text
		text = String.format("Health = %4d", player.getHealth());
		healthText = new JLabel("<html><font "+ STATS_TEXT_COLOR + ">" + text + "</font></html>");
		//for the gold text
		text = String.format("Gold =  %7d", player.getGold());
		goldText = new JLabel("<html><font "+ STATS_TEXT_COLOR + ">" + text + "</font></html>");
		
		//set the fonts
		//list of all fonts https://alvinalexander.com/blog/post/jfc-swing/swing-faq-list-fonts-current-platform/
		roomText.setFont(new Font("Rockwell", Font.PLAIN, 20));//font, style, size
		healthText.setFont(new Font("Arial", Font.BOLD, 40));
		goldText.setFont(new Font("Arial", Font.BOLD, 40));

		// give them bounds
		roomText.setBounds(ROOM_WIDTH + 27, 20, DATA_IMAGE_WIDTH - 54, ROOM_HEIGHT - 400);
		healthText.setBounds(ROOM_WIDTH + 50, ROOM_HEIGHT - 223, DATA_IMAGE_WIDTH - 100, 100);
		goldText.setBounds(ROOM_WIDTH + 50, ROOM_HEIGHT - 183, DATA_IMAGE_WIDTH - 100, 100);

		// set justification
		//horizontal
		roomText.setHorizontalAlignment(JLabel.LEFT);
		healthText.setHorizontalAlignment(JLabel.LEFT);
		goldText.setHorizontalAlignment(JLabel.LEFT);
		//vertical
		roomText.setVerticalAlignment(JLabel.CENTER);
		healthText.setVerticalAlignment(JLabel.TOP);
		goldText.setVerticalAlignment(JLabel.TOP);
		
		//give the room text a background box
		roomText.setOpaque(true);
		roomText.setBackground(new Color(96, 56, 19, 255));
		//background box border
		Border border = BorderFactory.createLineBorder(new Color(117, 76, 36, 255), 10);
		JLabel roomTextBorder = new JLabel("");
		roomTextBorder.setOpaque(true);
		roomTextBorder.setBackground(new Color(96, 56, 19, 255));
		roomTextBorder.setBounds(ROOM_WIDTH + 10, 10, DATA_IMAGE_WIDTH - 20, ROOM_HEIGHT - 365);
		roomTextBorder.setBorder(border);
		
		
		
		
		//add labels to layers
		layers.add(roomText, Integer.valueOf(50));
		layers.add(healthText, Integer.valueOf(50));
		layers.add(goldText, Integer.valueOf(50));
		layers.add(roomTextBorder, Integer.valueOf(49));
	}
	
	private void buildAvailableLabels() {
		/*
		 * These labels will be used off and on as necessary.
		 * This just gets them ready, makes them invisible, and
		 * places them on the layer.
		 * 
		 * The picture, placement and visibility can be changed whenever necessary.
		 */
		label1 = new JLabel();
		label1.setVisible(false);
		layers.add(label1, Integer.valueOf(40));
		
		label2 = new JLabel();
		label2.setVisible(false);
		layers.add(label2, Integer.valueOf(41));
		
		label3 = new JLabel();
		label3.setVisible(false);
		layers.add(label3, Integer.valueOf(42));
	}
	
	private void buildItemButtons() {
		/*
		 * Builds the 3 item and 1 character buttons
		 * 
		 * They will be used to display any items the current
		 * room holds
		 * 
		 * they start off as hidden
		 */
		
		itemButtons = new JButton[3];
		for (int i = 0; i < itemButtons.length; i++) {
			itemButtons[i] = new JButton();
			itemButtons[i].setVisible(false);
			layers.add(itemButtons[i],Integer.valueOf(30));
		}
		
		characterButton = new JButton();
		characterButton.setVisible(false);
		layers.add(characterButton,Integer.valueOf(60));
	}
	
	/*
	 * This builds all the room objects necessary
	 * and puts them in an array or Room objects
	 */
	private Room[] buildRooms() {
		/*
		 * create an array of rooms
		 * this one has 4 elements
		 */
		Room[] rooms = new Room[16];
		
		/*
		 * creates the room objects
		 * loop 0 through however many you have.
		 */
		for (int i = 0; i < rooms.length; i++) {
			/* let's say i = 2
			 * 
			 * This creates a new Room(2) and stores 
			 * it in element 2 of rooms.
			 */
			rooms[i] = new Room(i);
		}
		
		return rooms;
	}
	
	/*
	 * This builds all the room objects necessary
	 * and puts them in an array or Room objects
	 * 
	 * It's essentially identical to creatRooms() above
	 */
	private Item[] buildItems() {
		/*
		 * create an array of items
		 * this one has 16 elements
		 */
		Item[] items = new Item[16];
		
		/*
		 * creates the item objects
		 */
		for (int i = 0; i < items.length; i++) {
			JButton button = buttonHandler.buildItemButon(i);
			items[i] = new Item(i, button);
		}
		
		return items;
	}
	
	private Character[] buildCharacters() {
		/*
		 * There are 3 characters
		 * 0 = Orc
		 * 1 = Dragon
		 * 2 = Spider
		 */
		Character[] characters = new Character[3];
		
		//create all character objects
		for (int i = 0; i < characters.length; i++) {
			JButton button = buttonHandler.buildCharacters(i);  //create their button
			characters[i] = new Character(i, button);  //create their object
		}
		
		
		return characters;
	}
	
	/*
	 * Facilitates switching the images, text and any other placement.
	 * 
	 * Parameter
	 *   int buttonPressed - Since there will probably 2+ ways to go, this 
	 *                       indicates which button was pressed
	 */
	public void switchRooms(int direction) {
		
		//check if you can enter that room
		if (!enterRoomCheck(rooms[roomNumber].getNextRoomNumber(direction))) {
			//stops all background changes if you can't switch rooms or you die.
			return;
		}
		
		/*
		 * Switch roomNumber according to the direction provided
		 */
		roomNumber = rooms[roomNumber].getNextRoomNumber(direction);
		
		// change background to new room
		roomBackgroundLabel.setIcon(rooms[roomNumber].getRoomBackgroundImage());

		// adjust direction button visibility
		buttonHandler.setDirectionButtonVisibility(rooms, roomNumber);

		// change text according to the new room's text
		roomText.setText("<html><p style=" + ROOM_TEXT_COLOR + ">" + rooms[roomNumber].getRoomText() + "</p></html>");
		
		
		//get the items in the room
		int[] itemList = rooms[roomNumber].getItemList();
		//ajust the itemButtons to stode the room's items
		for (int i = 0; i < itemButtons.length; i++) {
			itemButtons[i].setVisible(false);
			if (i < itemList.length && itemList[0] != -1) { //check if there's another item in the room
				if (!items[itemList[i]].getIsPickedUp()) { //check if that item's been picked up
					itemButtons[i] = items[itemList[i]].getButton();
					itemButtons[i].setVisible(true);
				}	
			}
		}
		
		//set the character's buttons visible if we're in their room
		characterButton.setVisible(false);  //make the button invisible
		
		int characterIndex = -1;
		//if we're in room 6, 10 or 13, get the correct index
		if (roomNumber == 6) {  //spider's room
			characterIndex = 2;
		}
		else if (roomNumber == 10) {  //dragon's room
			characterIndex = 1;
		}
		else if (roomNumber == 13) {  //orc's room
			characterIndex = 0;
		}
		
		if (characterIndex != -1 && characters[characterIndex].getIsAlive()) {
			//if we're in room, 6, 10 or 13 AND the character is still alive
			characterButton = characters[characterIndex].getButton();  //get that character's button
			characterButton.setVisible(true); //set that button to visible
		}
		
		
		
	}
	
	
	public Item getItem(int index) {
		return items[index];
	}
	
	
	public JFrame getFrame() {
		return frame;
	}
	
	
	public Player getPlayer() {
		return player;
	}
	
	
	public JLabel getRoomText() {
		return roomText;
	}
	
	
	public Character getCharacter(int index){
		return characters[index];
	}
	
	
	public void goldButtonPressed(Item gold) {
		if (!gold.getIsPickedUp()) {
			//edit player variables
			gold.togglePickedUp();
			player.addGold(gold.getPower());
			
			//edit display
			String text = String.format("Gold =  %7d", player.getGold());
			goldText.setText("<html><font "+ STATS_TEXT_COLOR + ">" + text + "</font></html>");
			
		}
	}
	
	
	public void potionButtonPressed(Item potion) {
		if (!potion.getIsPickedUp()) {
			//edit player variables
			potion.togglePickedUp();
			player.addHealth(potion.getPower());
			
			//edit display
			String text = String.format("Health = %4d", player.getHealth());
			healthText.setText("<html><font "+ STATS_TEXT_COLOR + ">" + text + "</font></html>");
			
		}
	}
	
	
	public void pickupItem(Item item, int type) {
		if (!item.getIsPickedUp()) {
			//make it false
			item.togglePickedUp();
			
			//create button
			JButton button = buttonHandler.buildInventoryButton(frame, item, type);
			//place button on layer
			layers.add(button, Integer.valueOf(80));
		}
	}


	public boolean enterRoomCheck(int roomNumber) {
		
		switch (roomNumber) {
		case 6:
			//spider room
			//TODO
			break;
		case 10:
			//dragon room
			//TODO
			if (!player.getHasShoes()) {
				//display pop up
				buttonHandler.displayMessage("Death!", 
											 "You've awoken the sleeping dragon!", 
											 20);
				gameOver();
				return false;
			}
			break;
		case 11:
			//room with key
			if (characters[2].getIsAlive()) { //if spider is alive
				buttonHandler.displayMessage("Death", 
											 "Sneaking past the spider\nwas NOT such a good idea!", 
											 20);
				gameOver();
				return false;
			}
			break;
		case 14:
			//the final room
			if(characters[0].getIsAlive()) {
				//ogre is still alive
				roomText.setText("<html><p style=" + ROOM_TEXT_COLOR + ">" + 
							"You really think you're getting past that guy without a fight!!<br /><br />Are you Crazy!!" + 
							"</p></html>");
				return false;
			}
			else if(!player.getHasKey()) {
				//you don't have the key
				roomText.setText("<html><p style=" + ROOM_TEXT_COLOR + ">" + 
						"ARGH!!  It's Locked!<br /><br />There's gotta be a key around here somewhere." + 
						"</p></html>");
				return false;
			}
			break;
		default:
			return true;
		}
		
		return true;
		
	}
	
	
	//display's the game over screen
	public void gameOver() {
		roomNumber = 15;
		
		JLabel gameOver = new JLabel(rooms[roomNumber].getRoomBackgroundImage());
		gameOver.setBounds(0,0,WIDTH, ROOM_HEIGHT);
		
		JButton[] yesNoButtons = buttonHandler.getYesNoButtons();
		
		layers.add(gameOver, Integer.valueOf(150));
		layers.add(yesNoButtons[0], Integer.valueOf(151));
		layers.add(yesNoButtons[1], Integer.valueOf(152));
		
	}

	
	public void resetGame() {
		
		//reset the room Number
		this.roomNumber = 0;
		
		//clear everything from the frame
		frame.remove(layers);
		
	
		//rebuild all frame items
		buildFrameItems();
		
		
		//repaint the frame
		frame.repaint();
	}
	
}
	
