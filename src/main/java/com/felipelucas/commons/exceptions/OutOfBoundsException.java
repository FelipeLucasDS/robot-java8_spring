package com.felipelucas.commons.exceptions;

import com.felipelucas.robot.domain.CommandStep;

public class OutOfBoundsException extends RuntimeException {

    private CommandStep commandStep;

    public OutOfBoundsException(CommandStep commandStep) {
        this.commandStep = commandStep;
    }

    public CommandStep getCommandStep() {
        return commandStep;
    }
}
