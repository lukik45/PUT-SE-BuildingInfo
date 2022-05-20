package pl.put.poznan.composite.pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class Composite implements Element{

    List<Element> childElements;
    String name;
    String id;
    Integer depth;

    public Composite(String _name, String _id, Integer _depth) {
        this.name = _name;
        this.id = _id;
        this.depth = _depth;
        this. childElements = Collections.emptyList();
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

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    @Override
    public String toString(){
        String s = "\t".repeat(this.depth) + "Name: " + this.name;
        s += "\t".repeat(this.depth) + "Id: " + this.id;
        for(Element t: childElements)
            s += t.toString();
        return s;
    }
}
