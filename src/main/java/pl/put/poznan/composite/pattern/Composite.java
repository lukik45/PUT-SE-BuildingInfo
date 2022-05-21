package pl.put.poznan.composite.pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.visitor.pattern.Visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that implements the composite part of the composite pattern.
 * It stores a list of other Leaves/Composites.
 */
public class Composite implements Element{

    List<Element> childElements = new ArrayList<Element>();
    String name;
    String id;

    public Composite(){};

    /**
     *
     * @param _name Name of the element of the structure
     * @param _id Id of the element of the structure
     * @param _childElements List of other elements (Leaves/Composites) that are in child relation to this instance
     */
    public Composite(String _name, String _id, List<Element> _childElements) {
        super();
        this.name = _name;
        this.id = _id;
        this. childElements = _childElements;
    }

    /**
     * Add another element to this composite.
     * @param E Element to be added
     */
    public void add(Element E){
        childElements.add(E);
    }

    /**
     * Remove an element from this composite.
     * @param E Element to be removed
     */
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

    /**
     * A little bit better visualization of the composite
     * @return String which contains all the fields of the composite and Strings of its children.
     */
    @Override
    public String toString(){
        String s = "\t" + "Name: " + this.name;
        s += "\t" + "Id: " + this.id;
        for(Element t: childElements)
            s += t.toString();
        return s;
    }

    /**
     * Method that accepts the visitor to the instance of the Composite
     * @param v instance of visitor class that performs operation
     * @return the result of the performed operation
     */
    @Override
    public double accept(Visitor v) {
        return v.visit(this);
    }
}
