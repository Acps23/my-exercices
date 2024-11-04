package io.codeforall.fanstatics;

public class Machine {
    public int performMonoOperation(MonoOperation operation, int operand) {
        return operation.square(operand);
    }

    public int performBiOperation(BiOperation operation, int operand1, int operand2) {
        return operation.sum(operand1, operand2);
    }


}
