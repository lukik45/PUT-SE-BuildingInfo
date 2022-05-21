package pl.put.poznan;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.put.poznan.composite.pattern.Composite;
import pl.put.poznan.composite.pattern.Leaf;
import pl.put.poznan.visitor.pattern.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class nonApiDemo {
    public static void read_json_building(String data){
        String name, id, area, cube, heating, light;
        int i, j, k;
        //parse through every building
        JSONArray arrBuildings = new JSONArray(data);
        for(i = 0; i < arrBuildings.length(); i++){
            JSONObject building = arrBuildings.getJSONObject(i);
            //print info
            name = (String) building.get("name");
            id = (String) building.get("id");
            System.out.println("Building [" + name + ", " + id + "]:");

            //parse through every floor
            JSONArray arrFloors = building.getJSONArray("floors");
            for(j = 0; j < arrFloors.length();j++){
                JSONObject floor = arrFloors.getJSONObject(j);
                //print info
                name = (String) floor.get("name");
                id = (String) floor.get("id");
                System.out.println("\t- floor [" + name + ", " + id +"]:");

                //parse through every room
                JSONArray arrRooms = floor.getJSONArray("rooms");
                for(k = 0; k < arrRooms.length(); k++){
                    JSONObject room = arrRooms.getJSONObject(k);
                    //print info
                    name = (String) room.get("name");
                    id = (String) room.get("id");
                    area = (String) room.get("area");
                    cube = (String) room.get("cube");
                    heating = (String) room.get("heating");
                    light = (String) room.get("light");
                    System.out.println("\t\t- Room [" + name + ", " + id + "]:");
                    System.out.println("\t\t\t- area: " + area + ",");
                    System.out.println("\t\t\t- cube: " + cube + ",");
                    System.out.println("\t\t\t- heating: " + heating + ",");
                    System.out.println("\t\t\t- light: " + light + ",");
                }
            }
            System.out.println();
        }
    }

    public static Composite readToComposite(String data){
        String name, id, area, cube, heating, light;
        int i, j, k;
        Composite c = new Composite();
        c.setName("List of all buidlings");
        c.setId("-0");
        Composite c_building = new Composite();
        Composite c_floor = new Composite();
        Leaf l_room = new Leaf();

        //parse through every building
        JSONArray arrBuildings = new JSONArray(data);
        for(i = 0; i < arrBuildings.length(); i++){
            c_building = new Composite();
            JSONObject building = arrBuildings.getJSONObject(i);
            //read info
            c_building.setName((String) building.get("name"));
            c_building.setId((String) building.get("id"));

            //parse through every floor
            JSONArray arrFloors = building.getJSONArray("floors");
            for(j = 0; j < arrFloors.length();j++){
                JSONObject floor = arrFloors.getJSONObject(j);
                c_floor = new Composite();
                //read info
                c_floor.setName((String) floor.get("name"));
                c_floor.setId((String) floor.get("id"));

                //parse through every room
                JSONArray arrRooms = floor.getJSONArray("rooms");
                for(k = 0; k < arrRooms.length(); k++){
                    l_room = new Leaf();
                    JSONObject room = arrRooms.getJSONObject(k);
                    //read info
                    l_room.setName((String) room.get("name"));
                    l_room.setId((String) room.get("id"));
                    l_room.setArea(Double.parseDouble((String) room.get("area")));
                    l_room.setCube(Double.parseDouble((String) room.get("cube")));
                    l_room.setHeating(Double.parseDouble((String) room.get("heating")));
                    l_room.setLight(Double.parseDouble((String) room.get("light")));
                    c_floor.add(l_room);
                }
                c_building.add(c_floor);
            }
            c.add(c_building);
        }
        return c;
    }


    public static void main(String[] args) throws IOException {
        // read the string
        String data = new String(Files.readAllBytes(Paths.get("src/examples/small_example.json")));
        read_json_building(data);
        Composite c = readToComposite(data);

        printVisitor v = new printVisitor();
        c.accept(v);

        areaVisitor v1 = new areaVisitor();
        double s1 = c.accept(v1);
        System.out.println("Area of room in all buildings from small_example: " +  s1 + " (should be 140)");

        cubeVisitor v2 = new cubeVisitor();
        double s2 = c.accept(v2);
        System.out.println("Cubature of room in all buildings from small_example: " +  s2 + " (should be 240)");

        heatingVisitor v3 = new heatingVisitor();
        double s3 = c.accept(v3);
        System.out.println("Lighting power per unit of area: " +  s3/s1 + " (should be 27.17)");

        lightVisitor v4 = new lightVisitor();
        double s4 = c.accept(v4);
        System.out.println("Lighting power per unit of area: " +  s4/s1 + " (should be around 30.714)");
    }
}
