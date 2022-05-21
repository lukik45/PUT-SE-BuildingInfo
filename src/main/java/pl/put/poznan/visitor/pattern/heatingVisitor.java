package pl.put.poznan.visitor.pattern;

import pl.put.poznan.composite.pattern.Composite;
import pl.put.poznan.composite.pattern.Element;
import pl.put.poznan.composite.pattern.Leaf;

public class heatingVisitor implements Visitor{

    @Override
    public double visit(Leaf l) {
        return l.getHeating();
    }

    @Override
    public double visit(Composite c) {
        double s = 0.0;
        for(Element e: c.getChildElements()){
            s += e.accept(this);
        }
        return s;
    }
}
