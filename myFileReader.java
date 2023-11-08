import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class myFileReader {

    public static TreeMap<String, TreeSet<String>> readToTreeMap(String filePath) throws FileNotFoundException {
        try (Scanner s = new Scanner(new File(filePath)).useDelimiter(",")) {
            TreeMap<String, TreeSet<String>> map = new TreeMap<String, TreeSet<String>>();         
            while(s.hasNextLine()) {
                TreeSet<String> set = new TreeSet<String>();
                String line = s.nextLine();
                String[] words = line.split(",", 6);
                String key = words[0];
                for(int i = 1; i < words.length; i++) {
                    set.add(words[i]);
                }
                map.put(key, set);
            }
            s.close();
            return map;
        }
    }
}
