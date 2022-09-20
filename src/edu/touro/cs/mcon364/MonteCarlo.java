package edu.touro.cs.mcon364;

import java.util.*;

public class MonteCarlo {
    private static final int NUM_ITERATIONS = 10_000;

    /**
     * Calculates the number of duplicates in a list - that is, the number of elements which cannot fit in a set because
     * an equivalent is already held.
     * <p>
     * For example, if the list contains {@code {1,1,2,3}}, the set will contain {@code {1,2,3}}. That means that
     * (4 - 3 = ) one person has the same birthday as someone else - two people share a birthday.
     *
     * @param list a list of birthdays
     * @return the number of elements in the list that are duplicates
     */
    public static int numberOfDuplicates(List<Integer> list) {
        return list.size() - new HashSet<>(list).size();
    }

    /**
     * Calculates whether a list of birthdays contains at least one birthday shared between two people.
     *
     * @param list a list of birthdays
     * @return whether the list contains at least one shared birthday
     */
    public static boolean containsSharedBirthday(List<Integer> list) {
        return numberOfDuplicates(list) > 0;
    }

    /**
     * Generates the given number of random birthdays.
     *
     * @param numBirthdays the number of birthdays to create
     * @return a list of random birthdays
     */
    private static List<Integer> generateRandomBirthdays(int numBirthdays) {
        Random rand = new Random();
        List<Integer> birthdays = new ArrayList<>(numBirthdays);

        for (int i = 0; i < numBirthdays; i++) {
            birthdays.add(rand.nextInt(365)); // 0-364 is 365 possible options
        }
        return birthdays;
    }


    /**
     * Creates a list of random birthdays of the given size {@link MonteCarlo#NUM_ITERATIONS} times, and calculates the
     * percentage of the time in which the given number of birthdays will contain at least one duplicate.
     *
     * @param numBirthdays the number of birthdays to test with
     * @return the percentage of time there are duplicate birthdays
     */
    public static double monteCarlo(int numBirthdays) {
        int totalTimesBirthdayIsShared = 0;

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            totalTimesBirthdayIsShared += containsSharedBirthday(generateRandomBirthdays(numBirthdays)) ? 1 : 0;
        }

        return ((double) totalTimesBirthdayIsShared) / NUM_ITERATIONS;
    }
}
