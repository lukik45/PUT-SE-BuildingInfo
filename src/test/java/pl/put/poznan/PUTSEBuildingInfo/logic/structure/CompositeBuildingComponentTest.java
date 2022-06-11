package pl.put.poznan.PUTSEBuildingInfo.logic.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures.Building;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures.Floor;
import pl.put.poznan.PUTSEBuildingInfo.logic.structure.concreteStructures.Room;
import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.HeatVisitor;
import pl.put.poznan.PUTSEBuildingInfo.logic.visitors.IdVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompositeBuildingComponentTest {

    private CompositeBuildingComponent CB = new CompositeBuildingComponent();
    private Room r1 = new Room("First room", 100, (float) 10.0, (float) 30.0, (float) 25.0, (float) 10.0);
    private Room r2 = new Room("Second room", 200, (float) 10.0, (float) 30.0, (float) 25.0, (float) 10.0);
    private Room r3 = new Room("Third room", 300, (float) 10.0, (float) 30.0, (float) 25.0, (float) 10.0);
    private Room r4 = new Room("Fourth room", 400, (float) 100.0, (float) 200.0, (float) 250.0, (float) 100.0);
    private ArrayList<Room> f1_arr = new ArrayList<Room>();
    private ArrayList<Room> f2_arr = new ArrayList<Room>();
    private ArrayList<Floor> b1_arr = new ArrayList<Floor>();
    private Floor f1;
    private Floor f2;
    private Building b1;

    @BeforeEach
    public void setup(){
        f1_arr.add(r1);
        f1_arr.add(r2);
        f1_arr.add(r3);
        f2_arr.add(r4);
        f1 = new Floor("First floor", 10, f1_arr);
        f2 = new Floor("Second floor", 20, f2_arr);
        b1_arr.add(f1);
        b1_arr.add(f2);
        b1 = new Building("The building", 1, b1_arr);
    }
    //mock1
    //Does the composite, accepts the visitor?
    @Test
    void acceptTest(){
        IdVisitor mockVisitor = mock(IdVisitor.class);

        when(mockVisitor.getFoundBuildingComponent()).thenReturn(f2);

        b1.accept(mockVisitor);
        verify(mockVisitor).visitCompositeBuildingComponent(b1);

        double res = mockVisitor.getFoundBuildingComponent().checkArea();
        assertEquals(100, res);
    }

    //Does the composite correctly finds all the areas through its structure?
    @Test
    void checkAreaTest() {
        IdVisitor v = new IdVisitor(1);
        b1.accept(v);
        double res = v.getFoundBuildingComponent().checkArea();
        assertEquals((float) 130.0, res);
    }

    //Does the composite correctly finds all the volumes through its structure?
    @Test
    void checkVolumeTest() {
        IdVisitor v = new IdVisitor(1);
        b1.accept(v);
        double res = v.getFoundBuildingComponent().checkVolume();
        assertEquals((float) 290.0, res);
    }

    //Does the composite correctly calculates its heating power, through whole structure?
    @Test
    void calculateHeatingEnergyTest() {
        IdVisitor v = new IdVisitor(1);
        b1.accept(v);
        double res = v.getFoundBuildingComponent().calculateHeatingEnergy();
        assertEquals((float) 325.0/290.0, res);
    }
    //Does the composite correctly calculates its light power, through whole structure?
    @Test
    void calculateLightningPowerTest() {
        IdVisitor v = new IdVisitor(1);
        b1.accept(v);
        double res = v.getFoundBuildingComponent().calculateLightningPower();
        assertEquals((float) 130.0/130.0, res);
    }

    //Does the composite correctly finds all the heat through its structure?
    @Test
    void getHeatingTest() {
        IdVisitor v = new IdVisitor(1);
        b1.accept(v);
        double res = v.getFoundBuildingComponent().getHeating(0);
        assertEquals((float) 325.0, res);
    }

    //Does the composite correctly finds all the light through its structure?
    @Test
    void getLightTest() {
        IdVisitor v = new IdVisitor(1);
        b1.accept(v);
        double res = v.getFoundBuildingComponent().getLight(0);
        assertEquals((float) 130.0, res);
    }

    //Does the composite correctly finds all the light through its structure?
    @Test
    void exceedingThresholdTest() {
        HeatVisitor v = new HeatVisitor(1);
        b1.accept(v);
        ArrayList<ElementaryBuildingComponent> res = v.getRoomsThatViolate();
        assertEquals(f2_arr, res);
    }
}