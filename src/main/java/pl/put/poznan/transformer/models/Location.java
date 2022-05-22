package pl.put.poznan.transformer.models;



public abstract class Location {
  private long id;
  private String name;
  
  public Location() {
    this.id = 1;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public abstract float getArea();
  public abstract float getVolume();
  public abstract float getIlluminationPower();
  public abstract void sortRooms(String parameter);
  public abstract void sortByClosestArea(float area);
  public abstract void compareBuildings(Location otherBuilding);


}