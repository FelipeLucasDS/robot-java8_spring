package com.felipelucas.robot.service;

import com.felipelucas.commons.exceptions.CommandWrongException;
import com.felipelucas.commons.exceptions.OutOfBoundsException;
import com.felipelucas.robot.domain.CommandStep;
import com.felipelucas.robot.domain.Position;
import com.felipelucas.robot.domain.StepType;
import com.felipelucas.robot.domain.VisionSide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RobotService {

    private final static Logger logger = LoggerFactory.getLogger(RobotService.class);

    public List<Position> commandRobot(List<CommandStep> commands) {
        logger.info("Working on {} robot commands", commands.size());

        Position position = Position.builder()
                .visionSide(VisionSide.EAST)
                .x(0).y(0).build();

        return commands.stream()
                .map(this::commandInvalid)
                .map(commandStep -> this.doStep(position, commandStep))
                .collect(Collectors.toList());

    }

    private CommandStep commandInvalid(CommandStep commandStep) {
        boolean stepValid = commandStep.getStepType().validateCommand(commandStep.getCommand());

        if(!stepValid){
            throw new CommandWrongException(commandStep);
        }

        return commandStep;
    }

    private Position doStep(Position position, CommandStep commandStep) {
        Position positionPostStep = commandStep.getStepType().doStep(position, commandStep.getCommand());

        if(!positionPostStep.positionValid()){
            throw new OutOfBoundsException(commandStep);
        }

        return positionPostStep;
    }


    public List<CommandStep> defaultCommands(){
        List<CommandStep> commands = new ArrayList<>();
        commands.add(CommandStep.builder()
                .stepType(StepType.POSITION)
                .command(Arrays.asList("1", "3", VisionSide.EAST.name()))
                .build());

        commands.add(CommandStep.builder()
                .stepType(StepType.FORWARD)
                .command(Arrays.asList("3"))
                .build());

        commands.add(CommandStep.builder()
                .stepType(StepType.WAIT)
                .command(Collections.emptyList())
                .build());

        commands.add(CommandStep.builder()
                .stepType(StepType.TURNAROUND)
                .command(Collections.emptyList())
                .build());

        commands.add(CommandStep.builder()
                .stepType(StepType.FORWARD)
                .command(Arrays.asList("1"))
                .build());

        commands.add(CommandStep.builder()
                .stepType(StepType.RIGHT)
                .command(Collections.emptyList())
                .build());

        commands.add(CommandStep.builder()
                .stepType(StepType.FORWARD)
                .command(Arrays.asList("2"))
                .build());

        return commands;
    }

}