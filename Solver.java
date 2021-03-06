package assignment6;

import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 *
 * @author Pieter Koopman, Sjaak Smetsers
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 * @version 1.4
 * @date 07-03-2016
 */
public class Solver {
    // A queue for maintaining graphs that are not visited yet.
    private final Queue<Node<Configuration>> toExamine;
    private final Collection<Configuration> cache;

    /**
     * Constructor method.
     *
     * @param g a starting configuration
     */
    public Solver(Configuration g) {
        this.toExamine = new PriorityQueue<>();
        this.toExamine.add(new Node<>(null, g));
        this.cache = new HashSet<>();
        this.cache.add(g);
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        while (!this.toExamine.isEmpty()) {
            Node<Configuration> next = this.toExamine.remove();
            if (next.getItem().isSolution()) {
                System.out.println(next);
                return "Success!";
            } else {
                for (Configuration succ : next.getItem().successors()) {
                    if (!this.cache.contains(succ)) {
                        this.toExamine.add(new Node<>(next, succ));
                        this.cache.add(succ);
                    }
                }
            }
        }
        return "Failure!";
    }
}
