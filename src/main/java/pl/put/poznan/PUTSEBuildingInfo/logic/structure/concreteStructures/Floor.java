package pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.BuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures.Room;

import java.util.ArrayList;




/**
 * Class used by {@link Building#Building(java.lang.String, int, java.util.ArrayList)}
 * Required to properly parse JSON input from POST request
 */
public class Floor extends CompositeBuildingComponent {

    Floor (
            @JsonProperty("name") String name,
            @JsonProperty("id") int id,
            @JsonProperty("children") ArrayList<Room> children) {
        this.name = name;
        this.id = id;
        ArrayList<BuildingComponent> children2 = new ArrayList<>();
        for (Room childR :
                children) {
            children2.add(childR);
        }
        this.children =  children2;
    }

}
