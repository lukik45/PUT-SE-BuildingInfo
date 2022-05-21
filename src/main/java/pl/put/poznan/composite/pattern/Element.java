package pl.put.poznan.composite.pattern;

import pl.put.poznan.visitor.pattern.Visitor;

public interface Element {
    @Override
    public String toString();
    public double accept(Visitor v);

}
