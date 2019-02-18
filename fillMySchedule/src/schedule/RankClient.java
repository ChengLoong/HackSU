/**
 * 
 */
package schedule;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author E
 *
 */
public class RankClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Time start = new Time(2019, 2, 2, 2, 29, AmPm.PM);
		Time end = new Time(2019, 2, 3, 10, 5, AmPm.AM);
		String[] keyWords = {"education", "comedy", "show"}; //0
		String[] keyWords1 = {"trivia", "food", "social"}; //3
		String[] keyWords2 = {"comedy", "show", "trivia", "food"}; //2
		String[] keyWords3 = {"entertainment", "film", "travel"}; //0
		String[] keyWords4 = {"play", "trivia"}; //1
		String[] keyWords5 = {"night", "day", "lgbt", "local"}; //0
		String[] keyWords6 = {"realty", "sing", "asia"}; //0
		String[] keyWords7 = {"highclass", "sale", "trivia"}; //1
		

		Event test1 = new Event("Test number 1", keyWords, start, end, 0.0, 1, TimeUnit.ONEOFF);
		Event test2 = new Event("Test number 2", keyWords1, start, end, 400.0, 1, TimeUnit.ONEOFF);
		Event test3 = new Event("Test number 3", keyWords2, start, end, 400.0, 1, TimeUnit.ONEOFF);
		Event test4 = new Event("Test number 4", keyWords3, start, end, 400.0, 1, TimeUnit.ONEOFF);
		Event test5 = new Event("Test number 5", keyWords4, start, end, 0.0, 1, TimeUnit.ONEOFF);
		Event test6 = new Event("Test number 6", keyWords5, start, end, 0.0, 1, TimeUnit.ONEOFF);
		Event test7 = new Event("Test number 7", keyWords6, start, end, 0.0, 1, TimeUnit.ONEOFF);
		Event test8 = new Event("Test number 8", keyWords7, start, end, 0.0, 1, TimeUnit.ONEOFF);
		
		ArrayList<Event> testing = new ArrayList<Event>();
		testing.add(test1);
		testing.add(test2);
		testing.add(test3);
		testing.add(test4);
		testing.add(test5);
		testing.add(test6);
		testing.add(test7);
		testing.add(test8);
		
		Budget budget = new Budget(300, 1, TimeUnit.WEEK);
		
		String[] topRank = {"trivia", "food", "social"};
		
		System.out.println(testing.toString());
		RankMe ranker = new RankMe(testing, budget, topRank);
		System.out.println(testing.toString());
		Event[] yourTopSuggestions = ranker.getTopSuggestions();
		
		System.out.println(Arrays.toString(yourTopSuggestions));

	}

}