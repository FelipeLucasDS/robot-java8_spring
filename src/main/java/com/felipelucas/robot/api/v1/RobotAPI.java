package com.felipelucas.robot.api.v1;

import com.felipelucas.commons.api.BaseRestController;
import com.felipelucas.commons.util.ClassMapper;
import com.felipelucas.robot.api.dto.request.ReqCommandsDTO;
import com.felipelucas.robot.api.dto.response.ResPositionDTO;
import com.felipelucas.robot.api.dto.response.ResRobotStepDTO;
import com.felipelucas.robot.domain.CommandStep;
import com.felipelucas.robot.domain.Position;
import com.felipelucas.robot.service.RobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class RobotAPI extends BaseRestController {

    @Autowired
    private ClassMapper modelMapper;

    @Autowired
    private RobotService robotService;

    private final static Logger logger = LoggerFactory.getLogger(RobotAPI.class);

    @PostMapping(value="/step")
    public ResponseEntity<ResRobotStepDTO> command(
            @Valid @RequestBody ReqCommandsDTO steps) {
        logger.debug("Received {} commands", steps.getCommands().size());

        List<CommandStep> commandSteps = modelMapper.map(steps.getCommands(), CommandStep.class);

        List<Position> positions = robotService.commandRobot(commandSteps);

        logger.debug("Everything runs fine and we had {} commands done", positions.size());

        return ok(ResRobotStepDTO.builder()
                .positions(modelMapper.map(positions, ResPositionDTO.class))
                .build());
    }

    @PostMapping(value="/step/default")
    public ResponseEntity<ResRobotStepDTO> command() {

        logger.debug("Working on default commands");

        List<CommandStep> defaultCommands = robotService.defaultCommands();

        List<Position> positions = robotService.commandRobot(defaultCommands);

        logger.debug("Everything runs fine and we had {} commands done", positions.size());

        return ok(ResRobotStepDTO.builder()
                .positions(modelMapper.map(positions, ResPositionDTO.class))
                .build());
    }
}