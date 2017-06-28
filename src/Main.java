import sequence.NumDataSequence;
import sequence.NumSequenceGenerator;
import sort.simple.NumSorter;

public class Main {
    public static void main(String[] args) {
        System.out.print("dataNum,");
        for (double k = 0.00; k <= 1.00; k += 0.10) {
            System.out.printf("%.1f comp,%.1f swap,", k, k);
        }
        System.out.println("");
        for (int i = 0; i <= 1000; i+= 10) {
            System.out.printf("%d,", i);
            for (double j = 0.00; j <= 1.00; j += 0.10) {
                NumDataSequence dataSeq1 = NumSequenceGenerator.generateByShuffle(i, j);
                NumSorter.select(dataSeq1);
                System.out.printf("%d,%d,", dataSeq1.compareCount, dataSeq1.swapCount);
                dataSeq1.reset();
            }
            System.out.println("");
        }

        NumDataSequence dataSeq2 = NumSequenceGenerator.generateByShuffle(10000, 1.00);
        NumSorter.insert(dataSeq2);
        dataSeq2.showResult("挿入");
    }
}
