/**
 * 
 */
package schedule;

/**
 * @author E
 *
 */
public class Budget {
	private double 		allocation;
	private int 		frequencyCount;
	private TimeUnit 	frequencyUnit;
	private double		remainingAllocation;
	
	/*********************************
	 * Constructor: Budget()
	 * Prints an error message when no parameters are passed
	 *********************************/
	public Budget() {
		System.out.println("No parameters provided");
	}
	
	/*********************************
	 * Constructor: Budget()
	 * Constructs a Budget object with the parameters provided
	 *********************************/
	public Budget(double allocation, int frequencyCount, TimeUnit frequencyUnit) {
		this.allocation 		= allocation;
		this.frequencyCount 	= frequencyCount;
		this.frequencyUnit 		= frequencyUnit;
	}
	
	/*********************************
	 * Method: 		canAfford()
	 * Returns whether the user can afford to attend an event
	 *********************************/
	public Boolean canAfford(double cost) {
		double remainingAllocation = getRemainingAllocation();
		if (cost <= remainingAllocation) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*********************************
	 * Method: getAllocation()
	 * returns the original amount of the budget
	 *********************************/
	public double getAllocation() {
		return allocation;
	}

	/*********************************
	 * Method: getFrequencyCount()
	 * returns the number of timeunits that the allocation is given
	 * E.g. every 2 weeks
	 *********************************/
	public int getFrequencyCount() {
		return frequencyCount;
	}

	/*********************************
	 * Method: getRemainingAllocation()
	 * returns the remaining amount after extra events have been added
	 *********************************/
	private double getRemainingAllocation() {
		return remainingAllocation;
	}

	/*********************************
	 * Method: getFrequencyUnit()
	 * returns the timeunits that the allocation is given
	 *********************************/
	public TimeUnit getFrequencyUnit() {
		return frequencyUnit;
	}
	
	/*********************************
	 * Method: setAllocation()
	 * sets the original amount of the budget
	 *********************************/
	public void setAllocation(double allocation) {
		this.allocation = allocation;
	}
	
	/*********************************
	 * Method: setFrequencyCount()
	 * sets the number of TimeUnits that the allocation is given
	 * E.g. every 2 weeks
	 *********************************/
	public void setFrequencyCount(int frequencyCount) {
		this.frequencyCount = frequencyCount;
	}
	
	/*********************************
	 * Method: setFrequencyUnit()
	 * sets the timeunits that the allocation is given
	 *********************************/
	public void setFrequencyUnit(TimeUnit frequencyUnit) {
		this.frequencyUnit = frequencyUnit;
	}

	/*********************************
	 * Method: setRemainingAllocation()
	 * sets the remaining amount after extra events have been added
	 *********************************/
	private void setRemainingAllocation(double remainingAllocation) {
		this.remainingAllocation = remainingAllocation;
	}
	
	/*********************************
	 * Method: toString()
	 * returns the budget information in a string format
	 *********************************/
	public String toString() {
		return "Budget: " + allocation + " every " + frequencyCount + " " + frequencyUnit;
	}
}