package second_example;

import java.util.Arrays;
import java.util.List;

public class StreamModifier {

    public double average(int[] numbers){
        return Arrays.stream(numbers).mapToDouble(x -> x).reduce(0.0, (x, y) -> x + y / numbers.length);
    }

    public List<String> upperCase(String[] strings){
        return Arrays.stream(strings).map(String::toUpperCase).toList();
    }

}
