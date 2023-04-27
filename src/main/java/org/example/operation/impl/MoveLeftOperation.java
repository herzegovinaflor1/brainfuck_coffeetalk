package org.example.operation.impl;

import org.example.operation.Operation;
import org.example.visitor.OperationVisitor;

public class MoveLeftOperation extends Operation {

    public MoveLeftOperation(ExecutionParameter executionParameter) {
        super(executionParameter);
    }

    @Override
    public int accept(OperationVisitor operationVisitor) {
        return operationVisitor.visit(this);
    }
}
