package crawler;

import javax.swing.JButton;

/*
 * Stores all the base information for each item in the game
 * 
 * just call a method with the correct item number and it'll return 
 * the desired information
 * 
 * Example:
 *    ItemInformation.getName(0) returns "sword 
 *    
 * Element Number    Item     Room It's in   
 *    0				 gold		   2
 *    1				 gold	  	   3
 *    2				 gold		   4
 *    3				 gold		   8
 *    4				 gold		   10
 *    5				 gold		   11
 *    6				 gold		   13
 *    7				health		   4
 *    8				health		   10
 *    9				health		   11
 *    10			health		   12
 *    11			sword		   12
 *    12			shield		   4
 *    13		   backpack		   5
 *    14			 key		   11
 *    15			shoes	       7
 */

public class ItemInformation {

	
	public static String getName(int itemNumber) {
		
		switch (itemNumber) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			//the gold
			return "Gold";
		case 7:
		case 8:
		case 9:
		case 10:
			//the potion
			return "Health";
		case 11:
			//the sword
			return "Sword";
		case 12:
			//the shield
			return "Shield";
		case 13:
			//the backpack
			return "Bag";
		case 14:
			//the key
			return "Key";
		case 15:
			//the shoes
			return "Shoes";
		default:
			//for if you sent a number not in the list
			return "bad item number";
			
		}
	}
	
	
	public static int getPower(int itemNumber) {
		
		switch (itemNumber) {
		case 0:
			//the gold room #2
			return 3;
		case 1:
			//the gold room #3
			return 5;
		case 2:
			//the gold room #4
			return 2;
		case 3:
			//the gold room #8
			return 12;
		case 4:
			//the gold room #10
			return 15;
		case 5:
			//the gold room #11
			return 32;
		case 6:
			//the gold room #13
			return 50;
		case 7:
			//the potion room #4
			return 12;
		case 8:
			//the potion room #10
			return 4;
		case 9:
			//the potion room #11
			return 45;
		case 10:
			//the potion room #12
			return 9;
		case 11:
			//the sword
			return 1;
		case 12:
			//the shield
			return 1;
		case 13:
			//the bag
			return 1;
		case 14:
			//the key
			return 1;
		case 15:
			//the shoes
			return 1;
		default:
			//for if you sent a number not in the list
			return -1;
			
		}
	}
	
	public static int[] getRoomItemList(int roomNumber) {
		/*
		 * Row arrays correspond to a room number
		 * 
		 * Individual arrays hold the index of whatever items
		 * are in that room
		 * 
		 * if array contains a -1, that means the room is empty
		 * 
		 */
		int[][] itemLists = {{-1},  //room 0
						     {0},  //room 1
						     {-1},  //room 2
						     {1},  //room 3
						     {7, 2, 12},  //room 4
						     {13},  //room 5
						     {-1},  //room 6
						     {15},  //room 7
						     {3},  //room 8
						     {-1},  //room 9
						     {4, 8},  //room 10
						     {5, 9, 14},  //room 11
						     {10, 11},  //room 12
						     {6},  //room 13
						     {-1},  //room 14
						     {-1}  //room 15
		};
		
		return itemLists[roomNumber];
		
	}
	
	public static void setItemButtonBounds(JButton button, int itemNumber, Display display) {
		//if bad item number is sent, this is the default position and size
		int xPos = 0, yPos = 0, width = 200, height = 200;
		
		if (itemNumber <= 15) {  //item buttons
			width = 100;
			height = 100;
		}
		else if (itemNumber <= 20) {  //item inventory buttons
			width = 50;
			height = 50;
		}
		
		switch (itemNumber) {
		case 0: 
			//gold 0
			xPos = 800;
			yPos = 500;
			break;
		case 1: 
			//gold 1
			xPos = 130;
			yPos = 500;
			break;
		case 2: 
			//gold 2
			xPos = 900;
			yPos = 660;
			break;
		case 3: 
			//gold 3
			xPos = 900;
			yPos = 660;
			break;
		case 4: 
			//gold 4
			xPos = 900;
			yPos = 660;
			break;
		case 5: 
			//gold 5
			xPos = 800;
			yPos = 500;
			break;
		case 6: 
			//gold 6
			xPos = 800;
			yPos = 500;
			break;
		case 7: 
			//health 0
			xPos = 800;
			yPos = 500;
			break;
		case 8: 
			//health 1
			xPos = 50;
			yPos = 650;
			break;
		case 9: 
			//health 2
			xPos = 900;
			yPos = 660;
			break;
		case 10: 
			//health 3
			xPos = 130;
			yPos = 450;
			break;
		case 11: 
			//sword
			xPos = 550;
			yPos = 580;
			break;
		case 12: 
			//shield
			xPos = 850;
			yPos = 580;
			break;
		case 13: 
			//backpack
			xPos = 130;
			yPos = 450;
			break;
		case 14: 
			//key
			xPos = 700;
			yPos = 320;
			break;
		case 15: 
			//shoes
			xPos = 50;
			yPos = 650;
			break;
		case 16: 
			//inventory item #0
			xPos = display.WIDTH / 2 + display.ROOM_WIDTH / 2 - 95;
			yPos = display.ROOM_HEIGHT - 355;
			break;
		case 17: 
			//inventory item #1
			xPos = display.WIDTH / 2 + display.ROOM_WIDTH / 2 - 25;
			yPos = display.ROOM_HEIGHT - 355;
			break;
		case 18: 
			//inventory item #2
			xPos = display.WIDTH / 2 + display.ROOM_WIDTH / 2 + 45;
			yPos = display.ROOM_HEIGHT - 355;
			break;
		case 19: 
			//inventory item #3
			xPos = display.WIDTH / 2 + display.ROOM_WIDTH / 2 - 60;
			yPos = display.ROOM_HEIGHT - 295;
			break;
		case 20: 
			//inventory item #4
			xPos = display.WIDTH / 2 + display.ROOM_WIDTH / 2 + 10;
			yPos = display.ROOM_HEIGHT - 295;
			break;
		case 21: 
			//orc
			xPos = display.ROOM_WIDTH / 2 - 120;
			yPos = display.ROOM_HEIGHT / 6 - 30;
			width = 701;
			height = 701;
			break;
		case 22: 
			//dragon
			xPos = display.ROOM_WIDTH / 2 - 60;
			yPos = display.ROOM_HEIGHT - 400;
			width = 500;
			height = 453;
			break;
		case 23: 
			//spider
			xPos = display.ROOM_WIDTH / 2 + 10;
			yPos = display.ROOM_HEIGHT / 2 + 50;
			width = 300;
			height = 300;
			break;
		}
		
		
		button.setBounds(xPos, yPos, width, height);
	}
		
		
	public static String getCharacterName(int characterNumber) {
		switch (characterNumber) {
		case 0:
			return "Orc";
		case 1:
			return "Dragon";
		case 2:
			return "Spider";
		default:
			return "bad chacracter name number";
		}
	}
	
}
