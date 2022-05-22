package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.Visitor;

public interface BuildingComponent {

    default double checkArea() {
        return checkArea(0);
    }
    double checkArea(int level);

    default double checkVolume() {
        return checkVolume(0);
    }
    double checkVolume(int level);

    default double calculateHeatingEnergy() {
        return calculateHeatingEnergy(0);
    }
    double calculateHeatingEnergy(int level);

    default double calculateLightningPower() {
        return calculateLightningPower(0);
    }
    double calculateLightningPower(int level);

    void accept(Visitor v);


}
