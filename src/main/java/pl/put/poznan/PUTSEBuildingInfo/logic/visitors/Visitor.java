package pl.put.poznan.PUTSEBuildingInfo.logic.visitors;

import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;


/**
 * Corresponds to the Visitor interface from the Visitor pattern
 * defines two different implementations of visiting the BuildingComponent objects
 */
public interface Visitor {
    /**
     * Visiting method, regarding compositeBuildingComponent
     * @param compositeBuildingComponent component that is being visited
     */
    void visitCompositeBuildingComponent(CompositeBuildingComponent compositeBuildingComponent);

    /**
     * Visiting method, regarding elementaryBuildingComponent
     * @param elementaryBuildingComponent elementary component that is being visited
     */
    void visitElementaryBuildingComponent(ElementaryBuildingComponent elementaryBuildingComponent);
}
