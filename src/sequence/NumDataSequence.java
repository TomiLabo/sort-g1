package sequence;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @classdoc 正整数の配列を管理するクラス
 * @author maxmellon 
 */
public class NumDataSequence {
    public int compareCount = 0;
    public int swapCount = 0;
    private ArrayList<Integer> raw = new ArrayList<Integer>();

    public NumDataSequence(final int[] dataList) {
        for (int i = 0; i < dataList.length; i++) {
            this.raw.add(dataList[i]);
        }
    }
    
    public void reset() {
        compareCount = 0;
        swapCount = 0;
    }
    /**
     * <b>現在の配列の状態を出力する</b><br />
     * 例 : [ 1, 3, 4, 0, 2 ]
     * @return void
     */
    public void show() {
        System.out.print("[ ");
        for (int data: raw) {
            System.out.printf("%d ", data);
        }
        System.out.print("]\n");
    }
    
    
    /**
     * <b>l番目のデータとr番目のデータを入れ替える</b><br />
     * this.raw が [ 0, 2, 1 ] のとき，swap(1, 2) すると this.raw が [ 0, 1, 2 ] になる
     * @param l スワップ前の左側の添字
     * @param r スワップ前の右側の添字
     * @return void
     */
    public void swap(int l, int r) {
        swapCount++;
        Collections.swap(this.raw, l, r);
    }

    public void swapDebug(int l, int r) {
        swapCount++;
        System.out.println("交換 : ");
        System.out.print("前 : ");
        this.show();
        Collections.swap(this.raw, l, r);
        System.out.print("後 : ");
        this.show();
    }
    
    public boolean order(int l, int r) {
        compareCount++;
        return this.raw.get(l) <= this.raw.get(r);
    }

    public boolean orderBy(OrderType type, int l, int r) {
        compareCount++;
        switch (type) {
        case ASC:
            return this.raw.get(l) <= this.raw.get(r);
        case DESC:
            return this.raw.get(l) >= this.raw.get(r);
        default:
            throw new IndexOutOfBoundsException(
                    "NumDataSequence::compare, 期待しないOrderTypeが渡されました"
                    );
        }
    }

    public int[] getAll() {
        // retutn copy object, because `this.raw` should not be written by outside.
        int array[] = new int[this.raw.size()];
        for (int i = 0; i < this.raw.size(); i++) {
            array[i] = this.raw.get(i);
        }
        return array;
    }
    

    public int size() {
        return this.raw.size();
    }
    
    /**
     * <b>自身のデータがソート済みかどうかを判定する</b><br />
     * 例1 : this.raw が [ 0, 1, 2, 3 ] のとき // => true <br />
     * 例2 : this.raw が [ 0, 2, 1, 2 ] のとき // => false 
     * @return boolean
     */
    public boolean isSorted() {
        for (int i = 0; i < this.raw.size(); i++) {
            if (this.raw.get(i - 1) > this.raw.get(i)) { return false; }
        }
        return true;
    }

    /**
     * <b>自身のデータが <i>range番目まで</i>ソート済みかどうかを判定する</b><br />
     * @param range 0 から range番目まで の range
     * @return boolean
     */
    public boolean isSorted(int range) {
        if (range > this.raw.size()){
            throw new IndexOutOfBoundsException(
                "NumDataSequence::isSorted(int) 範囲外の range が渡されました。"
                );
        }
        for (int i = 0; i < range; i++) {
            if (this.raw.get(i - 1) > this.raw.get(i)) { return false; }
        }
        return true;
    }

    public boolean isSorted(OrderType type) {
        for (int i = 0; i < this.raw.size(); i++) {
            switch (type) {
            case ASC:
                if (this.raw.get(i - 1) > this.raw.get(i)) { return false; }
            case DESC:
                if (this.raw.get(i - 1) < this.raw.get(i)) { return false; }
            default:
                throw new IndexOutOfBoundsException(
                        "NumDataSequence::isSorted(OrderType), 期待しないOrderTypeが渡されました"
                        );
            }
        }
        return true;
    }

    public boolean isSorted(OrderType type, int range) {
        if (range > this.raw.size()){
            throw new IndexOutOfBoundsException(
                "NumDataSequence::isSorted(OrderType,int), 範囲外の range が渡されました。"
                );
        }
        for (int i = 0; i < range; i++) {
            switch (type) {
            case ASC:
                if (this.raw.get(i - 1) > this.raw.get(i)) { return false; }
            case DESC:
                if (this.raw.get(i - 1) < this.raw.get(i)) { return false; }
            default:
                throw new IndexOutOfBoundsException(
                        "NumDataSequence::isSorted(OrderType,int), 期待しないOrderTypeが渡されました"
                        );
            }
        }
        return true;
    }

    public void showResult(final String type) {
        System.out.printf("\t| 比較回数\t\t交換回数\n");
        System.out.printf("%s\t| %d\t\t\t%d\n", type, this.compareCount, this.swapCount);
    }
    
    public void showResultCSV() {
        System.out.printf("%10d,%10d,%10d,\n", this.raw.size(), this.compareCount, this.swapCount);
    }
}
