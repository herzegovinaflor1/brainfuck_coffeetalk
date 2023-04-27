package org.example.visitor.impl;

import org.example.operation.Operation;
import org.example.operation.impl.DecrementOperation;
import org.example.operation.impl.EndCycleOperation;
import org.example.operation.impl.IncrementOperation;
import org.example.operation.impl.MoveLeftOperation;
import org.example.operation.impl.MoveRightOperation;
import org.example.operation.impl.PrintOperation;
import org.example.operation.impl.StrartCycleOperation;
import org.example.visitor.OperationVisitor;

import java.util.ArrayDeque;
import java.util.Deque;

public class InterpreterOperationVisitor extends OperationVisitor {

    private final Deque<Integer> cycleIndexStart;
    private final int memoryBoundary;
    private int cursor = 0;

    public InterpreterOperationVisitor(byte[] memory, boolean enableLog) {
        super(enableLog, memory);
        this.memoryBoundary = memory.length - 1;
        this.cycleIndexStart = new ArrayDeque<>();
    }

    @Override
    public int execute(MoveRightOperation moveRightOperation) {
        Operation.ExecutionParameter executionParameter = moveRightOperation.getExecutionParameter();
        if (cursor == memoryBoundary) {
            cursor = 0;
        } else {
            cursor++;
        }
        return executionParameter.index();
    }

    @Override
    public int execute(MoveLeftOperation moveLeftOperation) {
        Operation.ExecutionParameter executionParameter = moveLeftOperation.getExecutionParameter();
        if (cursor == 0) {
            cursor = memoryBoundary;
        } else {
            cursor--;
        }
        return executionParameter.index();
    }

    @Override
    public int execute(IncrementOperation moveRightOperation) {
        Operation.ExecutionParameter executionParameter = moveRightOperation.getExecutionParameter();
        memory[cursor]++;
        return executionParameter.index();
    }

    @Override
    public int execute(DecrementOperation decrementOperation) {
        Operation.ExecutionParameter executionParameter = decrementOperation.getExecutionParameter();
        memory[cursor]--;
        return executionParameter.index();
    }

    @Override
    public int execute(PrintOperation printOperation) {
        Operation.ExecutionParameter executionParameter = printOperation.getExecutionParameter();
        System.out.print((char) memory[cursor]);
        return executionParameter.index();
    }

    @Override
    public int execute(StrartCycleOperation strartCycleOperation) {
        Operation.ExecutionParameter executionParameter = strartCycleOperation.getExecutionParameter();
        int index = executionParameter.index();
        String expression = executionParameter.expression();

        if (memory[cursor] != 0) {
            cycleIndexStart.add(index);
        } else {
            while (expression.charAt(index) != ']') {
                index++;
            }
        }

        return index;
    }

    @Override
    public int execute(EndCycleOperation endCycleOperation) {
        Operation.ExecutionParameter executionParameter = endCycleOperation.getExecutionParameter();
        int index = executionParameter.index();

        if (memory[cursor] != 0) {
            Integer cycleIndex = cycleIndexStart.pollLast();
            if (cycleIndex != null) {
                index = cycleIndex - 1;
            }
        } else {
            cycleIndexStart.pollLast();
        }

        return index;
    }
}
