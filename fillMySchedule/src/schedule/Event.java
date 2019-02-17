/**
 * 
 */
package schedule;

/**
 * @author E
 *
 */
public class Event {
	private String name;
	private String[] keyWords;
	private Time start;
	private Time end;
	private double cost;
	private int durationMins;
	private int frequencyCount;
	private TimeUnit frequencyUnit;
	
	public Event() {}
	public Event(String name, String[] keyWords, Time start, Time end,
			double cost, int frequencyCount, TimeUnit frequencyUnit) {
		this.name = name;
		this.keyWords = keyWords;
		this.start = start;
		this.end = end;
		setDurationMins();
		this.cost = cost;
		this.frequencyCount = frequencyCount;
		this.frequencyUnit = frequencyUnit;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the start
	 */
	public Time getStart() {
		return start;
	}
	/**
	 * @return the start
	 */
	public Time getEnd() {
		return end;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @return the keyWords
	 */
	public String[] getKeyWords() {
		return keyWords;
	}
	/**
	 * @return the durationMins
	 */
	public int getDurationMins() {
		return durationMins;
	}
	/**
	 * @return the frequencyCount
	 */
	public int getFrequencyCount() {
		return frequencyCount;
	}
	/**
	 * @return the frequencyUnit
	 */
	public TimeUnit getFrequencyUnit() {
		return frequencyUnit;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @param keyWords the keyWords to set
	 */
	public void setKeyWords(String[] keyWords) {
		this.keyWords = keyWords;
	}
	/**
	 * @param hour the hour to convert
	 */
	private int convertMilitaryTime(Time toCheck) {
		int hour = toCheck.getHour();
		if (toCheck.getAmPm().equals(AmPm.PM)) {
			hour += 12;
		}
		return hour;
	}
	/**
	 * @param durationMins the durationMins to set
	 */
	private void setDurationMins() {
	    int tempMins = end.getMin() - start.getMin();
	    int endHour = convertMilitaryTime(end);
	    if (tempMins < 0) {
	    	tempMins += 60;
	    	endHour -= 1;
	    }
	    int dayDiff = end.getDay() - start.getDay();
	    if (dayDiff > 0) {
	    	endHour += dayDiff * 24;
	    }
	    int tempHrs = endHour - convertMilitaryTime(start);
	    tempHrs *= 60;
	    tempMins += tempHrs;
	    this.durationMins = tempMins;
	}
	/**
	 * @param frequencyCount the frequencyCount to set
	 */
	public void setFrequencyCount(int frequencyCount) {
		this.frequencyCount = frequencyCount;
	}
	/**
	 * @param frequencyUnit the frequencyUnit to set
	 */
	public void setFrequencyUnit(TimeUnit frequencyUnit) {
		this.frequencyUnit = frequencyUnit;
	}
	public String toString() {
		return name;
	}
	
}