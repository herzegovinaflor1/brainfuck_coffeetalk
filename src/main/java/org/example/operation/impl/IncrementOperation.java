package org.example.operation.impl;

import org.example.operation.Operation;
import org.example.visitor.OperationVisitor;

public class IncrementOperation extends Operation {

    public IncrementOperation(ExecutionParameter executionParameter) {
        super(executionParameter);
    }

    @Override
    public int accept(OperationVisitor operationVisitor) {
        return operationVisitor.visit(this);
    }
}
