import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    private static Map<Integer, Set<Integer>> graph;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        graph = new HashMap<Integer, Set<Integer>>();

        Set<Integer> gateways = new TreeSet<Integer>();

        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();

            addNode(N1, N2);
            addNode(N2, N1);
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gateways.add(EI);
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            Set<Integer> intersection = new TreeSet<Integer>(graph.get(SI));
            intersection.retainAll(gateways);
            
            if(!intersection.isEmpty()) { //it will always have just one element
                Iterator<Integer> iterator = intersection.iterator();
                Integer gatewayToProtect = iterator.next();

                severeLink(gatewayToProtect, SI);
                severeLink(SI, gatewayToProtect);

                System.out.println(gatewayToProtect + " " + SI);
            } else { //We just delete one link
                boolean removedNode = false;

                Iterator<Integer> gatewaysIterator = gateways.iterator();

                while(!removedNode && gatewaysIterator.hasNext()) {
                    Integer EI = gatewaysIterator.next();

                    Set<Integer> links = graph.get(EI);
                    Iterator<Integer> iterator = links.iterator();
                    if(!removedNode && iterator.hasNext()) {
                        removedNode = true;
                        Integer removed = iterator.next();
                        iterator.remove();
                        System.out.println(removed + " " + EI);
                    }
                }
            }
        }
    }

    static void addNode(Integer source, Integer target) {
        Set<Integer> nodes = graph.get(source);
        if(nodes == null) {
            nodes = new TreeSet<Integer>();
        }
        nodes.add(target);
        graph.put(source, nodes);
    }

    static boolean areConnected(Integer source, Integer target) {
        Set<Integer> nodes = graph.get(source);
        if(nodes == null) {
            nodes = new TreeSet<Integer>();
        }
        return nodes.contains(target);
    }

    static boolean severeLink(Integer source, Integer target) {
        Set<Integer> nodes = graph.get(source);
        if(nodes == null) {
            nodes = new TreeSet<Integer>();
        }
        return nodes.remove(target);
    }
}