package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.put.poznan.transformer.models.Room;

/**
 * Representation of a spring REST controller for Rooms.
 * 
 * @since 0.2
 * @see BuildingInfoController
 * @see Room
 */
@RestController
@RequestMapping("/room")
public class RoomRestController extends BuildingInfoController<Room> {}