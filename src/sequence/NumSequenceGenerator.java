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
        Random randFunc = new Random();
        for (int i = 0; i < size; i++) {
            if (Math.random() > probability) { continue; }
            int right = randFunc.nextInt(size);
            dataSequence.swap(i, right);
        }
        return dataSequence;
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
