package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.Visitor;


/**
 * Corresponds to the Component interface in Composite pattern
 * There are two versions of each method, the REST controller uses only parameterless versions.
 * Methods with parameters are only added to print the topology of search
 */
public interface BuildingComponent {

    /**
     * @return the total area of a component
     */
    default double checkArea() {
        return checkArea(0);
    }
    double checkArea(int level);

    /**
     * @return the total volume of a component
     */
    default double checkVolume() {
        return checkVolume(0);
    }
    double checkVolume(int level);


    /**
     * @return the heating energy consumption per unit of volume for a component
     */
    default double calculateHeatingEnergy() {
        return calculateHeatingEnergy(0);
    }
    double calculateHeatingEnergy(int level);

    /**
     * @return the lighting power per unit area for a component
     */
    default double calculateLightningPower() {
        return calculateLightningPower(0);
    }
    double calculateLightningPower(int level);

    /**
     * Invokes the proper implementation of visit method
     * @param v the visitor object
     */
    void accept(Visitor v);


}
