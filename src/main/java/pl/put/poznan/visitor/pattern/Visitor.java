package pl.put.poznan.visitor.pattern;

import pl.put.poznan.composite.pattern.Composite;
import pl.put.poznan.composite.pattern.Leaf;

public interface Visitor<T>{
    public double visit(Leaf l);
    public double visit(Composite c);
}
