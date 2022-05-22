package pl.put.poznan.transformer.models;

import java.util.Arrays;


/** Represents a building level. Allows calculating and obtaining information about the level.
 * @since 0.1
*/
public class Level extends Location {

  /** Represents list of rooms that level consists of.
  */
  private Room[] rooms;

  /**
  *  Gets list of rooms that level consists of. 
  * @return A float representing total area of all rooms that level consists of.
  */
  public Room[] getRooms() {
    return rooms;
  }

  public void setRooms(Room[] _rooms){
      this.rooms = _rooms;
  }
  /**
  *  Gets total area of level. 
  * @return A float representing total area of all rooms that level consists of.
  */
  public float getArea() {
    float area = 0;
    for(int i = 0; i < rooms.length; i++)
    {
      area = area + rooms[i].getArea();
    }
    return area;
  }

  /**
  *  Gets total volume of level. 
  * @return A float representing total volume of all rooms that level consists of.
  */
  public float getVolume() {
    float totalVolume = 0;
    for (Room room : rooms) {
      totalVolume += room.getVolume();
    }
    return totalVolume;
  }

    /**
     *  Gets total heating power of level. 
     * @return A float representing total heating power of all rooms that level consists of.
     */
    public float getHeatingPowerConsumption() {
        float totalHeating = 0;
        for (Room room : rooms) {
            totalHeating += room.getHeatingPowerConsumption();
        }
        return totalHeating;
    }

  /**
  *  Gets lighting power of level. 
  * @return A float representing lighting power per square meter.
  */
  public float getIlluminationPower() {
    float power = 0;
    for (int i = 0; i < rooms.length; i++)
      power += rooms[i].getIlluminationPower();
    float area = getArea();
    power = power / area;
    return power;
  }

  public void sortRooms(String parameter) {
      //Arrays.sort(rooms);
      if(rooms == null){
          System.out.println("Rooms are null");
      }
      else {
          switch (parameter) {
              case "area":
                  Arrays.sort(rooms, (o1, o2) -> Float.compare(o1.getArea(), o2.getArea()));
                  break;
              case "volume":
                  Arrays.sort(rooms, (o1, o2) -> Float.compare(o1.getVolume(), o2.getVolume()));
                  break;
              case "heating":
                  Arrays.sort(rooms, (o1, o2) -> Float.compare(o1.getHeatingPowerConsumption(), o2.getHeatingPowerConsumption()));
                  break;
              case "illumination":
                  Arrays.sort(rooms, (o1, o2) -> Float.compare(o1.getIlluminationPower(), o2.getIlluminationPower()));
                  break;
          }

          System.out.println("----------");
          for (Room room : rooms) {
            System.out.println(room.getName());
          }
      }
  }

    public void sortByClosestArea(float area) {
        if(rooms == null){
            System.out.println("Rooms are null");
        } else {
            Arrays.sort(rooms, (o1, o2) -> Float.compare(Math.abs(o1.getArea() - area), Math.abs(o2.getArea() - area)));
            for (Room room : rooms) {
                System.out.println(room.getName() + " the difference from given area = " + Math.abs(room.getArea() - area));
            }
        }
    }

    @Override
    public void compareBuildings(Location otherBuilding) {}
}