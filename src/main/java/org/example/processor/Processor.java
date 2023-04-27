package org.example.processor;

import org.example.config.RunConfiguration;
import org.example.operation.Operation;
import org.example.operation.impl.DecrementOperation;
import org.example.operation.impl.EndCycleOperation;
import org.example.operation.impl.IncrementOperation;
import org.example.operation.impl.MoveLeftOperation;
import org.example.operation.impl.MoveRightOperation;
import org.example.operation.impl.PrintOperation;
import org.example.operation.impl.StrartCycleOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface Processor {

    Map<Character, Function<Operation.ExecutionParameter, Operation>> SYMBOL_TO_OPERATION = new HashMap<>() {{
        put('>', MoveRightOperation::new);
        put('<', MoveLeftOperation::new);
        put('+', IncrementOperation::new);
        put('-', DecrementOperation::new);
        put('.', PrintOperation::new);
        put('[', StrartCycleOperation::new);
        put(']', EndCycleOperation::new);
    }};

    void process(RunConfiguration runConfiguration);

    default void validateConfiguration(RunConfiguration runConfiguration) {
        // ideally could be created a separate class for the validation
        validateExpression(runConfiguration.getExpression());
        validateMemorySize(runConfiguration.getMemorySize());
    }

    private void validateMemorySize(int memorySize) {
        // throw an exception if memory input is not valid
    }

    private void validateExpression(String expression) {
        // throw an exception if expression input is not valid
    }

}
