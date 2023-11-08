import java.util.*;
public class movieRatings {
	
	public static List<String> rankMovies(TreeMap<String, TreeSet<String>> map) {
		List<String> rankings = new ArrayList<String>();
		String[] values = (String[])map.values().toArray();
		List<String> listValues = Arrays.asList(values);
		
	    while (listValues.size()>0) {
			int freq = 0;
		    String res = "";
		    for (int i = 0; i < listValues.size(); i++) {
		      int count = 0;
		      for (int j = i + 1; j < listValues.size(); j++) {
		        if (listValues.get(j).equals(listValues.get(i)))
		          count++;
		      }
		      if (count >= freq) {
		        res = listValues.get(i);
		        freq = count;
		      }
		      rankings.add(res);
		      listValues.remove(res);
		    }
	    }
		return rankings;
	}
}
