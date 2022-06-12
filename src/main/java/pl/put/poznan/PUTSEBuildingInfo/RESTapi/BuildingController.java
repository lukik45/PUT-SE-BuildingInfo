package pl.put.poznan.PUTSEBuildingInfo.RESTapi;


import org.springframework.web.bind.annotation.*;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.ElementaryBuildingComponent;
import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.HeatVisitor;
import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.IdVisitor;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures.Building;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;

import java.util.ArrayList;

/**
 * This class serves as the REST controller for our application
 */
@RequestMapping("/api/v1/building")
@RestController
public class BuildingController {
    CompositeBuildingComponent entireBuilding;

    /**
     * Adds "the building" to the application, allowing to make some baisic operations
     * @param building building structure, in the JSON format
     */
    @PostMapping
    public void addBuilding(@RequestBody Building building){
        entireBuilding = building;
        System.out.println((entireBuilding.toString()));
    }

    /**
     * Returns the area of the particular part of the building in its structure
     * @param id id of the desired part of the building
     * @return if the component with such id exists, then it is the summed area of all its children, if such id was not found, then -1
     */
    @GetMapping(path= "/area/{id}")
    public double checkAreaGivenId(@PathVariable("id") int id) {
        System.out.println(id);
        IdVisitor idVisitor = new IdVisitor(id);
        // look for the component with the given id
        entireBuilding.accept(idVisitor);
        if (idVisitor.getFoundBuildingComponent() != null) {
            return idVisitor.getFoundBuildingComponent().checkArea();
        } else {
            return -1;
        }
    }
    /**
     * Returns the volume of the particular part of the building in its structure
     * @param id id of the desired part of the building
     * @return if the component with such id exists, then it is the summed volume of all its children, if such id was not found, then -1
     */
    @GetMapping(path= "/volume/{id}")
    public double checkVolumeGivenId(@PathVariable("id") int id) {
        System.out.println(id);
        IdVisitor idVisitor = new IdVisitor(id);
        // look for the component with the given id
        entireBuilding.accept(idVisitor);
        if (idVisitor.getFoundBuildingComponent() != null) {
            return idVisitor.getFoundBuildingComponent().checkVolume();
        } else {
            return -1;
        }
    }
    /**
     * Returns the heating power required to heat desired component of the building (its a sum of the heating power, divided by sum of the volumes of all the components)
     * @param id id of the desired part of the building
     * @return if the component with such id exists, then it is the heating power required to heat desired component, if such id was not found, then -1
     */
    @GetMapping(path= "/heating/{id}")
    public double calculateHeatingGivenId(@PathVariable("id") int id) {
        System.out.println(id);
        IdVisitor idVisitor = new IdVisitor(id);
        // look for the component with the given id
        entireBuilding.accept(idVisitor);
        if (idVisitor.getFoundBuildingComponent() != null) {
            return idVisitor.getFoundBuildingComponent().calculateHeatingEnergy();
        } else {
            return -1;
        }
    }
    /**
     * Returns the lighting power required to light desired component of the building (it is a sum of the light power, divided by sum of the areas of all the components)
     * @param id id of the desired part of the building
     * @return if the component with such id exists, then it is the lighting power required to light desired component of the building, if such id was not found, then -1
     */
    @GetMapping(path= "/light/{id}")
    public double calculateLightningGivenId(@PathVariable("id") int id) {
        System.out.println(id);
        IdVisitor idVisitor = new IdVisitor(id);
        // look for the component with the given id
        entireBuilding.accept(idVisitor);
        if (idVisitor.getFoundBuildingComponent() != null) {
            return idVisitor.getFoundBuildingComponent().calculateLightningPower();
        } else {
            return -1;
        }
    }

    /**
     * This method, allowes the user to check which rooms exceeds the thredhold of heating consumption/volume
     * @param threshold threshold of the heating power
     * @return returns list of rooms, that exceeds heating consumption / volume
     */
    @GetMapping(path= "/heating-report/{threshold}")
    public ArrayList<ElementaryBuildingComponent> getHeatingReport(@PathVariable("threshold") double threshold) {
        HeatVisitor heatVisitor = new HeatVisitor(threshold);
        entireBuilding.accept(heatVisitor);
        return heatVisitor.getRoomsThatViolate();
    }




}
