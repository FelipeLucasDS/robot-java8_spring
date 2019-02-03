package com.felipelucas.infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
class ErrorBody {
    private String message;
    private Object errorObject;
}
