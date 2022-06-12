package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.Visitor;

import java.util.ArrayList;
/**
 * Represents Composite in Composite design pattern, implements several methods for calculations
 * In our case it refers only to the building and floor, since they are the only structures in our model
 */
public class CompositeBuildingComponent implements BuildingComponent {

    protected String name;
    protected int id;
    protected ArrayList<BuildingComponent> children;
    protected ArrayList<Integer> childrenInts;

    /**
     * Calculates the sum of areas of all the children in the component
     * @param level just a helper variable to pretty print the topology of search
     * @return sum of areas power of all the children of this component
     */
    @Override
    public double checkArea(int level) {
        double totalArea = 0.0;
        for (BuildingComponent child : children) {
            totalArea += child.checkArea(level+1);
        }
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " area=" + totalArea);
        return totalArea;
    }
    /**
     * Calculates the sum of volumes of all the children in the component
     * @param level just a helper variable to pretty print the topology of search
     * @return sum of volumes of all the children of this component
     */
    @Override
    public double checkVolume(int level) {
        double totalVolume = 0.0;
        for (BuildingComponent child : children) {
            totalVolume += child.checkVolume(level+1);
        }
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " volume=" + totalVolume);
        return totalVolume;
    }
    /**
     * Calculates the average heating power per unit of the volume in the whole component
     * @param level just a helper variable to pretty print the topology of search
     * @return sum of heating power of all children divided by sum of all the volumes
     */
    @Override
    public double calculateHeatingEnergy(int level) {
        double totalHeating = 0.0;
        double totalVolume = 0.0;
        for (BuildingComponent child : children) {
            totalHeating += child.getHeating(level+1);
        }
        for (BuildingComponent child : children) {
            totalVolume += child.checkVolume(level+1);
        }
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " energy/volume=" + totalHeating/totalVolume);
        return totalHeating/totalVolume;
    }
    /**
     * Calculates average light power per unit of the area in the whole component
     * @param level just a helper variable to pretty print the topology of search
     * @return sum of light power, divided by the total area of children
     */
    @Override
    public double calculateLightningPower(int level) {
        double totalLight = 0.0;
        double totalArea = 0.0;
        for (BuildingComponent child : children) {
            totalLight += child.getLight(level+1);
        }
        for (BuildingComponent child : children) {
            totalArea += child.checkArea(level+1);
        }
        String tab = "\t";
        System.out.println(tab.repeat(level) +  name + " light/area=" + totalLight/totalArea);
        return totalLight/totalArea;
    }

    /**
     * Calculates the sum of heating powers of all the children in the component
     * @param level just a helper variable to pretty print the topology of search
     * @return sum of heating powers of all the children of this component
     */
    @Override
    public double getHeating(int level){
        double totalHeating = 0.0;
        for (BuildingComponent child : children) {
            totalHeating += child.getHeating(level+1);
        }
        return totalHeating;
    }

    /**
     * Calculates the sum of light powers of all the children in the component
     * @param level just a helper variable to pretty print the topology of search
     * @return sum of light powers of all the children of this component
     */
    @Override
    public double getLight(int level){
        double totalLight = 0.0;
        for (BuildingComponent child : children) {
            totalLight += child.getLight(level+1);
        }
        return totalLight;
    }

    @Override
    public String toString() {
        return "CompositeBuildingComponent{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", children=" + children +
                '}';
    }

    /**
     * Invokes the proper implementation of visit method
     * @param v the visitor object
     */
    public void accept(Visitor v) {
        v.visitCompositeBuildingComponent(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<BuildingComponent> getChildren() {
        return children;
    }

}
