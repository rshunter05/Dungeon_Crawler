package crawler;

import javax.swing.ImageIcon;

/*
 * The common info that every room has.
 * 
 * Mine just has these things
 */

public class Room {
	
	private int roomNumber;  //the room's number
	private String roomText;  //room's title
	private ImageIcon roomBackgroundImage;
	private String directions;
	private int[] surroundingRooms;
	private int[] itemList;
	
	
	
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
		
		
		//get text info from the AllText class
		roomText = AllText.getText(roomNumber, 0);
		directions = AllText.getDirections(roomNumber);
		surroundingRooms = AllText.getSurroundingRooms(roomNumber);
		//get image info from the AllImages class
		roomBackgroundImage = AllImages.getBackgroundImage(roomNumber);
		itemList = ItemInformation.getRoomItemList(roomNumber);
		
	}
	
	
	
	
	/*
	 * Getter methods for each instance variable.
	 */
	public int getRoomNumber() {
		return roomNumber;
	}
	public String getRoomText() {
		return roomText;
	}
	public ImageIcon getRoomBackgroundImage() {
		return roomBackgroundImage;
	}
	public int[] getItemList() {
		return itemList;
	}
	
	
	
	public boolean hasDirection(String direction) {
		return directions.contains(direction);
	}
	
	//returns the room in a specific direction
	public int getNextRoomNumber(int direction) {
		/*
		 * Acceptable Direction Values
		 * 0 = left
		 * 1 = up
		 * 2 = right
		 * 3 = down
		 */
		if (direction >= 0 && direction <= 4) {
			return surroundingRooms[direction];
		}
		return 0;
	}
	
}
