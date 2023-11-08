import java.util.*;

/**
 * movieRatings - A class that contains the rankMoveies() method.
 * @author Nathaniel Serrano
 * @version 8 November 2023
 *
 */
public class movieRatings {
	
	/**
	 * rankMovies() - A method that takes a TreeMap of Strings and TreeSets of movie titles and 
	 * returns a list ranking the most most common to the least common movies in the list.
	 * @param map - TreeMap<String, TreeSet<String>>
	 * @return rankings - List<String>
	 */
	public static List<String> rankMovies(TreeMap<String, TreeSet<String>> map) {
		List<String> rankings = new ArrayList<String>();
		Object[] array = map.values().toArray();
		String[] values = Arrays.copyOf(array, array.length, String[].class);
		List<String> listValues = Arrays.asList(values);
	    while (listValues.size()>0) {
			int max = 0;
		    String mostPopular = "";
		    for (int i = 0; i < listValues.size(); i++) {
		      int count = 0;
		      for (int j = i + 1; j < listValues.size(); j++) {
		        if (listValues.get(j).equals(listValues.get(i)))
		          count++;
		      }
		      if (count >= max) {
		        mostPopular = listValues.get(i);
		        max = count;
		      }
		    }
		      rankings.add(mostPopular);
		      listValues.remove(mostPopular);
	    }
		return rankings;
	}
}
