package org.example.operation.impl;

import org.example.operation.Operation;
import org.example.visitor.OperationVisitor;

public class DecrementOperation extends Operation {

    public DecrementOperation(ExecutionParameter executionParameter) {
        super(executionParameter);
    }

    @Override
    public int accept(OperationVisitor operationVisitor) {
        return operationVisitor.visit(this);
    }
}
