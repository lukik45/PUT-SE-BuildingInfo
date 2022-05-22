package pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;


import java.util.ArrayList;

public class Room extends ElementaryBuildingComponent {


    public Room(
            @JsonProperty("name") String name,
            @JsonProperty("id") String id,
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



