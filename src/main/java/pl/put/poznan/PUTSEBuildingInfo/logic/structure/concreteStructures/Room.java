package pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;


import java.util.ArrayList;

/**
 * Class used by {@link Floor#Floor(java.lang.String, int, java.util.ArrayList)}
 * Required to properly parse JSON input from POST request
 */
public class Room extends ElementaryBuildingComponent {

    /**
     * Constructor of the Room
     * @param name name of the room
     * @param id id of the room
     * @param area area of the room
     * @param cube volume of the room
     * @param heating heating power, required to heat this room
     * @param light light power, required to light this room
     */
    public Room(
            @JsonProperty("name") String name,
            @JsonProperty("id") int id,
            @JsonProperty("area") float area,
            @JsonProperty("cube") float cube,
            @JsonProperty("heating") float heating,
            @JsonProperty("light") float light) {

        this.name = name;
        this.id = id;
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;

    }
}



