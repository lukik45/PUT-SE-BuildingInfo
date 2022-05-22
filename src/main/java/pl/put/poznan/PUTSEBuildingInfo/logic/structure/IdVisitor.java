package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

public class IdVisitor implements Visitor {
    int searchedId;
    BuildingComponent foundBuildingComponent;

    public IdVisitor(int searchedId) {
        this.searchedId = searchedId;
        this.foundBuildingComponent = null;
    }

    public void visitCompositeBuildingComponent(CompositeBuildingComponent cbc) {
        if (cbc.getId() == searchedId){
            foundBuildingComponent = cbc;
            return;
        } else {
            for (BuildingComponent child :
                    cbc.getChildren()) {
                child.accept(this);
                if (foundBuildingComponent != null) {
                    return;
                }
            }
        }
    }

    public void visitElementaryBuildingComponent(ElementaryBuildingComponent ebc) {
        if (ebc.getId() == searchedId) {
            foundBuildingComponent = ebc;
        }
    }

    public BuildingComponent getFoundBuildingComponent() {
        return foundBuildingComponent;
    }
}
