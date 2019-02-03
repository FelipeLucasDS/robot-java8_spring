package com.felipelucas.robot.api.v1;

import com.felipelucas.commons.api.BaseRestController;
import com.felipelucas.robot.api.dto.response.ResStepTypeCommandDTO;
import com.felipelucas.robot.api.dto.response.ResStepTypeDTO;
import com.felipelucas.robot.service.PreconditionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class PreconditionAPI extends BaseRestController {

    @Autowired
    private PreconditionService preconditionService;

    private final static Logger logger = LoggerFactory.getLogger(PreconditionAPI.class);

    @GetMapping(value="/visionside")
    public ResponseEntity<List<String>> visionSide() {
        logger.debug("Returning visionSides");

        return ok(preconditionService.getVisionSides()
                .stream().map(Enum::name)
                .collect(Collectors.toList()));
    }

    @GetMapping(value="/steptype")
    public ResponseEntity<List<ResStepTypeDTO>> stepTypes() {
        logger.debug("Returning steptype");

        return ok(preconditionService.getStepTypes()
                .stream()
                .map(stepType -> {
                    List<ResStepTypeCommandDTO> stepTypes = stepType.commandDefinition().stream()
                            .map(stepTypeCommand -> ResStepTypeCommandDTO.builder()
                                    .commandSpecification(stepTypeCommand.getCommandSpecification())
                                    .commandType(stepTypeCommand.getCommandType().getSimpleName())
                                    .build())
                            .collect(Collectors.toList());

                    return ResStepTypeDTO.builder()
                            .stepName(stepType.name())
                            .stepTypes(stepTypes)
                            .build();
                })
                .collect(Collectors.toList()));
    }
}