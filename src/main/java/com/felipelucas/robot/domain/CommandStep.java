package com.felipelucas.robot.domain;

import com.felipelucas.robot.api.dto.request.ReqStepTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandStep {
    private StepType stepType;
    private List<String> command;
}
