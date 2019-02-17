package schedule;

public class HardSchedule {
	private Event[] 		calendar;
	private int 			size;
	public static final int DEFAULT_SIZE = 20;
	
	/*********************************
	 * Constructor: HardSchedule()
	 * Initializes an array of events with the given max size and sets the entry number to 0
	 */
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
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
