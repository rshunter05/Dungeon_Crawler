package crawler;

public class AllText {

	/*
	 * This can store all the changing text that's room specific.
	 * 
	 * I feel free to add more rows and more strings to each row
	 * 
	 * Also, I'd come up with some convention for what type of information would be in which spot.
	 * Example, 
	 *   index 0 for the title
	 *   index 1 for... I don't know whatever you need that's common to each room, 
	 *        if there's nothing needed, just leave it empty ""
	 */
	
	public static String getText(int roomNumber, int phraseNumber) {
		
		String[][] allText = {
			//room #0's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #1's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #2's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #3's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #4's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #5's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #6's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #7's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #8's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #9's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #10's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #11's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #12's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #13's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #14's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
			//room #15's text
			{"Text for room # " + roomNumber,
				"Text For spot #2 if needed later"
			},
		};
		
		
		
		return allText[roomNumber][phraseNumber];
	}
	

	public static String getDirections(int roomNumber) {
	
		String[] directions = {"right",  //room 0
					"left right down",  //room 1
					"left up right down",  //room 2
					"up right down",  //room 3
					"up",  //room 4
					"right",  //room 5
					"right down",  //room 6
					"up down",  //room 7
					"left up down",  //room 8
					"left up right down",  //room 9
					"left up right",  //room 10
					"left",  //room 11
					"left",  //room 12
					"left right",  //room 13
					"left",  //room 14
					"" //room 15
					};
		
		return directions[roomNumber];
		
	}
	
	public static int[] getSurroundingRooms(int roomNumber) {
		
		int[][] surroundingRooms = {{20, 20, 2, 20},  //Room 0
									{5, 10, 8, 2},  //Room 1
									{0, 1, 9, 3},  //Room 2
									{20, 2, 10, 4},  //Room 3
									{20, 3, 20, 20},  //Room 4
									{20, 20, 1, 20},  //Room 5
									{20, 20, 11, 7},  //Room 6
									{20, 6, 20, 8},  //Room 7
									{1, 7, 20, 9},  //Room 8
									{2, 8, 13, 10},  //Room 9
									{3, 9, 12, 20},  //Room 10
									{6, 20, 20, 20},  //Room 11
									{10, 20, 14, 20},  //Room 12
									{9, 20, 14, 20},  //Room 13
									{13, 20, 20, 20},   //Room 14
									{20, 20, 20, 20}   //Room 15
									};
		
	
		return surroundingRooms[roomNumber];
	
	
	}
	
	
	
}
