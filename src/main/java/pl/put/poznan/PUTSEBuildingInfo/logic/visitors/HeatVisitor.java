package pl.put.poznan.PUTSEBuildingInfo.logic.visitors;

import pl.put.poznan.PUTSEBuildingInfo.logic.structure.BuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;

import java.util.ArrayList;

public class HeatVisitor implements Visitor{
    double threshold;
    ArrayList<ElementaryBuildingComponent> roomsThatViolate;

    public HeatVisitor(double threshold) {
        this.threshold = threshold;
        this.roomsThatViolate = new ArrayList<>();
    }

    @Override
    public void visitCompositeBuildingComponent(CompositeBuildingComponent compositeBuildingComponent) {
        for (BuildingComponent child :
                compositeBuildingComponent.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visitElementaryBuildingComponent(ElementaryBuildingComponent elementaryBuildingComponent) {
        System.out.println(threshold + " " + elementaryBuildingComponent.getHeating());
        if (elementaryBuildingComponent.getHeating() > threshold) {

            roomsThatViolate.add(elementaryBuildingComponent);
        }
    }

    public ArrayList<ElementaryBuildingComponent> getRoomsThatViolate() {
        return roomsThatViolate;
    }
}
