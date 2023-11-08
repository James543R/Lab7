//Gabrielle Akers
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class studentsMatcher {
    public static TreeMap<String, String> findMatches(TreeMap<String, TreeSet<String>> map) {
        TreeMap<String, String> students = new TreeMap<String, String>();
        int count = 0;
        int highCount = 0;
        String highName1 = null;
        String highName2 = null;
        Set<String> keys = map.keySet();
        //Find list of movies for first student
        for(String name1 : keys) {
            TreeSet<String> movies1 = map.get(name1);
            //Find list of movies for second student
            for(String name2 : keys) {
                TreeSet<String> movies2 = map.get(name2);
                //Make sure the keys are different
                if(name1 != name2) {
                    //compare list of movies
                    for(int i = 0; i < movies1.size(); i++) {
                        for(int j = 0; j < movies2.size(); j++) {
                            Object[] mList1 = movies1.toArray();
                            Object[] mList2 = movies2.toArray();
                            if(mList1[i] == mList2[i]) {
                                count++;
                            }
                            //reassign the highest similar value
                            if(count > highCount) {
                                highCount = count;
                                highName1 = name1;
                                highName2 = name2;
                            }
                        }
                    }
                }
                //reset count to zero
                count = 0;
            }
            //Add most similar student
            students.put(highName1, highName2);
            //Set values back to null for next student
            highName1 = null;
            highName2 = null;
            highCount = 0;
        }
        //return TreeMap of similar students
        return students;
    }
}
