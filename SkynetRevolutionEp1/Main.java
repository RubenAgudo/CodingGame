import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> originalLinks = new HashMap<Integer, Integer>();
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();

            originalLinks.put(N1, N2);

            addNode(N1, N2);
            addNode(N2, N1);
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            if(areConnected(EI, SI)) { //We delete the link that connects the gateway and skynet
                severeLink(EI, SI);
                severeLink(SI, EI);

                Integer y = originalLinks.get(EI);

                if(y == null) {
                    System.out.println(EI + " " + y);
                } else {
                    System.out.println(y + " " + EI);
                }

            } else { //We just delete one link
                Set<Integer> links = graph.get(EI);
                Iterator<Integer> iterator = links.iterator();
                if(iterator.hasNext()) {
                    Integer removed = iterator.next().remove();
                    Integer y = originalLinks.get(EI);
                    System.out.println(y + " " + EI);
                }
            }


            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            System.out.println("0 1");
        }
    }

    static void addNode(Integer source, Integer target) {
        List<Integer> nodes = graph.get(source);
        if(nodes == null) {
            nodes = new TreeSet<Integer>();
        }
        graph.put(source, nodes.add(target));
    }

    static boolean areConnected(Integer source, Integer target) {
        List<Integer> nodes = graph.get(source);
        if(nodes == null) {
            nodes = new TreeSet<Integer>();
        }
        return nodes.contains(target);
    }

    static boolean severeLink(Integer source, Integer target) {
        List<Integer> nodes = graph.get(source);
        if(nodes == null) {
            nodes = new TreeSet<Integer>();
        }
        return nodes.remove(target);
    }
}