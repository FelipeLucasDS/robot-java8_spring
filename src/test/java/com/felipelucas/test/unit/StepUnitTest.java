package com.felipelucas.test.unit;

import com.felipelucas.robot.domain.Position;
import com.felipelucas.robot.domain.StepType;
import com.felipelucas.robot.domain.VisionSide;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StepUnitTest {

    Position pos;

    @Before
    public void init(){
        this.pos = Position.builder()
                .y(2)
                .x(2)
                .visionSide(VisionSide.EAST)
                .build();
    }

    @Test
    public void stepPositionValid() {
        Position position = StepType.POSITION.doStep(this.pos,
                Arrays.asList("1", "3", VisionSide.DOWN.name()));
        assertEquals(position.getVisionSide(), VisionSide.DOWN);
        assertEquals(position.getX(), 1);
        assertEquals(position.getY(), 3);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepPositionInvalid() {
        Position position = StepType.POSITION.doStep(this.pos,
                Arrays.asList("6", "3", VisionSide.EAST.name()));
        assertEquals(position.getVisionSide(), VisionSide.EAST);
        assertEquals(position.getX(), 6);
        assertEquals(position.getY(), 3);
        assertFalse(position.positionValid());
    }

    @Test
    public void stepPositionInvalidCommand() {
        assertFalse(StepType.POSITION.validateCommand(Arrays.asList("6", "3", "DOWNI")));
    }


    @Test
    public void stepRightEastValid() {
        this.pos.setVisionSide(VisionSide.EAST);
        Position position = StepType.RIGHT.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.EAST.getRight());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepRightWestValid() {
        this.pos.setVisionSide(VisionSide.WEST);
        Position position = StepType.RIGHT.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.WEST.getRight());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepRightDownValid() {
        this.pos.setVisionSide(VisionSide.DOWN);
        Position position = StepType.RIGHT.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.DOWN.getRight());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepRightUPValid() {
        this.pos.setVisionSide(VisionSide.UP);
        Position position = StepType.RIGHT.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.UP.getRight());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepLeftEastValid() {
        this.pos.setVisionSide(VisionSide.EAST);
        Position position = StepType.LEFT.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.EAST.getLeft());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepLeftWestValid() {
        this.pos.setVisionSide(VisionSide.WEST);
        Position position = StepType.LEFT.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.WEST.getLeft());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepLeftDownValid() {
        this.pos.setVisionSide(VisionSide.DOWN);
        Position position = StepType.LEFT.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.DOWN.getLeft());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepLeftUPValid() {
        this.pos.setVisionSide(VisionSide.UP);
        Position position = StepType.LEFT.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.UP.getLeft());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepTurnAroundEastValid() {
        this.pos.setVisionSide(VisionSide.EAST);
        Position position = StepType.TURNAROUND.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.EAST.getTurnAround());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepTurnAroundWestValid() {
        this.pos.setVisionSide(VisionSide.WEST);
        Position position = StepType.TURNAROUND.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.WEST.getTurnAround());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepTurnAroundDownValid() {
        this.pos.setVisionSide(VisionSide.DOWN);
        Position position = StepType.TURNAROUND.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.DOWN.getTurnAround());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepTurnAroundUPValid() {
        this.pos.setVisionSide(VisionSide.UP);
        Position position = StepType.TURNAROUND.doStep(this.pos,
                Collections.emptyList());
        assertEquals(position.getVisionSide(), VisionSide.UP.getTurnAround());
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    //asdsadsadsa
    //asdasda
    //asdsad



    @Test
    public void stepForwardEastValid() {
        this.pos.setVisionSide(VisionSide.EAST);
        Position position = StepType.FORWARD.doStep(this.pos,
                Arrays.asList("1"));
        assertEquals(position.getVisionSide(), VisionSide.EAST);
        assertEquals(position.getX(), 3);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepForwardWestValid() {
        this.pos.setVisionSide(VisionSide.WEST);
        Position position = StepType.FORWARD.doStep(this.pos,
                Arrays.asList("1"));
        assertEquals(position.getVisionSide(), VisionSide.WEST);
        assertEquals(position.getX(), 1);
        assertEquals(position.getY(), 2);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepForwardDownValid() {
        this.pos.setVisionSide(VisionSide.DOWN);
        Position position = StepType.FORWARD.doStep(this.pos,
                Arrays.asList("1"));
        assertEquals(position.getVisionSide(), VisionSide.DOWN);
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 1);
        assertTrue(position.positionValid());
    }

    @Test
    public void stepForwardUPValid() {
        this.pos.setVisionSide(VisionSide.UP);
        Position position = StepType.FORWARD.doStep(this.pos,
                Arrays.asList("1"));
        assertEquals(position.getVisionSide(), VisionSide.UP);
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 3);
        assertTrue(position.positionValid());
    }
}
