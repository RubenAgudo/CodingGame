import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526

        if(temps.equals("")) {
            System.out.println("0");
            return;
        }

        String[] tempsList = temps.split(" ");
        Integer closerToZero = Integer.MAX_VALUE;
        Integer closerToZeroInAbsoluteTerms = Integer.MAX_VALUE;

        for(int i = 0; i < tempsList.length; i++) {
            Integer nextValue = Integer.parseInt(tempsList[i]);
            Integer absoluteValue = Math.abs(nextValue);

            if(absoluteValue == closerToZeroInAbsoluteTerms && nextValue > 0) {
                closerToZero = nextValue;
            }

            if(absoluteValue < closerToZeroInAbsoluteTerms) {
                closerToZero = nextValue;
                closerToZeroInAbsoluteTerms = absoluteValue;
            }

        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(closerToZero);
    }
}