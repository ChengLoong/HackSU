package schedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
		
		System.out.println(test.get(0).getName());
		System.out.println(test.get(1).getName());

	}

}
