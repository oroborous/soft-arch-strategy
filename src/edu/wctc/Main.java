package edu.wctc;

import edu.wctc.strategy.after.*;
import edu.wctc.strategy.before.ExponentialColony;
import edu.wctc.strategy.before.LinearColony;
import edu.wctc.strategy.before.LogisticColony;
import edu.wctc.strategy.before.NoGrowthColony;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Use Template Method (abstract BacteriaColony class)");
        System.out.println("2. Use Strategy (GrowthStrategy interface)");
        System.out.print(">> ");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1)
            runBefore();
        else
            runAfter();
    }

    public static void runBefore() {
        System.out.print("Enter starting population: ");
        long population = Long.parseLong(scanner.nextLine());

        int choice = getGrowthType();

        edu.wctc.strategy.before.BacteriaColony colony = null;

        /**
         * With the template method pattern, we choose which subclass to
         * create. But this cannot be (easily) changed while the program
         * is running.
         *
         * To be more dynamic, we could have prompted the
         * user for the parameters of the different growth strategies (e.g. the
         * growth rate, max population), but they have been hard coded for
         * simplicity.
         */
        switch (choice) {
            case 1:
                colony = new ExponentialColony(population,.2);
                break;
            case 2:
                colony = new LogisticColony(population,.2, 20000);
                break;
            case 3:
                colony = new LinearColony(population,20);
                break;
            case 4:
                colony = new NoGrowthColony(population);
                break;
            case 5:
                System.out.println("Goodbye");
                System.exit(0);
        }

        // Tell the BacteriaColony to grow 10 times using its current strategy
        for (int time = 1; time <= 10; time++) {
            colony.grow();
            System.out.println("Time " + time + ", Population " + colony.getPopulation());
        }

    }


    /**
     * This methods demonstrates how the BacteriaColony's behavior can be
     * swapped out at run time by creating different Strategy objects.
     *
     * To be more dynamic, we could have prompted the
     * user for the parameters of the different growth strategies (e.g. the
     * growth rate, max population), but they have been hard coded for
     * simplicity.
     */
    public static void runAfter() {
        System.out.print("Enter starting population: ");
        long population = Long.parseLong(scanner.nextLine());

        edu.wctc.strategy.after.BacteriaColony colony = new edu.wctc.strategy.after.BacteriaColony(population);

        int choice = 0;
        while (choice != 5) {
            choice = getGrowthType();


            switch (choice) {
                case 1:
                    colony.setGrowthStrategy(new ExponentialGrowth(.2));
                    break;
                case 2:
                    colony.setGrowthStrategy(new LogisticGrowth(.2, 20000));
                    break;
                case 3:
                    colony.setGrowthStrategy(new LinearGrowth(20));
                    break;
                case 4:
                    colony.setGrowthStrategy(new NoGrowth());
                    break;
                case 5:
                    System.out.println("Goodbye");
                    System.exit(0);
            }

            // Tell the BacteriaColony to grow 10 times using its current strategy
            for (int time = 1; time <= 10; time++) {
                colony.grow();
                System.out.println("Time " + time + ", Population " + colony.getPopulation());
            }

        }

    }

    private static int getGrowthType() {
        System.out.println("Choose your growth type");
        System.out.println("1. Exponential Growth");
        System.out.println("2. Logistic Growth");
        System.out.println("3. Linear Growth");
        System.out.println("4. No Growth");
        System.out.println("5. EXIT");
        System.out.print("\n>> ");

        return Integer.parseInt(scanner.nextLine());
    }
}
