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
		
//		"<html><p style=" + display.ROOM_TEXT_COLOR + ">" + 
//				"You just rammed that guy with your shield.<br /><br />" + 
//				"But he smashed it with his club!<br /><br />" + 
//				"You might want to run while you still can..." + 
//				"</p></html>");
		
		String[][] allText = {
			//room #0's text
			{"It's been 17 years since fisrt waking in this dank hell.<br /><br />" +
					"For some reason, the door's not quite shut...<br /><br />" +
					"This is your chance!  GO!!",
			 "How did you end up back here?<br /><br />" +
					"I thought you wanted to get out?",
			 "Seriously... you've already named all the rooms in your cell...<br /><br />" +
					"Why are you back here?!?"
			},
			//room #1's text
			{"Still quiet...<br /><br />" +
					"Has the place been deserted?",
			 "I think that chain looks familiar.<br /><br />" +
					"Are you going in circles?",
			 "I think that chain looks familiar.<br /><br />" +
					"Are you going in circles?"
			},
			//room #2's text
			{"It's abnormally still.<br /><br />" +
					"Where is everybody?",
			 "It's abnormally still.<br /><br />" +
					 "Where is everybody?",
			 "It's abnormally still.<br /><br />" +
					 "Where is everybody?"
			},
			//room #3's text
			{"Wait!!!<br /><br />" +
					"Theres a deep rythmic rumbling coming from the right.<br /><br />" +
					"I quess you're not alone. <br /><br />" + 
					"Do you try the door?",
			 "That rumbling is still unnerving",
			 "Wait...<br /><br />" +
					"Have we seen that brick before?" 
			},
			//room #4's text
			{"A dead end.<br /><br />" + 
					"But not a wasted trip.",
			 "Still a dead end.",
			 "Still a dead end." + 
					 "I think this is where you found the shield."
			},
			//room #5's text
			{"What's that in the corner?<br /><br />" +
					"Maybe you can use this to pilfer as much as possible?<br /><br />" + 
					"Serves them right!",
			 "Wasn't the bag in this room?",
			 "Another dead end.<br /><br />" +
					 "This place really is a maze."
			},
			//room #6's text
			{"Well this explains the smell.<br /><br />" +
					"You think it'll notice if you try and pass?",
			 "Oh yeah... That guy...<br /><br />" + 
					"Still smelly." +
			 "Oh yeah... That guy...<br /><br />" + 
					"Is it possible the stench got worse?"
			},
			//room #7's text
			{"Still to quiet...<br /><br />" +
					"Mabye you should head back.",
			 "I can barely see in here.<br /><br />" +
					"How can you tell where we are?",
			 "I think there was a boot in that corner."
			},
			//room #8's text
			{"It's too quiet in here.",
			 "Drip...<br />Drip...<br />Drip...<br /><br />" +
					 "Can we leave before that drip gets to me?",
			 "Drip...<br />Drip...<br />Drip...<br /><br />" +
					 "Well that sounds familiar."
			},
			//room #9's text
			{"Huh...<br /><br />" +
					"Is there something snoring below you?",
			 "Text For spot #2 if needed later"
			},
			//room #10's text
			{"WOAH!!<br /><br />" +
					"Well that explains the noise!" +
					"Do you dare kill the warden's prized pet?<br />Or just tip-toe around it...",
			 "Text For spot #2 if needed later"
			},
			//room #11's text
			{"Who just leaves key's lying around?",
			 "Text For spot #2 if needed later"
			},
			//room #12's text
			{"Well THAT's a wecome suprised!<br /><br />" +
					"I was wondering how you would get by if there were guards.",
			 "Text For spot #2 if needed later"
			},
			//room #13's text
			{"Well he's cute.<br /><br />" +
					"Think he'll just let you by?",
			 "Text For spot #2 if needed later"
			},
			//room #14's text
			{"So, I know you haven't seen the sun in a VERY long time, but this is amost nauseating.<br /><br />" +
					"Do these people know the horrors beneath their feet?<br /><br />" +
					"Anyway, I hope you found enough loot to start again.<br /><br />" +
					"Good Luck!",
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
