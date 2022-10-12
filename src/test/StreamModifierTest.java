package test;

import org.junit.Test;
import second_example.StreamModifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StreamModifierTest {

    @Test
    public void testAverage(){
        int[] arr = new int[]{5, 10, 17, 24, 32};
        double result = 17.6;
        StreamModifier modifier = new StreamModifier();
        assertEquals(result, modifier.average(arr));
    }

    @Test
    public void testUpperCase(){
        String[] strings = new String[]{"apple", "table", "chair", "intelliJ"};
        List<String> result = new ArrayList<>();
        result.add("APPLE");
        result.add("TABLE");
        result.add("CHAIR");
        result.add("INTELLIJ");

        StreamModifier modifier = new StreamModifier();
        assertEquals(result, modifier.upperCase(strings));
    }

}