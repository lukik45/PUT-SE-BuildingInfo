package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.put.poznan.transformer.models.Level;

/**
 * Representation of a spring REST controller for Levels.
 * 
 * @since 0.2
 * @see BuildingInfoController
 * @see Level
 */
@RestController
@RequestMapping("/level")
public class LevelRestController extends BuildingInfoController<Level> {}