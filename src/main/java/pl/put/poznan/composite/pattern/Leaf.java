package pl.put.poznan.composite.pattern;

public class Leaf implements Element {

    private String name;
    private String id;
    private float area;
    private float cube;
    private float heating;
    private float light;

    public Leaf(String _name, String _id, String _area, String _cube, String _heating, String _light){
        this.name = _name;
        this.id = _id;
        this.area = Float.parseFloat(_area);
        this.cube = Float.parseFloat(_cube);
        this.heating = Float.parseFloat(_heating);
        this.light = Float.parseFloat(_light);
    }

    @Override
    public void printElement() {
        System.out.println("Name: " + this.name);
        System.out.println("Id: " + this.id);
        System.out.println("Area: " + this.area);
        System.out.println("Cube: " + this.cube);
        System.out.println("Heating: " + this.heating);
        System.out.println("Light: " + this.light);
    }
}
