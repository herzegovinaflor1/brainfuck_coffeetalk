package com.example;

import org.example.config.RunConfiguration;
import org.example.processor.impl.Interpreter;
import org.example.processor.Processor;
import org.junit.jupiter.api.Test;

class BrainFuckInterpreter {

    private final Processor processor = Interpreter.INTERPRETER;

    @Test
    void runWithInnerCycle() {
        String expression = "+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.";

        RunConfiguration runConfiguration = RunConfiguration.builder()
                .expression(expression)
                .memorySize(16)
                .enableLog(false)
                .build();

        processor.process(runConfiguration);

        // should print Hello, World!
    }

    @Test
    void runBasic() {
        String expression = ">++++++++[<+++++++++>-]<.>++++[<+++++++>-]<+.+++++++..+++.>>++++++[<+++++++>-]<++.------------.>++++++[<+++++++++>-]<+.<.+++.------.--------.>>>++++[<++++++++>-]<+.";


        RunConfiguration runConfiguration = RunConfiguration.builder()
                .expression(expression)
                .memorySize(16)
                .enableLog(false)
                .build();

        processor.process(runConfiguration);

        // should print Hello, World!
    }

    @Test
    void runBasicWithInnerCycleV2() {
        String expression = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        RunConfiguration runConfiguration = RunConfiguration.builder()
                .expression(expression)
                .memorySize(16)
                .enableLog(false)
                .build();

        processor.process(runConfiguration);

        // should print Hello, World!
    }

}
