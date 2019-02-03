package com.felipelucas.robot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StepTypeCommand {
    private Class commandType;
    private String commandSpecification;

}
