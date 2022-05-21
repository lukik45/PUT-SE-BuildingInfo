package pl.put.poznan.composite.pattern;

import pl.put.poznan.visitor.pattern.Visitor;

/**
 * Interface for the Composite and Leaf, that plays the role of the component in the composite pattern and visitable in the Visitor pattern.
 */
public interface Element {
    @Override
    /**
     * Better visualization of the fields of the class
     */
    public String toString();
    /**
     * method that accepts the visitor to the instance of the Element
     * @param v instance of visitor class that performs operation
     * @return the result of the performed operation
     */
    public double accept(Visitor v);
}
