package sequence;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @classdoc 正整数の配列を管理するクラス
 * @author maxmellon 
 */
public class NumDataSequence {
    private int compareCount = 0;
    private int swapCount = 0;
    private ArrayList<Integer> raw;

    public NumDataSequence() {
        
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
     * <b>自身のデータがソート済みかどうかを判定する</b><br />
     * 例1 : this.raw が [ 2, 3, 4, 5 ] のとき // => true <br />
     * 例2 : this.raw が [ 2, 4, 3, 5 ] のとき // => false 
     * @return boolean
     */
    public boolean isSorted() {
        for (int i = 0; i < this.raw.size(); i++) {
            if (this.raw.get(i - 1) > this.raw.get(i)) { return false; }
        }
        return true;
    }
    
    /**
     * <b>l番目のデータとr番目のデータを入れ替える</b><br />
     * this.raw が [ 2, 4, 3 ] のとき，swap(1, 2) すると this.raw が [ 2, 3, 4 ] になる
     * @param l スワップ前の左側の添字
     * @param r スワップ前の右側の添字
     * @return void
     */
    public void swap(int l, int r) {
        swapCount++;
        Collections.swap(this.raw, l, r);
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
        // retutn copy object, because `this.raw` be should not write by outside.
        int array[] = new int[this.raw.size()];
        for (int i = 0; i < this.raw.size(); i++) {
            array[i] = this.raw.get(i);
        }
        return array;
    }
    

    public boolean isSorted(OrderType type) {
        for (int i = 0; i < this.raw.size(); i++) {
            switch (type) {
            case ASC:
                if (this.raw.get(i - 1) > this.raw.get(i)) { return false; }
            case DESC:
                if (this.raw.get(i - 1) < this.raw.get(i)) { return false; }
            }
        }
        return true;
    }
}
