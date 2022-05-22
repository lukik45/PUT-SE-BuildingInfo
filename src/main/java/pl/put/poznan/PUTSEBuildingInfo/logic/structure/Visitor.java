package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

public interface Visitor {
    void visitCompositeBuildingComponent(CompositeBuildingComponent compositeBuildingComponent);
    void visitElementaryBuildingComponent(ElementaryBuildingComponent elementaryBuildingComponent);
}
