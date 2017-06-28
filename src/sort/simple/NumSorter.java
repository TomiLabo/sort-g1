package sort.simple;

import sequence.NumDataSequence;

public class NumSorter {
    public static void select(NumDataSequence seq) {
        int p = -1;
        for (int i = 0; i < seq.size(); i++) {
            p = i;
            for (int j = i + 1; j < seq.size(); j++) {
                if (!seq.order(p, j)) { p = j; }
            }
            seq.swap(i, p);
        }
    }
    
    public static void insert(NumDataSequence seq) {
        for (int i = 0; i < seq.size() - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (seq.order(j, j + 1)) break;
                seq.swap(j, j + 1);
            }
        }
    }

}
