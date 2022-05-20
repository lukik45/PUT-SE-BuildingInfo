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

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getCube() {
        return cube;
    }

    public void setCube(float cube) {
        this.cube = cube;
    }

    public float getHeating() {
        return heating;
    }

    public void setHeating(float heating) {
        this.heating = heating;
    }

    public float getLight() {
        return light;
    }

    public void setLight(float light) {
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
}
