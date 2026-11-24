import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    public static ArrayList<Integer> generateRandomList(int size, int bound) {
        ArrayList<Integer> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            // nextInt(origin, bound) is inclusive of origin, exclusive of bound
            int randomNum = ThreadLocalRandom.current().nextInt(0, bound +1);
            list.add(randomNum);
        }

        return list;
    }

    public static double getAverageSumOfListOfIntegers(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return BigDecimal.valueOf((double) sum /list.size()).setScale(0, RoundingMode.HALF_UP).stripTrailingZeros().doubleValue();
    }

    public static double getAverageNumOfNodesToCrossForEachNode(int size) {

        double totalNumberOfNodesCrossed = BigDecimal.valueOf((double) (size*(size+1)/2)).setScale(0, RoundingMode.HALF_UP).stripTrailingZeros().doubleValue();
        return BigDecimal.valueOf(totalNumberOfNodesCrossed/size).setScale(0, RoundingMode.HALF_UP).stripTrailingZeros().doubleValue();
    }

    public static void main() {
        //Creating objects to be used in the code

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the Binary Search Tree info tester?\n" +
                "In this code you will be promoted to give a number for the max value a range of random number that can be generated and a size of how many numbers to generate. \n" +
                "An example for the first prompt is 100 would give you a range of 0-100 for random numbers to generate.\n" +
                "An example for the second prompt is 1000 would generate 1000 numbers." +
                "It will then add them into a Binary Search Tree and tell you what the height of the tree is.\n" +
                "It will then repeat this process 10 times for the selected values and give you an average height.\n" +
                "It will then tell you how many nodes it would take to find a value assuming they were put into a sequential array list and you tried to find each number by looking through the whole list.");

        System.out.println("Give me a number for the largest number that can be generated:");

        int userInputOne = scanner.nextInt();

        System.out.println("Give me a number for how many numbers you wish to generate: ");
        int size = scanner.nextInt();

        ArrayList<Integer> listOfHeights = new ArrayList<>(size);
        for (int i = 0; i < 10; i++) {
            BinaryTree bt = new BinaryTree();
            ArrayList<Integer> listOfRandomInteger = generateRandomList(size, userInputOne);
            for(int j: listOfRandomInteger) {
                bt.insert(j);
            }
            System.out.println("Height " + i + ":" + bt.heightIterative());
            listOfHeights.add(bt.heightIterative());
        }
        System.out.println("Your average height: " + getAverageSumOfListOfIntegers(listOfHeights));
        System.out.println("Your average time to find a node in a sequential list of your size: " + getAverageNumOfNodesToCrossForEachNode(size));





    }
}
