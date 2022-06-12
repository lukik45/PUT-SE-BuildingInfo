package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.Visitor;

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
     * Calculates the area of the room
     * @param level just a helper variable to pretty print the topology of search
     * @return area of the room
     */
    @Override
    public double checkArea(int level) {

        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " area=" +  area);
        return area;
    }

    /**
     * Calculates the volume of the room
     * @param level just a helper variable to pretty print the topology of search
     * @return volume of the room
     */
    @Override
    public double checkVolume(int level) {
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " volume=" +  cube);
        return cube;
    }

    /**
     * Calculates the average heating power per unit of the volume
     * @param level just a helper variable to pretty print the topology of search
     * @return heating power divided by the volume of the room
     */
    @Override
    public double calculateHeatingEnergy(int level) {
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " heating/volume:" +  heating/cube );
        return heating/cube;
    }

    /**
     * Calculates average light power per unit of the area
     * @param level just a helper variable to pretty print the topology of search
     * @return light power divided by the area of the room
     */
    @Override
    public double calculateLightningPower(int level) {
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " light/area=" +  light/area);
        return light/area;
    }

    /**
     * Invokes the proper implementation of visit method
     * @param v the visitor object
     */
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

    @Override
    public double getHeating(int level) {
        return heating;
    }

    @Override
    public double getLight(int level) {
        return light;
    }


    public double getHeating() {
        return heating;
    }

    public double getLight() {
        return light;
    }
}
