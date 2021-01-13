package Planes;

import java.util.Objects;

import models.ClassificationLevel;
import models.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private ExperimentalTypes experimentalType;
    private ClassificationLevel classificationLevel;
    
    public ExperimentalPlane(String modelOfPlane, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, 
                             ClassificationLevel classificationLevel) {
        super(modelOfPlane, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = type;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalTypes getExperimentalType() {
        return experimentalType;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }
    
    public void setExperimentalType(ExperimentalTypes experimentalType) {
        this.experimentalType = experimentalType;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object plane) {
        if (this == plane) return true;
        if (!(plane instanceof ExperimentalPlane)) return false;
        if (!super.equals(plane)) return false;
        ExperimentalPlane currentPlane = (ExperimentalPlane) plane;
        return experimentalType == currentPlane.experimentalType
               && classificationLevel == currentPlane.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType, classificationLevel);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", experimentalType=" + experimentalType +
                        ", classificationLevel=" + classificationLevel +
                        '}');
    }
}
