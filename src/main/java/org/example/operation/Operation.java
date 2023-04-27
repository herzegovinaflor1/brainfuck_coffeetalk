package org.example.operation;

import org.example.visitor.OperationVisitor;

public abstract class Operation {

    private final ExecutionParameter executionParameter;

    public Operation(ExecutionParameter executionParameter) {
        this.executionParameter = executionParameter;
    }

    public abstract int accept(OperationVisitor operationVisitor);

    public ExecutionParameter getExecutionParameter() {
        return executionParameter;
    }

    public record ExecutionParameter(int index, String expression) {
    }

}
