package pl.put.poznan.PUTSEBuildingInfo.logic.visitors;

import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;


/**
 * Corresponds to the Visitor interface from the Visitor pattern
 * defines two different implementations of visiting the BuildingComponent objects
 */
public interface Visitor {
    void visitCompositeBuildingComponent(CompositeBuildingComponent compositeBuildingComponent);
    void visitElementaryBuildingComponent(ElementaryBuildingComponent elementaryBuildingComponent);
}
