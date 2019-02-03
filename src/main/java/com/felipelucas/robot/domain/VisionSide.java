package com.felipelucas.robot.domain;

import java.util.List;

public enum VisionSide {
    UP {
        public VisionSide getLeft(){ return VisionSide.WEST; }
        public VisionSide getRight(){return VisionSide.EAST;}
        public VisionSide getTurnAround(){return VisionSide.DOWN;}
        public void forward(Position position, int step) {
            position.setY(position.getY() + step);
        }
    },
    WEST {
        public VisionSide getLeft(){ return VisionSide.DOWN; }
        public VisionSide getRight(){return VisionSide.UP;}
        public VisionSide getTurnAround(){return VisionSide.EAST;}
        public void forward(Position position, int step) {
            position.setX(position.getX() - step);
        }
    },
    EAST {
        public VisionSide getLeft(){ return VisionSide.UP; }
        public VisionSide getRight(){return VisionSide.DOWN;}
        public VisionSide getTurnAround(){return VisionSide.WEST;}
        public void forward(Position position, int step) {
            position.setX(position.getX() + step);
        }
    },
    DOWN {
        public VisionSide getLeft(){ return VisionSide.EAST; }
        public VisionSide getRight(){return VisionSide.WEST;}
        public VisionSide getTurnAround(){return VisionSide.UP;}
        public void forward(Position position, int step) {
            position.setY(position.getY() - step);
        }
    };

    public abstract VisionSide getLeft();
    public abstract VisionSide getRight();
    public abstract VisionSide getTurnAround();
    public abstract void forward(Position position, int step);
}
