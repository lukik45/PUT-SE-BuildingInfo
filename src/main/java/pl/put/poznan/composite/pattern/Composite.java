package pl.put.poznan.composite.pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.visitor.pattern.Visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite implements Element{

    List<Element> childElements = new ArrayList<Element>();
    String name;
    String id;

    public Composite(){};
    public Composite(String _name, String _id, List<Element> _childElements) {
        super();
        this.name = _name;
        this.id = _id;
        this. childElements = _childElements;
    }

    public void add(Element E){
        childElements.add(E);
    }

    public void remove(Element E){
        childElements.remove(E);
    }

    public List<Element> getChildElements() {
        return childElements;
    }

    public void setChildElements(List<Element> childElements) {
        this.childElements = childElements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString(){
        String s = "\t" + "Name: " + this.name;
        s += "\t" + "Id: " + this.id;
        for(Element t: childElements)
            s += t.toString();
        return s;
    }
    @Override
    public double accept(Visitor v) {
        return v.visit(this);
    }
}
