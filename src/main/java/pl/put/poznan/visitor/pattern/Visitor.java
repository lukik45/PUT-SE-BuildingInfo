package pl.put.poznan.visitor.pattern;

import pl.put.poznan.composite.pattern.Composite;
import pl.put.poznan.composite.pattern.Leaf;

/**
 * Interface that plays the role of the visitor in the Visitor pattern.
 */
public interface Visitor{
    /**s
     * Function to visit particular Element - Leaf
     * @param l Instance of the Leaf to be visited
     * @return Result of the calculations
     */
    public double visit(Leaf l);
    /**
     * Function to visit particular Element - Composite
     * @param c Instance of the Composite to be visited
     * @return Result of the calculations
     */
    public double visit(Composite c);
}
