package Planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryType militaryType;

    public MilitaryPlane(String modelOfPlane, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(modelOfPlane, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = type;
    }

    public MilitaryType getMilitaryType() {
        return militaryType;
    }

    @Override
    public boolean equals(Object plane) {
        if (this == plane) return true;
        if (!(plane instanceof MilitaryPlane)) return false;
        if (!super.equals(plane)) return false;
        MilitaryPlane currentPlane = (MilitaryPlane) plane;
        return militaryType == currentPlane.militaryType;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryType +
                '}');
    }
}
