import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //Testing that you can get the average sum of a list of integers
    @Test
    void getAverageSumOfListOfIntegersTest2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(2);
        list.add(3);
        list.add(15);

        double actual = Main.getAverageSumOfListOfIntegers(list);
        double expected = 9;

        assertEquals(expected, actual);
    }


    @Test
    void getAverageNumOfNodesToCrossForEachNode() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(5);
        double actual = Main.getAverageNumOfNodesToCrossForEachNode(list.size());
        double expected = 4;
        assertEquals(expected, actual);
    }
}