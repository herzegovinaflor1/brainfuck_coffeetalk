package org.example.processor.impl;

import org.example.config.RunConfiguration;
import org.example.operation.Operation;
import org.example.processor.Processor;
import org.example.visitor.OperationVisitor;
import org.example.visitor.impl.InterpreterOperationVisitor;

public enum Interpreter implements Processor {

    INTERPRETER;

    @Override
    public void process(RunConfiguration runConfiguration) {
        validateConfiguration(runConfiguration);

        OperationVisitor operationVisitor = new InterpreterOperationVisitor(
                new byte[runConfiguration.getMemorySize()],
                runConfiguration.isEnableLog()
        );

        String expression = runConfiguration.getExpression();
        for (int i = 0; i < expression.length(); i++) {
            Operation operation = getCommand(expression, i);
            i = operation.accept(operationVisitor);
        }

        operationVisitor.printLogs();
    }

    private Operation getCommand(String expression, int index) {
        Operation.ExecutionParameter executionParameter = new Operation.ExecutionParameter(index, expression);
        char symbol = expression.charAt(index);
        return SYMBOL_TO_OPERATION.get(symbol).apply(executionParameter);
    }

}
