package main.java.fr.mickael.views.contracts;


import main.java.fr.mickael.views.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Scanner;

public class GameChoice implements View {

    private static Logger logger = LogManager.getLogger();

    @Override
    public void display() {
        System.out.println("\n" + String.join("*", Collections.nCopies(40, "*"))
                + "\n\nCHOOSE YOUR GAME :\n\n"
                + "\t1/\tMORE OR LESS\n"
                + "\t2/\tMASTERMIND\n\n"
                + "Your answer : \r\n");

    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String firstChoice = "";
        boolean isValid = false;
        while (isValid != true) {
            try {
                String response = scanner.nextLine();
                switch (response) {
                    case "1":
                        firstChoice = "1";
                        isValid = true;
                        break;
                    case "2":
                        firstChoice = "2";
                        isValid = true;
                        break;
                }

            } catch (Exception e) {
                logger.warn("A exception occurred in the method getInput() of the class"
                        + getClass().getSimpleName()
                        + e.getMessage());
            }
            if(!isValid) {
                System.out.println("Please, choose between 1/ or 2/\n");
                display();
            }
        }
        //scanner.close();
        return firstChoice;
    }
}
