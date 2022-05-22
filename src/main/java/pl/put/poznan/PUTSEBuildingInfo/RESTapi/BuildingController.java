package pl.put.poznan.PUTSEBuildingInfo.RESTapi;


import org.springframework.web.bind.annotation.*;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures.Building;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.CompositeBuildingComponent;

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
        return entireBuilding.checkArea();
    }




}
