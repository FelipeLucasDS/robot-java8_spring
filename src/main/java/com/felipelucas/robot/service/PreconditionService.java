package com.felipelucas.robot.service;

import com.felipelucas.robot.domain.StepType;
import com.felipelucas.robot.domain.VisionSide;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PreconditionService {

    public List<VisionSide> getVisionSides(){
        return Arrays.asList(VisionSide.values());
    }

    public List<StepType> getStepTypes(){
        return Arrays.asList(StepType.values());
    }

}
