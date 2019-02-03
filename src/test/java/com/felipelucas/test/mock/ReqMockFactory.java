package com.felipelucas.test.mock;

import com.felipelucas.robot.api.dto.request.ReqCommandStepDTO;
import com.felipelucas.robot.api.dto.request.ReqCommandsDTO;
import com.felipelucas.robot.api.dto.response.ResPositionDTO;
import com.felipelucas.robot.api.dto.response.ResRobotStepDTO;
import com.felipelucas.robot.domain.StepType;
import com.felipelucas.robot.domain.VisionSide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReqMockFactory {

    public static ReqCommandsDTO mockAllSteps(){
        List<ReqCommandStepDTO> commands = new ArrayList<>();
        ReqCommandsDTO stepDTO = ReqCommandsDTO.builder()
                .commands(commands)
                .build();
        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.POSITION.name())
                .command(Arrays.asList("1", "3", VisionSide.EAST.name()))
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.FORWARD.name())
                .command(Arrays.asList("3"))
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.WAIT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.TURNAROUND.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.FORWARD.name())
                .command(Arrays.asList("1"))
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.RIGHT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.FORWARD.name())
                .command(Arrays.asList("2"))
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.LEFT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.LEFT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.LEFT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.LEFT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.RIGHT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.RIGHT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.RIGHT.name())
                .command(Collections.emptyList())
                .build());

        commands.add(ReqCommandStepDTO.builder()
                .stepType(StepType.RIGHT.name())
                .command(Collections.emptyList())
                .build());

        return stepDTO;
    }

}
