/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author asus
*/
     @FunctionalInterface
public interface Sorter {
     /**
     * Tri d'un objet quelconque.
     * @param container l'objet qui contient les valeurs à trier et qui sera trié à la fin de la méthode
     * @param sizer la méthode de calcul du nombre de valeurs à trier
     * @param getter la méthode d'accès à une des valeurs à trier
     * @param setter la méthode d'affectation d'une des valeurs triées
     * @param comparator la méthode de comparaison de deux valeurs à trier
     * @param <C> le type de l'objet qui contient les valeurs à trier
     * @param <V> le type des valeurs à trier
     */
    <C, V> void sort(C container, Sizer<C> sizer, Getter<C, V> getter, Setter<C, V> setter, Comparator<V> comparator);

    /** Tri d'une liste d'objets de type quelconque selon un Comparator */
    default <V> void sort(List<V> container, Comparator<V> comparator) {
        sort(container, List::size, List::get, List::set, comparator);
    }

    /** Tri d'une liste d'objets Comparable */
    default <V extends Comparable<V>> void sort(List<V> container) {
        sort(container, V::compareTo);
    }

    /** Tri d'un tableau d'objets de type quelconque selon un Comparator */
    default <V> void sort(V[] container, Comparator<V> comparator) {
        sort(container, c -> c.length, (c, i) -> c[i], (c, i, v) -> c[i] = v, comparator);
    }

    /** Tri d'un tableau d'objets Comparable */
    default <V extends Comparable<V>> void sort(V[] container) {
        sort(container, V::compareTo);
    }

    /** Tri d'un tableau de boolean */
    default void sort(boolean[] container) {
        sort(container, Array::getLength, Array::getBoolean, Array::setBoolean, Boolean::compare);
    }

    /** Tri d'un tableau de byte */
    default void sort(byte[] container) {
        sort(container, Array::getLength, Array::getByte, Array::setByte, Byte::compare);
    }

    /** Tri d'un tableau de char */
    default void sort(char[] container) {
        sort(container, Array::getLength, Array::getChar, Array::setChar, Character::compare);
    }

    /** Tri d'un tableau de int */
    default void sort(int[] container) {
        sort(container, Array::getLength, Array::getInt, Array::setInt, Integer::compare);
    }

    /** Tri d'un tableau de long */
    default void sort(long[] container) {
        sort(container, Array::getLength, Array::getLong, Array::setLong, Long::compare);
    }

    /** Tri d'un tableau de float */
    default void sort(float[] container) {
        sort(container, Array::getLength, Array::getFloat, Array::setFloat, Float::compare);
    }

    /** Tri d'un tableau de double */
    default void sort(double[] container) {
        sort(container, Array::getLength, Array::getDouble, Array::setDouble, Double::compare);
    }

    @FunctionalInterface
    static interface Getter<C, V> {
        V get(C container, int index);
    }

    @FunctionalInterface
    static interface Setter<C, V> {
        void set(C container, int index, V value);
    }

    @FunctionalInterface
    static interface Sizer<C> {
        int size(C container);
    }

    
}
