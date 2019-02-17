/**
 * 
 */
package schedule;

/**
 * @author E
 *
 */
public class Time {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	private AmPm amPm;
	
	public Time() {}
	public Time(int yyyy, int mm, int dd, int hr, int min, AmPm amPm) {
		year = yyyy;
		month = mm;
		day = dd;
		hour = hr;
		this.min = min;
		this.amPm = amPm;
	}

	/**
	 * @param amPm the amPm to set
	 */
	public void setAmPm(AmPm amPm) {
		this.amPm = amPm;
	}
	public void switchAmPm() {
		if (amPm.equals(AmPm.AM)) {
			setAmPm(AmPm.PM);
		}else {
			setAmPm(AmPm.AM);
		}
	}
	/**
	 * @return the amPm
	 */
	public AmPm getAmPm() {
		return amPm;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	
	
}