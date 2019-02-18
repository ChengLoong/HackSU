package schedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class EventDatabase {
	private File file;
	
	public void setFile(String filePath) {
		file = new File(filePath);
	}
	
	public EventDatabase(String filePath) {
		setFile(filePath);
	}
	
	public ArrayList<Event> read() throws FileNotFoundException {
		ArrayList<Event> database = new ArrayList<Event>();
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			database.add(parseEvent(line));
		}
		input.close();
		return database;	
	}

	public static Event parseEvent(String line) {
		String[] info 	= line.split(",");
		
		String name 	= info[0];
		Time start 		= parseTime(info[1]);
		Time end 		= parseTime(info[2]);
		Double cost 	= Double.parseDouble(info[3]);
		String[] tags 	= parseTags(info[4]);
		
		Event event = new Event(name,tags,start,end,cost,0,null);
		return event;
	}
	
	public static Time parseTime(String line) {
		//System.out.println(line);
		String[] timeinfo = line.split("/");
		//System.out.println(timeinfo[5]);
		int year 	= Integer.parseInt(timeinfo[0]);
		int month 	= Integer.parseInt(timeinfo[1]);
		int day		= Integer.parseInt(timeinfo[2]);
		int hour	= Integer.parseInt(timeinfo[3]);
		int min		= Integer.parseInt(timeinfo[4]);
		AmPm ampm = null;
		if (timeinfo[5].equals("AM")) {
			ampm = AmPm.AM;
		}
		else {
			ampm = AmPm.PM;
		}
		
		Time time = new Time(year,month,day,hour,min,ampm);
		return time;	
	}
	
	public static String[] parseTags(String line) {
		String[] tags 	= line.split(" ");
		return tags;
	}
}