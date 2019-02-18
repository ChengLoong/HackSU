/**
 * 
 */
package schedule;

import java.util.ArrayList;

/**
 * @author E
 *
 */
public class RankMe {
	private Event[] allEvents;
	private Event[] topSuggestions = new Event[7];
	
	public RankMe() {}
	public RankMe(ArrayList<Event> allEvents, Budget budget, String[] topTags) { //change budget to Person.getBudget
		for (int j = 0; j < allEvents.size(); j++) {
			if(!budget.canAfford(allEvents.get(j).getCost())){
				allEvents.remove(j);
				j--;
			}
		}
		this.allEvents = new Event[allEvents.size()];
		for (int i = 0; i < allEvents.size(); i++) {
			this.allEvents[i] = allEvents.get(i);
		}
		
		suggest(topTags);
	}
	private int getEventRank(String[] eventKeywords, String[] topTags) {
		int countScore = 0;
		for (int i = 0; i < topTags.length; i++) { //i == index of user's topTags
			for (int j = 0; j < eventKeywords.length; j++) { //j == index of this events keywords
				if(eventKeywords[j].equals(topTags[i])) {
					countScore++;
				}
			}
		}
		
		return countScore;
	}
	public Event[] getTopSuggestions() {
		return topSuggestions;
	}
	private void suggest(String[] topTags) { //ranks events and populates a top-suggestions Event[7]
		int[] eventIndexRank = new int[allEvents.length];
		int topRankIndex = 0;
		int topRankValue = 0;
		Event[] suggestThese = new Event[7];
		for (int i = 0; i < allEvents.length; i++) {
			eventIndexRank[i] = getEventRank(allEvents[i].getKeyWords(), topTags);
			if (eventIndexRank[i] > topRankValue) {
				topRankValue = eventIndexRank[i];
				topRankIndex = i;
			}
		}
		suggestThese[0] = allEvents[topRankIndex];
		eventIndexRank[topRankIndex] = 0;
		for (int j = 1; j < 7; j++) {
			int index = findMax(eventIndexRank);
			suggestThese[j] = allEvents[index];
			eventIndexRank[index] = -1; //here
		}
		setTopSuggestions(suggestThese);
	}
	private void setTopSuggestions(Event[] tops) {
		for (int i = 0; i < 7; i++) {
			this.topSuggestions[i] = tops[i];
		}
	}
	
	private int findMax(int[] list) {
		int currentMax = list[0];
		int maxIndex = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] >= currentMax) {
				currentMax = list[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

}