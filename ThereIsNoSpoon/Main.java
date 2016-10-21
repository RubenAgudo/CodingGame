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
            System.err.println(line);
        }

        String right = "";
        String bottom = "";
        String node = "";

        for(int y = 0; y < lines.length; y++) {
            
            for(int x = 0; x < lines[y].length; x++) {
                
                right = "-1 -1";;
                bottom = "-1 -1";;
                node = "";

                boolean nodeFound = false;

                if(lines[y][x].equals("0")) { //if the current position is a node
                    System.err.println("Found node at(" + x + ", " + y +")" ); 
                    node = x + " " + y;
                    nodeFound = true;
                }

                if(nodeFound) {
                    boolean rightFound = false;
                    int rightIndex = x + 1;

                    while(!rightFound && rightIndex < lines[y].length) {

                        if(lines[y][rightIndex].equals("0")) { //if the current position is a node 
                            right = rightIndex + " " + y;
                            System.err.println("Found right at(" + rightIndex + ", " + y +")" ); 
                            rightFound = true;
                        }
                        rightIndex++;
                    }

                    boolean bottomFound = false;
                    int bottomIndex = y + 1;

                    while(!bottomFound && bottomIndex < lines.length) {
                        if(lines[bottomIndex][x].equals("0")) { //if the current position is a node 
                            bottom = x + " " + bottomIndex;
                            System.err.println("Found bottom at(" + x + ", " + bottomIndex +")" ); 
                            bottomFound = true;
                        }
                        bottomIndex++;
                    }
                    System.out.println(node + " " + right + " " + bottom);
                    System.err.println(node + " " + right + " " + bottom);
                }
            }
        }
    }
}