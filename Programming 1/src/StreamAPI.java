import java.util.ArrayList;
import java.util.stream.*;

public class StreamAPI {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();

        // using a parallel stream to compute the average length of strings in the arraylist
        int lengthSum = stringList.parallelStream()
                                  .mapToInt( str -> str.length() )  // The result of the map operation is to produce a new stream, this time a stream of integers, consisting of all the outputs from the function.
                                  .sum();
        //  The fact that it is a “parallelStream” makes it possible to parallelize the computation.
        double average = (double)lengthSum / stringList.size();
    }
}
