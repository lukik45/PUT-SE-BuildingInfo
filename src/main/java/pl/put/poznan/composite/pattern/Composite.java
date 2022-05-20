package pl.put.poznan.composite.pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class Composite implements Element{

    List<Element> childElements;
    String name;
    String id;

    public Composite(String _name, String _id) {
        this.name = _name;
        this.id = _id;
        this. childElements = Collections.emptyList();
    }

    public void add(Element E){
        childElements.add(E);
    }

    public void remove(Element E){
        childElements.remove(E);
    }

    @Override
    public void printElement() {
        System.out.println("------Name: " + this.name);
        System.out.println("------Id: " + this.id);
        childElements.forEach(Element::printElement);
    }
}
