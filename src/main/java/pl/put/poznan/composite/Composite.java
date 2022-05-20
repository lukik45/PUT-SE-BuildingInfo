package pl.put.poznan.composite;

import java.util.Collections;
import java.util.List;

public class Composite implements Element{

    List<Element> childElements = Collections.emptyList();
    String name;
    Integer id;

    public Composite(String _name, Integer _id) {
        this.name = _name;
        this.id = _id;
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
