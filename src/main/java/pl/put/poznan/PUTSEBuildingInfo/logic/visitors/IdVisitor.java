package pl.put.poznan.PUTSEBuildingInfo.logic.visitors;

import pl.put.poznan.PUTSEBuildingInfo.logic.structure.BuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.Visitor;

/**
 * Class used to traverse the structure of the building in order to find the component with a given ID
 */
public class IdVisitor implements Visitor {
    int searchedId;
    BuildingComponent foundBuildingComponent;

    /**
     * Constructor of the visitor
     * @param searchedId id of the searched component
     */
    public IdVisitor(int searchedId) {
        this.searchedId = searchedId;
        this.foundBuildingComponent = null;
    }

    /**
     * Implementation of the visit method, if visitor visits the CompositeBuildingComponent
     * @param cbc visited CompositeBuildingComponent
     */
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
    /**
     * Implementation of the visit method, if visitor visits the ElementaryBuildingComponent
     * @param ebc visited ElementaryBuildingComponent
     */
    public void visitElementaryBuildingComponent(ElementaryBuildingComponent ebc) {
        if (ebc.getId() == searchedId) {
            foundBuildingComponent = ebc;
        }
    }

    public BuildingComponent getFoundBuildingComponent() {
        return foundBuildingComponent;
    }
}
