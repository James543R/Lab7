import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;


//Author - James Libby
public class lab7 {

    public static void main(String[] args) {
        String filePath = "Movies.csv";
        
        myFileReader fileReader = new myFileReader();
        studentsMatcher matcher = new studentsMatcher();
        movieRatings ratings = new movieRatings();
        movieNight night = new movieNight();
        
        //Creates the treemap
        TreeMap<String, TreeSet<String>> map = fileReader.readToTreeMap(filePath);
        String student = matcher.findMatches(map);
        //Prints the result of the studentsMatcher classes method findMatches
        System.out.println(student);
        
        List<String> movieratings = ratings.rankMovies(map);
        //Prints the result of the movieRatings classes method rankMovies
        System.out.println(movieratings);
        
        Boolean movienight = night.rankMovies(map, movieratings);
        //Prints the result of the movieNight classes method rankMovies
        System.out.println(movienight);
    }

}
