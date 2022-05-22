package pl.put.poznan.transformer.models;
/** Represents a room. Allows obtaining information about the room.
 
 */

public class Room extends Location {

  /** Represents room's values:
   * -area
   * -volume
   * -heating power consumption
   * -average light power per square meter
   */
  private float area;
  private float volume;
  private float heatingPowerConsumption;
  private float illuminationPower;

  public void setArea(float area) {
    this.area = area;
  }

  public void setVolume(float volume) {
    this.volume = volume;
  }

  public void setHeatingPowerConsumption(float heatingPowerConsumption) {
    this.heatingPowerConsumption = heatingPowerConsumption;
  }

  public void setIlluminationPower(float illuminationPower) {
    this.illuminationPower = illuminationPower;
  }

  /**
   *  Gets area of the room. 
   * @return A float representing total area
   */
  public float getArea() {
    return area;
  }

  /**
   *  Gets volume of the room. 
   * @return A float representing total volume 
   */
  public float getVolume() {
    return volume;
  }

  public float getHeatingPowerConsumption() {
    return heatingPowerConsumption;
  }

  /**
   *  Gets lighting power of the room. 
   * @return A float representing lighting power
   */
  public float getIlluminationPower() {
    return illuminationPower;
  }
  public void sortRooms(String parameter){}
  public void sortByClosestArea(float area){}

    @Override
    public void compareBuildings(Location otherBuilding) {}
}