package pl.put.poznan.transformer.models;

import pl.put.poznan.transformer.interfaces.Visitable;
import pl.put.poznan.transformer.interfaces.Visitor;

import java.util.Arrays;

/** Allows calculation regarding building info 
 */

public class Building extends Location implements Visitable {

    /** list of levels
   */
  private Level[] levels;

  public void setLevels(Level[] levels) {
      this.levels = levels;
  }
  /**
   * Gets list of levels that building consists of.
   * @return A float representing total area of the building.
   */
  public Level[] getLevels() {
    return levels;
  }

  /**
   * Visitor method.
   */
  @Override
  public void accept(Visitor visitor){
      visitor.visit(this);
  }

  /**
   * Gets total area of the building.
   * @return A float representing total area of the building.
   */
  public float getArea() {
    float area = 0;
    for(int i = 0; i < levels.length; i++)
    {
      area = area + levels[i].getArea();
    }
    return area;
  }

  /**
   * Gets total volume of the building.
   * @return A float representing total volume of the building.
   */
  public float getVolume() {
    float totalVolume = 0;
    for (Level level : levels) {
      totalVolume += level.getVolume();
    }
    return totalVolume;
  }

  /**
   * Gets lighting power of the building.
   * @return A float representing lighting power per square meter.
   */
  public float getIlluminationPower() {
    float power = 0;
    for (int i = 0; i < levels.length; i++)
      power += levels[i].getIlluminationPower();
    power = power / levels.length;
    return power;
  }

    @Override
    public void compareBuildings(Location otherBuilding) {
      System.out.println("First building name: " + this.getName() + " other building name: " + otherBuilding.getName());
      System.out.println("Area: " + this.getArea() + " other building: " + otherBuilding.getArea());
      System.out.println("Volume: " + this.getVolume() + " other building: " + otherBuilding.getVolume());
      System.out.println("Illumination Power: " + this.getIlluminationPower() + " other building: " + otherBuilding.getIlluminationPower());
    }


    @Override
    public void sortRooms(String parameter) {
      if(levels == null){
          System.out.println("Rooms are null");
      }
      else {
          for(Level level : levels){
              level.sortRooms(parameter);
          }

          switch (parameter) {
              case "area":
                  Arrays.sort(levels, (o1, o2) -> Float.compare(o1.getArea(), o2.getArea()));
                  break;
              case "volume":
                  Arrays.sort(levels, (o1, o2) -> Float.compare(o1.getVolume(), o2.getVolume()));
                  break;
              case "heating":
                  Arrays.sort(levels, (o1, o2) -> Float.compare(o1.getHeatingPowerConsumption(), o2.getHeatingPowerConsumption()));
                  break;
              case "illumination":
                  Arrays.sort(levels, (o1, o2) -> Float.compare(o1.getIlluminationPower(), o2.getIlluminationPower()));
                  break;
          }

          System.out.println("----------");
          for (Level level : levels) {
              System.out.println(level.getName());
          }
      }
  }

    public void sortByClosestArea(float area) {
        if (levels == null) {
            System.out.println("Rooms are null");
        } else {
            Arrays.sort(levels, (o1, o2) -> Float.compare(Math.abs(o1.getArea() - area), Math.abs(o2.getArea() - area)));
            for (Level level : levels) {
                System.out.println(level.getName() + " the difference from given area = " + Math.abs(level.getArea() - area));
            }
        }
    }
}
