package com.synclab.internship.test.factorial.utils;

import org.springframework.boot.ApplicationArguments;

public class ArgsParser {

    private static int MAX_TO_FACTORIAL = 100000;

    public static boolean check(ApplicationArguments args) {

        if ( (args.getNonOptionArgs().size() < 1) ||
                (!args.getNonOptionArgs().get(0).matches("[0-9]*")
                && !args.getNonOptionArgs().get(1).matches("[0-9]*")) ) {

            System.out.println("Please input the number of concurrent requests and an integer number.");
            return false;
        }

        return true;
    }

    public static int getRequestNumber(ApplicationArguments args) {
        int requestNumber = Integer.parseInt(args.getNonOptionArgs().get(0));
        if (requestNumber < 1) {
            requestNumber = 1;
        }

        return requestNumber;
    }

    public static int getNumberToFactorial(ApplicationArguments args) {

        int toFactorial = Integer.parseInt(args.getNonOptionArgs().get(1));
        if (toFactorial > MAX_TO_FACTORIAL) {
            System.out.println("Using max number to factorize (" + MAX_TO_FACTORIAL + ")");
            toFactorial = MAX_TO_FACTORIAL;
        }

        return  toFactorial;
    }
}
