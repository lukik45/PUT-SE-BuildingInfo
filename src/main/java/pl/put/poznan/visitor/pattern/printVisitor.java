package pl.put.poznan.visitor.pattern;

import pl.put.poznan.composite.pattern.Composite;
import pl.put.poznan.composite.pattern.Element;
import pl.put.poznan.composite.pattern.Leaf;

public class printVisitor implements Visitor{

    @Override
    public double visit(Leaf l) {
        System.out.println("Room[" + l.getName() + ", " + l.getId() + "]: area:" + l.getArea() + ", cube:" + l.getCube() + ", heating:" + l.getHeating()+ ", light:" + l.getLight());
        return 0.0;
    }

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
