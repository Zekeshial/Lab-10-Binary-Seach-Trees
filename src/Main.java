import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    /**
     * This method generates a random list of integers
     * @param size the size of the list or how many integers you wish to create
     * @param bound the size of the integers you wish to create or the max value an integer can be. Example is 100 would generate integers from 1-100.
     * @return The list of integers you generated.
     */
    public static ArrayList<Integer> generateRandomList(int size, int bound) {
        ArrayList<Integer> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            // nextInt(origin, bound) is inclusive of origin, exclusive of bound
            int randomNum = ThreadLocalRandom.current().nextInt(0, bound +1);
            list.add(randomNum);
        }

        return list;
    }

    /**
     * This returns the mean of a list of integers
     * @param list the list of integers you wish to find the mean on
     * @return the mean
     */
    public static double getAverageSumOfListOfIntegers(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return BigDecimal.valueOf((double) sum /list.size()).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().doubleValue();
    }

    /**
     * This returns the mean of a list of Doubles
     * @param list the list of doubles you wish to get the mean on
     * @return the mean rounded up on the hundredth decimal place.
     */
    public static double getAverageSumOfListOfDouble(ArrayList<Double> list) {
        int sum = 0;
        for (Double i : list) {
            sum += i;
        }
        return BigDecimal.valueOf((double) sum /list.size()).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().doubleValue();
    }

    /**
     * This returns the average number of nodes you would need to cross assuming a list is sequential and to find a node you have to check each node sequentially.
     * @param size the size of the list
     * @return the average number of nodes one needs to cross rounded up.
     */
    public static double getAverageNumOfNodesToCrossForEachNode(int size) {

        double totalNumberOfNodesCrossed = BigDecimal.valueOf((double) (size*(size+1)/2)).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().doubleValue();
        return BigDecimal.valueOf( totalNumberOfNodesCrossed/size).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().doubleValue();
    }

    public static void main() {
        //Creating objects to be used in the code
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the Binary Search Tree info tester?\n" +
                "In this code you will be promoted to give a number for the max value a range of random number that can be generated and a size of how many numbers to generate. \n" +
                "An example for the first prompt is 100 would give you a range of 0-100 for random numbers to generate.\n" +
                "An example for the second prompt is 1000 would generate 1000 numbers.\n" +
                "It will then add them into a Binary Search Tree and tell you what the height of the tree is.\n" +
                "It will then repeat this process 10 times for the selected values and give you an average height.\n" +
                "It will then tell you how many nodes it would take to find a value assuming they were put into a sequential array list\n" +
                "and you tried to find each number by looking through the whole list.");

        System.out.println("Give me a number for the largest number that can be generated:");

        int userInputOne = scanner.nextInt();

        System.out.println("Give me a number for how many numbers you wish to generate: ");
        int size = scanner.nextInt();

        int numOfTimesToRun = 10;
        ArrayList<Integer> listOfHeights = new ArrayList<>(numOfTimesToRun);
        ArrayList<Double> listOfAverageNodeTraversals = new ArrayList<>(numOfTimesToRun);
        for (int i = 0; i < numOfTimesToRun; i++) {
            BinaryTree bt = new BinaryTree();
            ArrayList<Integer> listOfRandomInteger = generateRandomList(size, userInputOne);
            for(int j: listOfRandomInteger) {
                bt.insert(j);
            }
            double averageNodeTraversals = bt.findAverageNodeTraversal(listOfRandomInteger);
            System.out.println("Average Node traversal on Tree " + i + ":" + averageNodeTraversals);
            System.out.println("Height of tree " + i + ":" + bt.heightIterative());
            listOfHeights.add(bt.heightIterative());
            listOfAverageNodeTraversals.add(averageNodeTraversals);
        }
        System.out.println("Your average height: " + getAverageSumOfListOfIntegers(listOfHeights));
        System.out.println("Your average time to find a node in a sequential list of your size: " + getAverageNumOfNodesToCrossForEachNode(size));
        System.out.println("Your average time to find a node a binary search tree of your selected size: " + getAverageSumOfListOfDouble(listOfAverageNodeTraversals));





    }
}
