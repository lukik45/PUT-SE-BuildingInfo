package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.Visitor;

import java.util.ArrayList;

public class CompositeBuildingComponent implements BuildingComponent {

    protected String name;
    protected int id;
    protected ArrayList<BuildingComponent> children;
    protected ArrayList<Integer> childrenInts;


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

    @Override
    public double getHeating(int level){
        double totalHeating = 0.0;
        for (BuildingComponent child : children) {
            totalHeating += child.getHeating(level+1);
        }
        return totalHeating;
    }


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


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<BuildingComponent> getChildren() {
        return children;
    }

    public void accept(Visitor v) {
        v.visitCompositeBuildingComponent(this);
    }
}
