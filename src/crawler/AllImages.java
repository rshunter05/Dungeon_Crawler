package crawler;

import javax.swing.ImageIcon;

/*
 * This stores all the location information for each image.
 * Centralizing this information helps to keep everything organized
 * and easy to find / edit
 * 
 * This way if a file if you...
 *  - move the picture file
 *  - change the picture
 *  - rename the picture
 *  - anything else about the picture...
 * you only need to change the location reference to it ONCE!!!!!
 * 
 */

public class AllImages {
	
	/*
	 * If given the roomNumber it will return the appropriate background image
	 * 
	 * If given a roomNumber that doesn't exist a picture of a red X is returned.
	 * This way the program doesn't crash.
	 * 
	 * I started at 0 because the rooms array starts at 0
	 */
	public static ImageIcon getBackgroundImage(int roomNumber) {
		
		switch (roomNumber) {
		case 0:
			return new ImageIcon("res/rooms/Room.jpg");
		case 1:
			return new ImageIcon("res/rooms/Room.jpg");
		case 2:
			return new ImageIcon("res/rooms/RoomWithDoor.jpg");
		case 3:
			return new ImageIcon("res/rooms/RoomWithDoor.jpg");
		case 4:
			return new ImageIcon("res/rooms/RoomWithDoor.jpg");
		case 5:
			return new ImageIcon("res/rooms/Room.jpg");
		case 6:
			return new ImageIcon("res/rooms/Room.jpg");
		case 7:
			return new ImageIcon("res/rooms/RoomWithDoor.jpg");
		case 8:
			return new ImageIcon("res/rooms/RoomWithDoor.jpg");
		case 9:
			return new ImageIcon("res/rooms/RoomWithDoor.jpg");
		case 10:
			return new ImageIcon("res/rooms/RoomWithDoor.jpg");
		case 11:
			return new ImageIcon("res/rooms/Room.jpg");
		case 12:
			return new ImageIcon("res/rooms/Room.jpg");
		case 13:
			return new ImageIcon("res/rooms/Room.jpg");
		case 14:
			return new ImageIcon("res/rooms/Exit Screen.png");
		case 15:
			//Game Over Screen
			return new ImageIcon("res/rooms/Game Over.png");
		default:
			//for if you sent a number not in the list
			return new ImageIcon("res/default pic (150x150).png");
		}
		
	}
	
	/*
	 * These are the items that can be found around game
	 * The'll be used when creating an Item object
	 * 
	 * Note, in my case they're in the same order as the ItemInformation class
	 */
	public static ImageIcon getItemImage(int itemNumber) {
		
		switch (itemNumber) {
		case 0:
			//Gold 50 x 50 
			return new ImageIcon("");
		case 1:
			//Gold 100 x 100
			return new ImageIcon("res/items/Gold 100x100.png");
		case 2:
			//Potion 50 x 50
			return new ImageIcon("res/items/Potion 50.png");
		case 3:
			//Potion 100 x 100
			return new ImageIcon("res/items/Potion 100.png");
		case 4:
			//Sword 50 x 50
			return new ImageIcon("res/items/Sword 50.png");
		case 5:
			//Sword 100 x 100
			return new ImageIcon("res/items/Sword 100.png");
		case 6:
			//Shield 50 x 50
			return new ImageIcon("res/items/Shield 50.png");
		case 7:
			//Shield 100 x 100
			return new ImageIcon("res/items/Shield 100.png");
		case 8:
			//BackPack 50 x 50
			return new ImageIcon("res/items/Bag 50.png");
		case 9:
			//BackPack 100 x 100
			return new ImageIcon("res/items/Bag 100.png");
		case 10:
			//Key 50 x 50
			return new ImageIcon("res/items/Key 50.png");
		case 11:
			//Key 100 x 100
			return new ImageIcon("res/items/Key 100.png");
		case 12:
			//Shoes 50 x 50
			return new ImageIcon("res/items/Shoes 50.png");
		case 13:
			//Shoes 100 x 100
			return new ImageIcon("res/items/Shoes 100.png");
		case 14:
			//left arrow
			return new ImageIcon("res/items/Arrow Left.png");
		case 15:
			//up arrow
			return new ImageIcon("res/items/Arrow Up.png");
		case 16:
			//right arrow
			return new ImageIcon("res/items/Arrow Right.png");
		case 17:
			//down arrow
			return new ImageIcon("res/items/Arrow Down.png");
		case 18:
			//yes button
			return new ImageIcon("res/items/Yes Button.png");
		case 19:
			//no button
			return new ImageIcon("res/items/No Button.png");
		case 20:
			//no button
			return new ImageIcon("res/items/Death 50.png");
		default:
			//for if you sent a number not in the list
			return new ImageIcon("res/default pic (150x150).png");
			
		}
		
		
	}
	
	
	public static ImageIcon getFredsImage(int imageNumber) {
		
		switch (imageNumber) {
		case 0:
			//Fred's picture
			return new ImageIcon("res/fred/Man.png");
		case 1:
			//Fred's sword
			return new ImageIcon("res/fred/Man Sword.png");
		case 2:
			//Fred's shield 
			return new ImageIcon("res/fred/Man Shield.png");
		case 3:
			//Fred's Backpack
			return new ImageIcon("res/fred/Man Bag.png");
		case 4:
			//Fred's Key
			return new ImageIcon("res/fred/Man Key.png");
		case 5:
			//Fred's shoes
			return new ImageIcon("res/fred/Man Shoes.png");
		default:
			//for if you sent a number not in the list
			return new ImageIcon("res/default pic (150x150).png");
		}
		
	}
	
	
	/*
	 * For Character's images
	 */
	public static ImageIcon getCharacterImage(int imageNumber) {
		
		switch (imageNumber) {
		case 0:
			//the orc
			return new ImageIcon("res/characters/Ogre.png");
		case 1:
			//the dragon
			return new ImageIcon("res/characters/Dragon.png");
		case 2:
			//for spider
			return new ImageIcon("res/characters/Spider.png");
		case 3:
			//for spider hit #1
			return new ImageIcon("res/characters/Spider Hit 1.png");
		case 4:
			//for spider hit #2
			return new ImageIcon("res/characters/Spider Hit 2.png");
		case 5:
			//for spider dead
			return new ImageIcon("res/characters/Spider Hit 3.png");
			
		default:
			//for if you sent a number not in the list
			return new ImageIcon("res/default pic (150x150).png");
		}
		
	}
	
	
	
	
	
}
