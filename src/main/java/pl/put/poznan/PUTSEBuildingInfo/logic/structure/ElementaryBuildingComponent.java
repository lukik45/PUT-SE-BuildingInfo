package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

/**
 * Represents Leaf in Composite design pattern
 * In our case it refers only to the room, since room is the only leaf structure  in our model
 */
public class ElementaryBuildingComponent implements BuildingComponent {

    protected String name;
    protected int id;
    protected float area;
    protected float cube;
    protected float heating;
    protected float light;


    /**
     * Returns the area of the elementary building component
     */
    @Override
    public double checkArea(int level) {

        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " area=" +  area);
        return area;
    }

    @Override
    public double checkVolume(int level) {
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " volume=" +  cube);
        return cube;
    }

    @Override
    public double calculateHeatingEnergy(int level) {
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " heating:" +  heating );
        return heating;
    }

    @Override
    public double calculateLightningPower(int level) {
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " light=" +  light);
        return light;
    }

    @Override
    public void accept(Visitor v) {
        v.visitElementaryBuildingComponent(this);
    }


    @Override
    public String toString() {
        return "ElementaryBuildingComponent{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", area=" + area +
                ", cube=" + cube +
                ", heating=" + heating +
                ", light=" + light +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getArea() {
        return area;
    }

    public float getCube() {
        return cube;
    }

    public float getHeating() {
        return heating;
    }

    public float getLight() {
        return light;
    }
}
