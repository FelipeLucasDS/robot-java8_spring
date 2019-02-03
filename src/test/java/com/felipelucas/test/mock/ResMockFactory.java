package com.felipelucas.test.mock;

import com.felipelucas.robot.api.dto.response.ResPositionDTO;
import com.felipelucas.robot.api.dto.response.ResRobotStepDTO;
import com.felipelucas.robot.domain.VisionSide;

import java.util.Arrays;

public class ResMockFactory {

    public static ResRobotStepDTO mockDefaultSteps(){
        return ResRobotStepDTO.builder()
                .positions(Arrays.asList(
                        ResPositionDTO.builder().visionSide(VisionSide.EAST.name()).x(1).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.EAST.name()).x(4).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.EAST.name()).x(4).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.WEST.name()).x(4).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.WEST.name()).x(3).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.UP.name()).x(3).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.UP.name()).x(3).y(5).build()
                ))
                .build();
    }

    public static ResRobotStepDTO mockSomeSteps(){
        return ResRobotStepDTO.builder()
                .positions(Arrays.asList(
                        ResPositionDTO.builder().visionSide(VisionSide.EAST.name()).x(1).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.EAST.name()).x(4).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.EAST.name()).x(4).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.WEST.name()).x(4).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.WEST.name()).x(3).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.UP.name()).x(3).y(3).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.UP.name()).x(3).y(5).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.WEST.name()).x(3).y(5).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.DOWN.name()).x(3).y(5).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.EAST.name()).x(3).y(5).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.UP.name()).x(3).y(5).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.EAST.name()).x(3).y(5).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.DOWN.name()).x(3).y(5).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.WEST.name()).x(3).y(5).build(),
                        ResPositionDTO.builder().visionSide(VisionSide.UP.name()).x(3).y(5).build()
                ))
                .build();
    }

}
