package org.lin.sample;


import org.lin.sample.interfaces.IFactory;
import org.lin.sample.interfaces.IHandler;
import util.Utility;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String welcome  = "***********************************" + "\n"+
                "***Welcome to CandyCrunsh GAME ***" + "\n" +
                "**********************************" + "\n\n";
        System.out.println(welcome);

        System.out.println("Please choose your options: \n" + "1. Remove duplicated character directly. \n" +
                "2. remove duplicated character with the one comes before it alphabetically.\n" +
                "Please type '1' or '2', then press 'ENTER' \n");

        //capture the game options from user input
        Scanner sc = new Scanner(System.in);
        String inputOpt = "1";
        while (true) {
            inputOpt = sc.nextLine();
            if (inputOpt.equals("1") || inputOpt.equals("2")) {
                break;
            } else {
                System.out.printf("Your input is invalid! Please type the correct Option from '1' or '2'. \n");
            }
        }
        System.out.println("The Option you choose is:" + inputOpt);

        //capture the level of duplication
        System.out.println("Please choose the threshold that AT LEAST how many duplicate characters to remove." +
                "The default value is 3.\n");
        String DupCnt = "3";
        while (true) {
            DupCnt = sc.nextLine();
            if (DupCnt.isEmpty() || DupCnt.matches("^[0-9]]*$")) {
                break;
            } else {
                System.out.printf("Your input is invalid! Please type the correct Option which should be Integer \n");
            }
        }
        System.out.println("The Duplication count you choose is: " + DupCnt);

        //read input file from args[] as the input string
        if (args.length > 0) {
            String inputStr = Utility.readInputFromFile(args[0]);
            if (inputStr != null) {

                IHandler handler = createCandyCrushHandler(inputOpt);
                String output = handler.handle(inputStr, Integer.parseInt(DupCnt));
                System.out.println(output);
            }
        } else {
            System.out.println("Please provide the Input file as param");
        }
    }

    /**
     * This function is used for creating game handlers according to the option from user input
     * @param inputOpt the option from user input
     * @return  the instance of handler created by handler factory
     */
    private static IHandler createCandyCrushHandler (String inputOpt) {
        IFactory factory = null;
        IHandler handler = null;
        if (inputOpt.equals(String.valueOf(2)))
            factory = new ReplacementFactory();
        else
            factory = new DeduplicationFactory();
        return factory.createHandler();
    }
}