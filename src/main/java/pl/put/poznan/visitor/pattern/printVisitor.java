package pl.put.poznan.visitor.pattern;

import pl.put.poznan.composite.pattern.Composite;
import pl.put.poznan.composite.pattern.Element;
import pl.put.poznan.composite.pattern.Leaf;

/**
 * [work in progress]: Concrete visitor that prints to the console information of the Element
 */
public class printVisitor implements Visitor{
    /**
     * Implementation of the visit method for the leaf - prints fields of the Leaf
     * @param l Instance of the Leaf to be visited
     * @return 0 (value is not important in this example)
     */
    @Override
    public double visit(Leaf l) {
        System.out.println("Room[" + l.getName() + ", " + l.getId() + "]: area:" + l.getArea() + ", cube:" + l.getCube() + ", heating:" + l.getHeating()+ ", light:" + l.getLight());
        return 0.0;
    }

    /**
     * Implementation of the visit method for the Composite - prints fields of the Composite and its children
     * @param c Instance of the Composite to be visited
     * @return 0 (value is not important in this example)
     */
    @Override
    public double visit(Composite c) {
        System.out.println("[" + c.getName() + ", " + c.getId() + "]");
        for(Element e: c.getChildElements()){
            System.out.print("\t");

            e.accept(this);
        }
        return 0.0;
    }
}
