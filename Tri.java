/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author asus
 */
public class Tri implements Sorter {
   
    @Override
    public <C, V> void sort(C container, Sizer<C> sizer, Getter<C, V> getter, Setter<C, V> setter, Comparator<V> comparator) {
        int size = sizer.size(container);
        for (int i = size - 1; i > 0; i--) {
            V vi = getter.get(container, i);
            for (int j = 0; j < i; j++) {
                V vj = getter.get(container, j);
                if (comparator.compare(vi, vj) < 0) {
                    setter.set(container, i, vj);
                    setter.set(container, j, vi);
                    vi = vj;
                }
            }
        }
    }
public static void main(String[] args) {
        int[] tab = { 7, 4, 1, 8, 5, 2, 9, 6, 3 };
        new Tri().sort(tab);
        System.out.println(Arrays.toString(tab));
    }
   
}
    

