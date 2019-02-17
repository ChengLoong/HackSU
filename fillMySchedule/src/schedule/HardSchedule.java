package schedule;

public class HardSchedule {
	private Event[] 		calendar;
	private int 			size;
	public static final int DEFAULT_SIZE = 20;
	
	/*********************************
	 * Constructor: HardSchedule()
	 * Initializes an array of events with the given max size and sets the entry number to 0
	 *********************************/
	public HardSchedule(int capacity) throws IllegalArgumentException{
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be greater than 0.");
		}
		size = 0;
		calendar = new Event[capacity];
	}
	
	/*********************************
	 * Constructor: HardSchedule()
	 * Initializes an array of events with the given max size and sets the entry number to 0
	 *********************************/
	public HardSchedule() {
		this.HardSchedule(DEFAULT_SIZE);
	}
	
	/*********************************
	 * Method: add()
	 * adds an event to the calendar and increments size by 1
	 * increases the size of the database if it is full
	 *********************************/
	public void add(Event event) {
		calendar[size] = event;
		size++;
		if (size >= calendar.length) {
			expand();
		}
	}
	
	/*********************************
	 * Method: expand()
	 * creates a new database of double the size of the old one
	 * copies the old entries into the new database
	 * returns the new database
	 *********************************/
	public void expand() {
		int newlength = size*2;
		Event[] newCalendar = new Event [newlength];
		for (int i = 0; i < size; i++) {
			newCalendar[i] = calendar[i];
		}
		calendar = newCalendar;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
