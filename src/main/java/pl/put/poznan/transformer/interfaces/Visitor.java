package pl.put.poznan.transformer.interfaces;


import pl.put.poznan.transformer.models.Location;

public interface Visitor {
    public void visit(Location location);
}