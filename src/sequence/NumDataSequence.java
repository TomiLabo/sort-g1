package sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * @classdoc 正整数の配列を管理するクラス
 * @author maxmellon 
 */
public class NumDataSequence {
    public int compareCount = 0;
    public int swapCount = 0;
    private Integer[] raw;

    public NumDataSequence(final Integer[] dataList) {
        this.raw = dataList;
    }
    
    public void clearRecord() {
        compareCount = 0;
        swapCount = 0;
    }
    /**
     * <b>現在の配列の状態を出力する</b><br />
     * 例 : [ 1, 3, 4, 0, 2 ]
     * @return void
     */
    public void alphaShow() {
        System.out.print("[ ");
        for (int data: raw) {
            System.out.printf("%d ", data);
        }
        System.out.print("]\n");
    }
    
    /**
     * <b>l番目のデータとr番目のデータを入れ替える</b><br />
     * this.raw = dataList;
     * this.raw が [ 0, 2, 1 ] のとき，swap(1, 2) すると this.raw が [ 0, 1, 2 ] になる
     * @paraml {int} p1 スワップ前の左側の添字
     * @paramr {int} p2 スワップ前の右側の添字
     * @return void
     */
    public void swap(int p1, int p2) {
        swapCount++;
        Collections.swap(Arrays.asList(this.raw), p1, p2);
    }

    public void alphaSwapDebug(int p1, int p2) {
        swapCount++;
        System.out.println("交換 : ");
        System.out.print("前 : ");
        this.alphaShow();
        Collections.swap(Arrays.asList(this.raw), p1, p2);
        System.out.print("後 : ");
        this.alphaShow();
    }
   
    public boolean sortIfNeeded(int p1, int p2) {
        if (this.order(p1, p2)) {
            this.swap(p1, p2);
            return true;
        }
        return false;
    }
    
    public boolean order(int p1, int p2) {
        compareCount++;
        return this.raw[p1] <= this.raw[p2];
    }

    public boolean orderBy(OrderType type, int p1, int p2) {
        compareCount++;
        switch (type) {
        case ASC:
            return this.raw[p1] <= this.raw[p2];
        case DESC:
            return this.raw[p1] >= this.raw[p2];
        default:
            return false;
        }
    }

    public int[] getAll() {
        // retutn copy object, because `this.raw` should not be written by outside.
        int array[] = new int[this.raw.length];
        for (int i = 0; i < this.raw.length; i++) {
            array[i] = this.raw[i];
        }
        return array;
    }
    

    public int size() {
        return this.raw.length;
    }
    
    /**
     * <b>自身のデータがソート済みかどうかを判定する</b><br />
     * 例1 : this.raw が [ 0, 1, 2, 3 ] のとき // => true <br />
     * 例2 : this.raw が [ 0, 2, 1, 2 ] のとき // => false 
     * @return boolean
     */
    public boolean isSorted() {
        for (int i = 0; i < this.raw.length; i++) {
            if (this.raw[i - 1] > this.raw[i]) { return false; }
        }
        return true;
    }

    /**
     * <b>自身のデータが <i>range番目まで</i>ソート済みかどうかを判定する</b><br />
     * @param range 0 から range番目まで の range
     * @return boolean
     */
    public boolean isSorted(int range) {
        for (int i = 1; i < range; i++) {
            if (this.raw[i - 1] > this.raw[i]) { return false; }
        }
        return true;
    }

    public boolean isSorted(int range, OrderType type) {
        for (int i = 0; i < range; i++) {
            switch (type) {
            case ASC:
                if (this.raw[i - 1] > this.raw[i]) { return false; }
            case DESC:
                if (this.raw[i - 1] < this.raw[i]) { return false; }
            }
        }
        return true;
    }

    public void showResult(final String type) {
        System.out.printf("\t| 比較回数\t\t交換回数\n");
        System.out.printf("%s\t| %d\t\t\t%d\n", type, this.compareCount, this.swapCount);
    }
    
    public void showResultCSV() {
        System.out.printf("%10d,%10d,%10d,\n", this.raw.length, this.compareCount, this.swapCount);
    }
}
