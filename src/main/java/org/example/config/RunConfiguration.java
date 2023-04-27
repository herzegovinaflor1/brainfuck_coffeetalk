package org.example.config;

public class RunConfiguration {

    private final String expression;
    private final int memorySize;
    private final boolean enableLog;

    private RunConfiguration(ComputerBuilder builder) {
        this.expression = builder.expression;
        this.memorySize = builder.memorySize;
        this.enableLog = builder.enableLog;
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    public String getExpression() {
        return expression;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public boolean isEnableLog() {
        return enableLog;
    }

    public static class ComputerBuilder {

        private String expression;
        private int memorySize;
        private boolean enableLog;

        public ComputerBuilder() {

        }

        public RunConfiguration build() {
            return new RunConfiguration(this);
        }

        public ComputerBuilder expression(String expression) {
            this.expression = expression;
            return this;
        }

        public ComputerBuilder memorySize(int memorySize) {
            this.memorySize = memorySize;
            return this;
        }

        public ComputerBuilder enableLog(boolean enableLog) {
            this.enableLog = enableLog;
            return this;
        }
    }


}
