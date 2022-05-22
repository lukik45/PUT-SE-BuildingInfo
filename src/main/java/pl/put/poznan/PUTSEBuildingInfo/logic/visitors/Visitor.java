package pl.put.poznan.PUTSEBuildingInfo.logic.visitors;

import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;

public interface Visitor {
    void visitCompositeBuildingComponent(CompositeBuildingComponent compositeBuildingComponent);
    void visitElementaryBuildingComponent(ElementaryBuildingComponent elementaryBuildingComponent);
}
