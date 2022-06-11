package pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.BuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures.Floor;

import java.util.ArrayList;

/**
 * Class used by {@link pl.put.poznan.PUTSEBuildingInfo.RESTapi.BuildingController#checkAreaGivenId(int)}
 * Required to properly parse JSON input from POST request
 */
public class Building extends CompositeBuildingComponent {

    public Building(
            @JsonProperty("name") String name,
            @JsonProperty("id") int id,
            @JsonProperty("children") ArrayList<Floor> children) {
        this.name = name;
        this.id = id;
        ArrayList<BuildingComponent> children2 = new ArrayList<>();
        for (Floor childF :
                children) {
            children2.add(childF);
        }
        this.children =  children2;
    }
}
