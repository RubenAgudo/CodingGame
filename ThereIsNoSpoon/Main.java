import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        
        System.err.println(width);
        System.err.println(height);

        String[][] lines = new String[height][width];

        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            lines[i] = line.split("");
        }

        String right = "";
        String bottom = "";
        String node = "";

        for(int column = 0; column < lines[0].length; column++) {
            
            for(int row = 0; row < lines.length; column++) {
                
                if(lines[row][column].equals("0")) { //if the current position is a node
                    System.err.println("Found node at(" + row + ", " + column +")" ); 
                    node = row + " " + column;
                }

                for(int rightIndex = column + 1; rightIndex < lines[row].length; rightIndex++) {

                    if(lines[row][rightIndex].equals("0")) { //if the current position is a node 
                        right = row + " " + rightIndex;
                        System.err.println("Found right at(" + row + ", " + rightIndex +")" ); 
                        break; //Substitute for a while
                    }
                }

                if(right.equals("")) {
                    right = "-1 -1";
                }

                for(int bottomIndex = row + 1; bottomIndex < lines.length; bottomIndex++) {
                    if(lines[bottomIndex][column].equals("0")) { //if the current position is a node 
                        bottom = bottomIndex + " " + column;
                        System.err.println("Found bottom at(" + bottomIndex + ", " + column +")" ); 
                        break; //Substitute for a while
                    }
                }

                if(bottom.equals("")) {
                    bottom = "-1 -1";
                }
                
                System.out.println(node + " " + right + " " + bottom);
                right = "";
                bottom = "";
                node = "";
            }
        }
    }
}