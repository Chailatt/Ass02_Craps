import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        int rndBirthMonthOff = rnd.nextInt(12);  // generates a random value from 0 – 11
        int rndBirthMonth = rnd.nextInt(12) + 1; // What we want: 1 -12 so we shift it by adding 1

        int dieOff = rnd.nextInt(6);  // generates a random int between 0 and 5
        int die = rnd.nextInt(6) + 1; // generates a random int between 1 and 6 what we want for dice
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int crapsRoll = die1 + die2; // Gaussian range from 2 to 12 as in rolling two dice

        String ng;
        String ReTry = "";
        String trash = "";
        int nD = 0;
        boolean t = false;

        boolean proper = false;
        boolean m = false;

        do {
            //Welcomes player to the game
            System.out.println("May the game of Craps begin!");


            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2;
            System.out.println("You rolled a " + die1 + " and a " + die2 + ".");

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! " + "You rolled " + crapsRoll + " Game Over! :(");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural!" + " you rolled " + crapsRoll + " Congrats! You Win!");
            }

            else
            { nD = crapsRoll;
                System.out.println("You rolled a total of " + nD);

                do {
                    die1 = rnd.nextInt(6) + 1; // generates a random int between 1 and 6 what we want for dice
                    die2 = rnd.nextInt(6) + 1; // generates a random int between 1 and 6 what we want for dice

                    crapsRoll = die1 + die2;

                    System.out.println("dice 1 rolled: " + die1 + " and, dice2 rolled: " + die2 +
                            " \n \"Your craps roll: " + crapsRoll);
                    if (crapsRoll == 7) {
                        System.out.println("Game over you! You lost!");
                        m = true;
                    } else if (crapsRoll == nD)
                    { System.out.println("You win, Game Over!");
                        m = true;
                    }
                    else
                    {
                        System.out.print("Point Sum not reached, Enter any character to roll again... ");
                        scan.nextLine();
                    }
                } while (!m);
            }
            //prompts user to re-play the game
            do {
                System.out.print("Type Yes or no if you wish to play again! [ Y/N ]: ");
                ReTry = scan.nextLine();
                if (ReTry.equalsIgnoreCase("Y")) {
                    proper = true;
                    t = false;
                } else if (ReTry.equalsIgnoreCase("N"))
                { proper = true;
                    t = true;
                }
                else { System.out.println("You fat-fingered and typed:, " + ReTry);
                }
            } while (!proper);
            proper = false;
            m = false;
        } while (!t);

    }
}