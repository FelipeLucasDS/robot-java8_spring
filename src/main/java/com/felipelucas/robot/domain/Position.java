package com.felipelucas.robot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Position implements Cloneable{

    private int x;
    private int y;
    private VisionSide visionSide;

    public boolean positionValid(){
        return x > 0 && x < 6 && y > 0 && y < 6;
    }

    protected Position clone() {
        try {
            return (Position) super.clone();
        } catch (CloneNotSupportedException e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }
}
