package schedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class EventTestClient {

	
	static String fileReadLocation = 		File.separator + "C:" + 
											File.separator + "users" + 
											File.separator + "Cheng" +
											File.separator + "Desktop" + 
											File.separator + "HackSU" + 
											File.separator + "Event list.txt";
											
	public static void main(String[] args) throws FileNotFoundException {
		EventDatabase storage = new EventDatabase(fileReadLocation);
		ArrayList<Event> test = storage.read();
		
//		System.out.println(test.toString());
//		System.out.println(test.get(1).getName());
		
		Budget budget = new Budget(300, 1, TimeUnit.WEEK);
		String[] topRank = {"trivia", "food", "social"};
		System.out.println(test.toString());
		
		RankMe rankTest = new RankMe(test,budget,topRank);
//		System.out.println(test.toString());
		
		Event[] yourTopSuggestions = rankTest.getTopSuggestions();
		System.out.println(Arrays.toString(yourTopSuggestions));
//		System.out.println(x);
	}

}
