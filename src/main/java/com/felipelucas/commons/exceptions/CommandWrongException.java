package com.felipelucas.commons.exceptions;

import com.felipelucas.robot.domain.CommandStep;

public class CommandWrongException extends RuntimeException {
    private CommandStep commandStep;

    public CommandWrongException(CommandStep commandStep) {
        this.commandStep = commandStep;
    }

    public CommandStep getCommandStep() {
        return commandStep;
    }
}
