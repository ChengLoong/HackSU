/**
 * 
 */
package schedule;

/**
 * @author E
 *
 */
public class Tags {
	private String[] tagList = {"education", "comedy", "show", "trivia", "food", "social", 
			"alcohol", "dance", "music", "entertainment", "film", "travel", "museum", "computer", 
			"art", "new", "old", "games", "fashion", "shopping", "book", "selfie", "sport", 
			"agriculture", "play", "spectate", "tech", "vegan", "organic", "live", "dating",
			"family", "children", "home", "realty", "sing", "asia", "culture", "western", 
			"auction", "highclass", "sale", "morning", "night", "day", "lgbt", "local"};
	
	public Tags() {}
	
	public int getEventRank(String[] eventKeywords, String[] topTags) {
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
	
	public Event[] getTopSuggestions(Event[] eventOptions, String[] topTags) { //ranks events and populates a top-suggestions Event[7]
		int[] eventIndexRank = new int[eventOptions.length];
		int topRankIndex = 0;
		int topRankValue = 0;
		Event[] suggestThese = new Event[7];
		for (int i = 0; i < eventOptions.length; i++) {
			eventIndexRank[i] = getEventRank(eventOptions[i].getKeyWords(), topTags);
			if (eventIndexRank[i] > topRankValue) {
				topRankValue = eventIndexRank[i];
				topRankIndex = i;
			}
		}
		suggestThese[0] = eventOptions[topRankIndex];
		eventIndexRank[topRankIndex] = 0;
		for (int j = 1; j < 7; j++) {
			int index = findMax(eventIndexRank);
			suggestThese[j] = eventOptions[index];
			eventIndexRank[index] = 0;
		}
		return suggestThese;
	}
	
	public int findMax(int[] list) {
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