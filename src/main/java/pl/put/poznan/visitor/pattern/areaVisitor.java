package pl.put.poznan.visitor.pattern;

import pl.put.poznan.composite.pattern.Composite;
import pl.put.poznan.composite.pattern.Element;
import pl.put.poznan.composite.pattern.Leaf;

/**
 * Concrete visitor, to calculate an area of particular element/s
 */
public class areaVisitor implements Visitor{
    /**
     * Implementation of the visit method for the Leaf - returns an area of the room
     * @param l Instance of the Leaf to be visited
     * @return Result of the calculations
     */
    @Override
    public double visit(Leaf l) {
        return l.getArea();
    }
    /**
     * Implementation of the visit method for the Composite - sum of areas of its childElements
     * @param c Instance of the Composite to be visited
     * @return Result of the calculations
     */
    @Override
    public double visit(Composite c) {
        double s = 0.0;
        for(Element e: c.getChildElements()){
            s += e.accept(this);
        }
        return s;
    }
}
