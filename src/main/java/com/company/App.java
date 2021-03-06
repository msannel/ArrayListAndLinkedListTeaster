package com.company;

import java.util.*;

/**
 * @author Anna Ivanova
 */
public class App {
    /**
     * Class of test results
     */
    public static class Results {

        long timeArr, timeLink;
        String method;

        /**
         * @param timeArr  time of test ArrayList
         * @param timeLink time of test LinkedList
         * @param method   Description of tested method
         * @see ListsTester
         */
        public Results(long timeArr, long timeLink, String method) {
            this.timeArr = timeArr;
            this.timeLink = timeLink;
            this.method = method;
        }
    }

    public static void main(String[] args) {

        int NumberOfTests = getNumberOfTestsFromConsole();
        while (NumberOfTests != 0) {
            ListsTester testArrayList = new ListsTester(new ArrayList<>(), NumberOfTests, "0");
            ListsTester testLinkedList = new ListsTester(new LinkedList<>(), NumberOfTests, "0");

            List<Results> ResultsOfTests = new ArrayList<>();

            ResultsOfTests.add(new Results(testArrayList.testAdd(), testLinkedList.testAdd(), "Add to the end"));
            ResultsOfTests.add(new Results(testArrayList.testAdd(0), testLinkedList.testAdd(0), "Add to the begin"));
            ResultsOfTests.add(new Results(testArrayList.testAddMiddle(), testLinkedList.testAddMiddle(), "Add to the middle"));

            ResultsOfTests.add(new Results(testArrayList.testGetByIndex(NumberOfTests - 1), testLinkedList.testGetByIndex(NumberOfTests - 1), "Get from the end"));
            ResultsOfTests.add(new Results(testArrayList.testGetByIndex(0), testLinkedList.testGetByIndex(0), "Get from the begin"));
            ResultsOfTests.add(new Results(testArrayList.testGetMiddle(), testLinkedList.testGetMiddle(), "Get from the middle"));

            ResultsOfTests.add(new Results(testArrayList.testRemove(), testLinkedList.testRemove(), "Remove from the end"));
            ResultsOfTests.add(new Results(testArrayList.testRemove(0), testLinkedList.testRemove(0), "Remove from the begin"));
            ResultsOfTests.add(new Results(testArrayList.testRemoveMiddle(), testLinkedList.testRemoveMiddle(), "Remove from the middle"));

            System.out.format("%22s%20s%20s\n", "Method", "ArrayList time", "LinkedList time");
            char comparison;
            for (int i = 0; i < ResultsOfTests.size(); i++) {
                if (ResultsOfTests.get(i).timeArr > ResultsOfTests.get(i).timeLink)
                    comparison = '>';
                else if (ResultsOfTests.get(i).timeArr < ResultsOfTests.get(i).timeLink)
                    comparison = '<';
                else comparison = '=';
                System.out.format("%22s%20d%3c%6d\n", ResultsOfTests.get(i).method, ResultsOfTests.get(i).timeArr, comparison, ResultsOfTests.get(i).timeLink);
            }
            System.out.println('\n');
            NumberOfTests = getNumberOfTestsFromConsole();
        }
        System.out.println("Goodbye!");
    }

    /**
     * Read the number of tests from console
     * @return read number
     */
    private static int getNumberOfTestsFromConsole()
    {
        System.out.println("Enter number of tests (for exit print 0)");
        String _NumberOfTests = new Scanner(System.in).nextLine();
        while (!checkNumberOfTests(_NumberOfTests))
        {
            System.out.println("Syntax error!\nPlease enter number of tests again (for exit print 0)");
            _NumberOfTests = new Scanner(System.in).nextLine();
        }
        return Integer.parseInt(_NumberOfTests);
    }

    /**
     * Check if the number is correctly inputted by user
     * @param _NumberOfTests checked string
     * @return if the number is inputted correctly
     */
    private static Boolean checkNumberOfTests(String _NumberOfTests)
    {
        if (_NumberOfTests.charAt(0) == '0' && _NumberOfTests.length() > 1) return false;
        for (int i = 0; i < _NumberOfTests.length(); i++)
        {
            if (!(_NumberOfTests.charAt(i) >= '0' && _NumberOfTests.charAt(i) <= '9')) return false;
        }
        return true;
    }
}