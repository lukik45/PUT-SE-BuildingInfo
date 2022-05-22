
  
package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.put.poznan.transformer.models.Building;

/**
 * Representation of a spring REST controller for Buildings.
 * 
 * @see BuildingInfoController
 * @see Building
 */
@RestController
@RequestMapping("/building")
public class BuildingRestController extends BuildingInfoController<Building> {}