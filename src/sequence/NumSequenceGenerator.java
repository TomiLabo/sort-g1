package sequence;

import java.util.Random;

public class NumSequenceGenerator {

    public static NumDataSequence generateOfSorted(int size) {
        int[] dataList = new int[size];
        for (int i = 0; i < size; i++) {
            dataList[i] = i;
        }
        return new NumDataSequence(dataList);
    }
     
    public static NumDataSequence generateByRandom(int size) {
        int[] dataList = new int[size];
        Random randFunc = new Random();
        for (int i = 0; i < size; i++) {
            dataList[i] = randFunc.nextInt(size);
        }
        return new NumDataSequence(dataList);
    }
    
    public static NumDataSequence generateByShuffle(int size, double probability) {
        NumDataSequence dataSequence = NumSequenceGenerator.generateOfSorted(size);
        if (probability > 1.00) {
            System.out.println(
                    "[WARNING]"
                    + " NumSequenceGenerator.generateByShuffle()"
                    + " unexpected probability. probability is expected lower 1.00."
                );
        }
        for (int i = 0; i < size; i++) {
            if (Math.random() > probability) { continue; }
            int right = getUniqNumber(i, size);
            dataSequence.swap(i, right);
        }
        return dataSequence;
    }
    
    private static int getUniqNumber(int unexpectedNum, int range) {
        boolean generated = false;
        Random randFunc = new Random();
        while (!generated) {
            int right = randFunc.nextInt(range);
            if (right == unexpectedNum) continue;
            return right;
        }
        return -1;
    }
    
    public static NumDataSequence generateByExchange(int size, int changeCount) {
        NumDataSequence dataSequence = NumSequenceGenerator.generateOfSorted(size);
        Random randFunc = new Random();
        while (changeCount > 0) {
            int left = randFunc.nextInt(size);
            int right = randFunc.nextInt(size);
            dataSequence.swap(left, right);
            changeCount--;
        }
        return dataSequence;
    }
}
