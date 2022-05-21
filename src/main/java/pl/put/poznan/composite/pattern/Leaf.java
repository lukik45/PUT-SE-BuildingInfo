package pl.put.poznan.composite.pattern;

import pl.put.poznan.visitor.pattern.Visitor;

public class Leaf implements Element {

    private String name;
    private String id;
    private double area;
    private double cube;
    private double heating;
    private double light;

    public Leaf(){};
    public Leaf(String _name, String _id, String _area, String _cube, String _heating, String _light){
        this.name = _name;
        this.id = _id;
        this.area = Double.parseDouble(_area);
        this.cube = Double.parseDouble(_cube);
        this.heating = Double.parseDouble(_heating);
        this.light = Double.parseDouble(_light);
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCube() {
        return cube;
    }

    public void setCube(double cube) {
        this.cube = cube;
    }

    public double getHeating() {
        return heating;
    }

    public void setHeating(double heating) {
        this.heating = heating;
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    @Override
    public String toString(){
        String s = "name: " + this.name;
        s += "id: " + this.id;
        s += "area: " + this.area;
        s += "cube: " + this.cube;
        s += "heating: " + this.heating;
        s += "light: " + this.light;
        return s;
    }

    @Override
    public double accept(Visitor v) {
        return v.visit(this);
    }
}
