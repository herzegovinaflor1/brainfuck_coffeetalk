package org.example.visitor;

import org.example.operation.impl.DecrementOperation;
import org.example.operation.impl.EndCycleOperation;
import org.example.operation.impl.IncrementOperation;
import org.example.operation.impl.MoveLeftOperation;
import org.example.operation.impl.MoveRightOperation;
import org.example.operation.impl.PrintOperation;
import org.example.operation.impl.StrartCycleOperation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class OperationVisitor {

    protected final byte[] memory;
    private final boolean enableLog;
    private final List<String> logs;

    public OperationVisitor(boolean enableLog, byte[] memory) {
        this.enableLog = enableLog;
        this.memory = memory;
        this.logs = new LinkedList<>();
        log();
    }

    public int visit(MoveRightOperation moveRightOperation) {
        int res = execute(moveRightOperation);
        return postExecution(res);
    }

    public int visit(MoveLeftOperation moveLeftOperation) {
        int res = execute(moveLeftOperation);
        return postExecution(res);
    }

    public int visit(IncrementOperation moveRightOperation) {
        int res = execute(moveRightOperation);
        return postExecution(res);
    }

    public int visit(DecrementOperation decrementOperation) {
        int res = execute(decrementOperation);
        return postExecution(res);
    }

    public int visit(PrintOperation printOperation) {
        int res = execute(printOperation);
        return postExecution(res);
    }

    public int visit(StrartCycleOperation strartCycleOperation) {
        int res = execute(strartCycleOperation);
        return postExecution(res);
    }

    public int visit(EndCycleOperation endCycleOperation) {
        int res = execute(endCycleOperation);
        return postExecution(res);
    }

    public void printLogs() {
        if (enableLog) {
            logs.forEach(System.out::println);
        }
    }


    protected abstract int execute(MoveRightOperation moveRightOperation);

    public abstract int execute(MoveLeftOperation moveLeftOperation);

    public abstract int execute(IncrementOperation moveRightOperation);

    public abstract int execute(DecrementOperation decrementOperation);

    public abstract int execute(PrintOperation printOperation);

    public abstract int execute(StrartCycleOperation strartCycleOperation);

    public abstract int execute(EndCycleOperation endCycleOperation);

    private int postExecution(int res) {
        log();
        return res;
    }

    private void log() {
        if (enableLog) {
            logs.add(Arrays.toString(memory));
        }
    }

}
