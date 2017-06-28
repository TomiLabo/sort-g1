import sequence.NumDataSequence;
import sequence.NumSequenceGenerator;

public class Main {
    public static void main(String[] args) {
        NumDataSequence dataSeq = NumSequenceGenerator.generateByShuffle(20, 0.99);
    }
}
