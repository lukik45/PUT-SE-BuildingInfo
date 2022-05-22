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
 *
 */
@RequestMapping("/api/v1/building")
@RestController
public class BuildingController {
    CompositeBuildingComponent entireBuilding;

    @PostMapping
    public void addBuilding(@RequestBody Building building){
        entireBuilding = building;
        System.out.println((entireBuilding.toString()));
    }
    
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

    @GetMapping(path= "/heating-report/{threshold}")
    public ArrayList<ElementaryBuildingComponent> getHeatingReport(@PathVariable("threshold") double threshold) {
        HeatVisitor heatVisitor = new HeatVisitor(threshold);
        entireBuilding.accept(heatVisitor);
        return heatVisitor.getRoomsThatViolate();
    }




}
