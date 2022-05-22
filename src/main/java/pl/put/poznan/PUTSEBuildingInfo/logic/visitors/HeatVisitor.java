package pl.put.poznan.PUTSEBuildingInfo.logic.visitors;

import pl.put.poznan.PUTSEBuildingInfo.logic.structure.BuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;

import java.util.ArrayList;


/**
 * Used to get the information about rooms in the building that exceed a certain level of
 * heat consumption / m^3 given as a parameter to find places for improvement in the infrastructure
 *
 * Implements two versions of looking for information, tailored for different Component classes
 */


public class HeatVisitor implements Visitor{
    double threshold;
    ArrayList<ElementaryBuildingComponent> roomsThatViolate;

    /**
     *
     * @param threshold defined in GET request - specifies the maximal level of heat/volume that is allowed
     */
    public HeatVisitor(double threshold) {
        this.threshold = threshold;
        this.roomsThatViolate = new ArrayList<>();
    }

    /**
     * Method specifying the behaviour of visiting the Composite Building Component
     * @param compositeBuildingComponent the object to visit
     */
    @Override
    public void visitCompositeBuildingComponent(CompositeBuildingComponent compositeBuildingComponent) {
        for (BuildingComponent child :
                compositeBuildingComponent.getChildren()) {
            child.accept(this);
        }
    }
    /**
     * Method specifying the behaviour of visiting the Elementary Building Component
     * Adds rooms that exceed the maximal level of heat consumption to a list
     * @param elementaryBuildingComponent the object to visit
     */
    @Override
    public void visitElementaryBuildingComponent(ElementaryBuildingComponent elementaryBuildingComponent) {
        System.out.println(threshold + " " + elementaryBuildingComponent.getHeating());
        if (elementaryBuildingComponent.getHeating() / elementaryBuildingComponent.getCube() > threshold) {

            roomsThatViolate.add(elementaryBuildingComponent);
        }
    }

    /**
     * @return a list of rooms that exceed the maximal level of heat consumption
     */
    public ArrayList<ElementaryBuildingComponent> getRoomsThatViolate() {
        return roomsThatViolate;
    }
}
