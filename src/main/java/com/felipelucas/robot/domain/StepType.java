package com.felipelucas.robot.domain;

import com.felipelucas.commons.util.ClassCastUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public enum StepType {


    POSITION {
        public Position doStep(Position position, List<String> command){
            position.setX(NumberUtils.createInteger(command.get(0)));
            position.setY(NumberUtils.createInteger(command.get(1)));
            position.setVisionSide(EnumUtils.getEnum(VisionSide.class, command.get(2)));
            return position.clone();
        }

        @Override
        public List<StepTypeCommand> commandDefinition() {
            return Arrays.asList(StepTypeCommand.builder()
                            .commandSpecification("X position")
                            .commandType(Integer.class)
                            .build(),
                    StepTypeCommand.builder()
                            .commandSpecification("Y position")
                            .commandType(Integer.class)
                            .build(),
                    StepTypeCommand.builder()
                            .commandSpecification("Vision side")
                            .commandType(VisionSide.class)
                            .build());
        }
    },
    FORWARD {
        public Position doStep(Position position, List<String> command){
            Integer integer = NumberUtils.createInteger(command.get(0));
            position.getVisionSide().forward(position, integer);
            return position.clone();
        }

        @Override
        public List<StepTypeCommand> commandDefinition() {
            return Arrays.asList(StepTypeCommand.builder()
                            .commandSpecification("Steps forward")
                            .commandType(Integer.class)
                            .build());
        }
    },
    WAIT {
        public Position doStep(Position position, List<String> command){
            return position.clone();
        }

        @Override
        public List<StepTypeCommand> commandDefinition() {
            return Collections.emptyList();
        }
    },
    TURNAROUND {
        public Position doStep(Position position, List<String> command){
            position.setVisionSide(position.getVisionSide().getTurnAround());
            return position.clone();
        }

        @Override
        public List<StepTypeCommand> commandDefinition() {
            return Collections.emptyList();
        }
    },
    RIGHT {
        public Position doStep(Position position, List<String> command){
            position.setVisionSide(position.getVisionSide().getRight());
            return position.clone();
        }

        @Override
        public List<StepTypeCommand> commandDefinition() {
            return Collections.emptyList();
        }
    },
    LEFT {
        public Position doStep(Position position, List<String> command){
            position.setVisionSide(position.getVisionSide().getLeft());
            return position.clone();
        }

        @Override
        public List<StepTypeCommand> commandDefinition() {
            return Collections.emptyList();
        }
    };

    public boolean validateCommand(List<String> command){
        List<StepTypeCommand> typeCommands = commandDefinition();
        boolean validSize = command.size() == typeCommands.size();

        if(!validSize) {
            return false;
        }else if(typeCommands.isEmpty()){
            return true;
        }

        return IntStream.range(0, typeCommands.size())
                .allMatch(value ->
                        ClassCastUtils.canCast(
                                typeCommands.get(value).getCommandType(),
                                command.get(value)));
    };
    public abstract Position doStep(Position position, List<String> command);
    public abstract List<StepTypeCommand> commandDefinition();

}
